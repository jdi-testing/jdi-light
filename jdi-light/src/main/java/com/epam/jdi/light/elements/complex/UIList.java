package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.map.MapArray;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static org.hamcrest.MatcherAssert.assertThat;

public class UIList<T> extends JDIBase implements IList<T> {

    private CacheValue<MapArray<String, T>> elements = new CacheValue<>();
    private CacheValue<List<T>> values = new CacheValue<>();
    private Class<T> classType;
    public String titleFieldName = NO_TITLE_FIELD;
    public static final String NO_TITLE_FIELD = "NO TITLE FIELD";

    public UIList(Class<T> classType) {
        this.classType = classType;
        elements.setForce(new MapArray<>());
        values.setForce(new ArrayList<>());
    }
    @JDIAction(level = DEBUG)
    public List<T> elements() {
        if (values.hasValue())
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
            if (isClass(Section.class)) {
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

    public <E> List<E> asData(Class<E> entityClass) {
        return getMap().select((k, v) -> UIUtils.asEntity(v, entityClass));
    }

    @JDIAction(level = DEBUG)
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
    @JDIAction
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
        return getMap().toString();
    }

    public <E> void is(Class<E> entityClass, Matcher<Collection<? extends E>> condition) {
        assertThat(asData(entityClass), condition);
    }
}