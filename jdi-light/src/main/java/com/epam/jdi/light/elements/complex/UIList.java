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
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.InitActions.getGenericTypes;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

public class UIList<T extends Section, E> extends JDIBase implements IList<T>, ISetup {

    private CacheValue<MapArray<String, T>> elements = new CacheValue<>(MapArray::new);
    private CacheValue<List<T>> values = new CacheValue<>(ArrayList::new);
    public Class<T> classType;
    public Class<E> dataType;
    public String titleFieldName = null;

    public UIList() {}
    public UIList(Class<T> type) { classType = type; }

    private boolean isActual(T element) {
        try {
            element.get().getTagName();
            return true;
        } catch (Exception ex) { return false; }
    }
    @JDIAction(level = DEBUG)
    public List<T> elements() {
        if (values.hasValue() && isActual(values.get().get(0)))
            return values.get();
        if (elements.hasValue())
            return elements.get().values();
        List<WebElement> els = getAll();
        if (els.size() > 0)
            values.set(LinqUtils.select(
                    Timer.getByCondition(() -> els, l -> l.size() > 0), this::initElement));
        else
            System.out.println("test");
        return values.get();
    }
    @JDIAction(level = DEBUG)
    public void clear() {
        elements.clear();
        values.clear();
    }
    public MapArray<String, T> getMap() {
        if (elements.hasValue() && isActual(elements.get().values().get(0)))
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
            titleFieldName = GET_TITLE_FIELD_NAME.execute(this);
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
            T section = classType.newInstance();
            if (isClass(classType, Section.class)) {
                section.setWebElement(el);
                section.parent = this;
            }
            SiteInfo info = new SiteInfo();
            info.instance = section;
            info.driverName = driverName;
            initElements(info);
            return section;
        } catch (Exception ex) {
            throw exception("Can't instantiate list element");
        }
    }

    public E getData(String name) {
        return get(name).asEntity(dataType);
    }
    public E getData(Enum name) {
        return getData(getEnumValue(name));
    }
    public E getData(int index) {
        return get(index).asEntity(dataType);
    }

    public List<E> asData() {
        try {
            if (dataType == null) return null;
            return getMap().select((k, v) -> UIUtils.asEntity(v, dataType));
        } catch (Exception ex) {
            throw exception("Can't get UIList data" + LINE_BREAK + ex.getMessage());
        }
    }

    @JDIAction(level = DEBUG)
    public T get(String name) {
        return getMap().get(name);
    }

    public static JFunc1<UIList, String> GET_TITLE_FIELD_NAME = list -> {
        Field[] fields = list.classType.getFields();
        Field expectedFields = LinqUtils.first(fields, f -> f.isAnnotationPresent(Title.class));
        if (expectedFields == null)
            throw exception("No title name specified for '%s' class", list.classType.getSimpleName());
        return expectedFields.getName();
    };

    @JDIAction("Scroll to list elements")
    public void showAll() {
        if (!isClass(classType, Section.class))
            throw exception("Show all can be executed only for List of Sections. Please add ' extend Section' to your PageObject class in List");
        int size;
        do {
            size = size();
            js().executeScript("arguments[0].scrollIntoView(true);", get(size-1).get());
            clear();
        } while (size < size());
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    public String getValue() {
        return PrintUtils.print(LinqUtils.map(asData(), Object::toString));
    }

    public void is(Matcher<? super List<E>> condition) {
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

    public void setup(Field field) {
        try {
            Type[] types = getGenericTypes(field);
            if (types.length == 0)
                throw exception("Can't setup UIList generic parameters for field '%s'. Actual 0 but expected 1 or 2",
                        field.getName());
            if (types.length > 2)
                throw exception("Can't setup UIList generic parameters for field '%s'. Actual more than %s but expected 1 or 2",
                        field.getName(), types.length);
            classType = types[0].toString().equals("?") ? null : (Class<T>)types[0];
            dataType = types.length == 1 || types[1].toString().equals("?") ? null : (Class<E>)types[1];
        } catch (Exception ex) {
            throw exception("Can't instantiate List<%s, %s> field '%s'", classType == null
                            ? "?" : classType.getSimpleName(), dataType == null ? "?" : dataType.getSimpleName(),
                    field.getName());
        }
    }
}