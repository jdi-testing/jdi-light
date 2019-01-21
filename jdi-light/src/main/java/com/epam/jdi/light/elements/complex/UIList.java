package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.UIListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.map.MapArray;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.epam.jdi.tools.ReflectionUtils.isClass;

public class UIList<T extends Section, E> extends JDIBase implements IList<T> {

    private CacheValue<MapArray<String, T>> elements = new CacheValue<>();
    private CacheValue<List<T>> values = new CacheValue<>();
    private Class<T> classType;
    private Class<E> entityType;
    public String titleFieldName = null;

    public UIList(Class<T> classType) {
        this.classType = classType;
        elements.setForce(new MapArray<>());
        values.setForce(new ArrayList<>());
    }
    public UIList(Class<T> classType, Class<E> entityType) {
        this(classType);
        this.entityType = entityType;
    }
    private boolean isActual() {
        try {
            elements.get().get(0).value.get().getTagName();
            return true;
        } catch (Exception ex) { return false; }
    }
    @JDIAction(level = DEBUG)
    public List<T> elements() {
        if (values.hasValue() && isActual())
            return values.get();
        if (elements.hasValue())
            return elements.get().values();
        return values.set(LinqUtils.select(
            Timer.getByCondition(() -> getAll(), l -> l.size() > 0), this::initElement));
    }
    @JDIAction(level = DEBUG)
    public void clear() {
        elements.clear();
        values.clear();
    }
    public MapArray<String, T> getMap() {
        if (elements.hasValue() && isActual())
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
            titleFieldName = identifyTitleField();
        return titleFieldName == null
            ? el.getText()
            : getElementTitle(el, titleFieldName);
    }
    private String getElementTitle(WebElement el, String titleField) {
        T element = initElement(el);
        Field field = null;
        try {
            field = element.getClass().getField(titleField);
        } catch (Exception ignore) { /* if field name identified it is always exist */ }
        return ((WebElement) getValueField(field, element)).getText();
    }

    private T initElement(WebElement el) {
        try {
            T element = classType.newInstance();
            if (isClass(classType, Section.class)) {
                Section section = (Section)element;
                section.setWebElement(el);
                section.parent = this;
            }
            SiteInfo info = new SiteInfo();
            info.instance = element;
            info.driverName = driverName;
            initElements(info);
            return element;
        } catch (Exception ex) {
            throw exception("Can't instantiate list element");
        }
    }

    public List<E> asData() {
        try {
            return getMap().select((k, v) -> UIUtils.asEntity(v, entityType));
        } catch (Exception ex) { return new ArrayList<>(); }
    }

    @JDIAction(level = DEBUG)
    public T get(String name) {
        return getMap().get(name);
    }

    private String identifyTitleField() {
        Field[] fields = classType.getFields();
        Field expectedFields = LinqUtils.first(fields, f -> f.isAnnotationPresent(Title.class));
        if (expectedFields == null)
            throw exception("No title name specified for '%s' class", classType.getSimpleName());
        return expectedFields.getName();
    }

    @JDIAction("Scroll to list elements")
    public void showAll() {
        if (!isClass(classType, Section.class))
            throw exception("Show all can be executed only for List of Sections. Please add ' extend Section' to your PageObject class in List");
        int size;
        do {
            size = size();
            js().executeScript("arguments[0].scrollIntoView(true);", ((Section)get(size-1)).get());
            clear();
        } while (size < size());
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    public String getValue() {
        return PrintUtils.print(LinqUtils.map(asData(), Object::toString));
    }

    //public void is(Matcher<Collection<? extends E>> condition) {
    public void is(Matcher<? super List<E>> condition) {
        //org.hamcrest.MatcherAssert.assertThat(asData(), condition);
        MatcherAssert.assertThat(asData(), condition);
    }
    public UIListAssert<T, E> is() {
        return new UIListAssert<>(elements(), asData(), toError());
    }
    public UIListAssert<T, E> assertThat() {
        return is();
    }

    public void assertThat(Matcher<? super List<E>> condition) {
        is(condition);
    }
}