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
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;

public class UIElements<T extends Section> extends JDIBase implements IList<T> {

    private CacheValue<MapArray<String, T>> elements;
    private CacheValue<List<T>> values;
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
    public List<T> values() {
        if (elements.isUseCache()) {
            if (values.hasValue())
                return values.get();
            if (elements.hasValue())
                return elements.get().values();
        } else values.clear();
        return values.set(LinqUtils.select(this.getAll(), this::initElement));
    }
    public MapArray<String, T> getMap() {
        if (elements.isUseCache())
            if (elements.hasValue())
                return elements.get();
        else  { elements.clear(); values.clear(); }
        elements.set(values.hasValue()
            ? new MapArray<>(
                LinqUtils.select(this.getAll(), this::elementTitle),
                values.get())
            : new MapArray<>(this.getAll(),
                this::elementTitle,
                this::initElement));
        return elements.get();
    }
    @Override
    public boolean isEmpty() {
        return this.getMap().size() == 0;
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

        // Get title from annotation
        List<Field> expectedFields = LinqUtils.where(fields, f -> f.isAnnotationPresent(Title.class));
        if (expectedFields.size() != 1)
            throw exception("Entity should have only 1 @Title annotation. Please correct '%s' class", classType.getSimpleName());
        titleFieldName = expectedFields.get(0).getName();
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    public String getValue() {
        return null;
    }
}