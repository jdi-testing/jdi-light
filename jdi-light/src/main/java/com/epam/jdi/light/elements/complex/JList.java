package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.ListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.settings.TimeoutSettings;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

public class JList<T extends BaseUIElement> extends JDIBase implements IList<T>, SetValue, ISetup {
    protected CacheValue<List<WebElement>> webElements = new CacheValue<>();

    public JList() {}
    public JList(By locator) { setLocator(locator); }
    public JList(List<WebElement> elements) {
        this.webElements.setForce(elements);
    }
    protected Class<?> initClass = UIElement.class;
    public JList<T> setInitClass(Class<T> listClass) {
        initClass = listClass;
        return this;
    }
    public void setup(Field field) {
        Type[] types;
        try {
            types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        } catch (Exception ex) { return; }
        if (types.length != 1) return;
        try {
            Class<?> initClass = (Class<?>) types[0];
            if (initClass == WebElement.class)
                initClass = UIElement.class;
            setInitClass((Class<T>) initClass);
        } catch (Exception ex) { throw  exception("Can't init WebList. Weblist elements should extend UIElement"); }
    }
    private boolean isActual() {
        try {
            webElements.get().get(0).getTagName();
            return true;
        } catch (Exception ex) { return false; }
    }
    private T getNewInstance(WebElement element) {
        try {
            T instance = (T) initClass.newInstance();
            instance.setWebElement(element).setName(getName());
            instance.setTypeName(varName);
            instance.setParent(parent);
            instance.setLocator(getLocator());
            return instance;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }
    @JDIAction(level = DEBUG)
    public List<T> elements() {
        try {
            if (webElements.hasValue() && isActual())
                return LinqUtils.map(webElements.get(), this::getNewInstance);
            List<WebElement> result = getAll();
            if (result.size() > 0)
                webElements.set(result);
            return LinqUtils.map(result, this::getNewInstance);
        } catch (Exception ex) { return new ArrayList<>(); }
    }

    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        get(value).click();
    }
    @JDIAction("Select ({0}) for '{name}'")
    public void select(String... names) {
        for (String value : names)
            select(value);
    }
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum> void select(TEnum... names) {
        for (TEnum value : names)
            select(value);
    }
    private String NO_ELEMENTS_FOUND = "Can't select '%s'. No elements with this name found";
    @JDIAction(level = DEBUG)
    public T get(String value) {
        if (getLocator().toString().contains("%s"))
            return getNewInstance(super.get(value));
        List<WebElement> elements = new Timer(TIMEOUT.get()*1000)
            .getResultByCondition(this::getAll, r -> r.size() > 0);
        if (elements == null || elements.size() == 0)
            throw exception(NO_ELEMENTS_FOUND, value);
        if (elements.size() == 1) {
            String tagName = elements.get(0).getTagName();
            WebElement element = elements.get(0);
            switch (tagName) {
                case "ul" : elements = element.findElements(By.tagName("li")); break;
                case "select" : elements = element.findElements(By.tagName("option")); break;
            }
        }
        List<T> htmlElements = LinqUtils.map(elements, this::getNewInstance);
        T el = LinqUtils.first(htmlElements, e -> e.getText().equals(value));
        if (el == null) {
            //el = LinqUtils.first(uiElements, e -> verifyLabel(e, name));
            //if (el == null)
            throw exception(NO_ELEMENTS_FOUND, value);
        }
        return el;
    }
    public T get(Enum name) {
        return get(getEnumValue(name));
    }
    @JDIAction("Select '{0}' for '{names}'")
    public void select(int index) {
        get(index).click();
    }
    @JDIAction("Get '{names}' selected value")
    public String selected() {
        T first = logger.logOff(() ->
                LinqUtils.first(elements(), BaseUIElement::isSelected) );
        return first != null ? first.getText() : "";
    }
    public List<String> values() {
        return LinqUtils.map(elements(), T::getText);
    }
    @JDIAction(level = DEBUG)
    public void refresh() {
        webElements.clear();
    }
    @JDIAction(level = DEBUG)
    public String isSelected() {
        T first = logger.logOff(() ->
            LinqUtils.first(elements(), T::isSelected) );
        return first != null ? first.getText() : "";
    }

    @JDIAction(level = DEBUG)
    public void clear() {
        webElements.clear();
    }

    @JDIAction(level = DEBUG)
    public T get(int index) {
        List<T> elements = elements();
        if (elements.size() <= index)
            throw exception("Can't get element with index '%s'. Found only '%s' elements", index, elements.size());
        T element = elements.get(index);
        element.name = format("%s[%s]", getName(), index);
        return element;
    }

    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return print(values());
    }
    @JDIAction
    public void showAll() {
        int size;
        do {
            size = size();
            get(size-1).show();
            clear();
        } while (size < size());
    }

    //region matchers
    public ListAssert<T> is() {
        return new ListAssert<>(this, toError());
    }
    public ListAssert<T> assertThat() {
        return is();
    }
    //endregion
}