package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.stream.IntStream.rangeClosed;

public class UIElements<T extends Section> extends JDIBase implements IList<T> {

    private CacheValue<MapArray<String, T>> elements = new CacheValue<>();
    private CacheValue<List<T>> values = new CacheValue<>();
    private Class<T> classType;
    public String titleFieldName = NO_TITLE_FIELD;
    public static final String NO_TITLE_FIELD = "NO TITLE FIELD";

    public UIElements(Class<T> classType) {
        this.classType = classType;
        elements.setForce(new MapArray<>());
        values.setForce(new ArrayList<>());
    }
    public void refresh() {
        elements.clear();
        values.clear();
    }
    public List<T> elements() {
        if (values.hasValue())
            return values.get();
        if (elements.hasValue())
            return elements.get().values();
        return values.set(LinqUtils.select(this.getAll(), this::initElement));
    }
    public MapArray<String, T> getMap() {
        if (elements.hasValue())
            return elements.get();
        List<WebElement> els = getAll();
        return elements.set(values.hasValue()
            ? new MapArray<>(
                LinqUtils.select(els, this::elementTitle),
                values.get())
            : new MapArray<>(els,
                this::elementTitle,
                this::initElement));
    }

    private String elementTitle(WebElement el) {
        if (titleFieldName == null)
            identifyTitleField();
        return titleFieldName.equals(NO_TITLE_FIELD)
                ? el.getText()
                : getElementTitle(el, titleFieldName);
    }
    private String getElementTitle(WebElement el, String titleField) {
        T element = initElement(el);
        Field field = null;
        try { field = element.getClass().getField(titleField);
        } catch (NoSuchFieldException ex) { /* if titleField defined then field always exist */ }
        return ((WebElement) getValueField(field, element)).getText();
    }

    private T initElement(WebElement el) {
        try {
            T element = classType.newInstance();
            element.setWebElement(el);
            element.parent = this;
            initElements(element, driverName);
            return element;
        } catch (Exception ex) {
            throw exception("Can't instantiate list element");
        }
    }

    public <E> List<E> asData(Class<E> entityClass) {
        return getMap().select((k, v) -> v.asEntity(entityClass));
    }

    public T get(String name) {
        return getMap().get(name);
    }

    private void identifyTitleField() {
        Field[] fields = classType.getFields();
        Field expectedFields = LinqUtils.first(fields, f -> f.isAnnotationPresent(Title.class));
        if (expectedFields == null)
            throw exception("No title name specified for '%s' class", classType.getSimpleName());
        titleFieldName = expectedFields.getName();
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    public String getValue() {
        return getMap().toString();
    }

}