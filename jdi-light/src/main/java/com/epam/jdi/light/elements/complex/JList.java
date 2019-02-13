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
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JList<T extends BaseUIElement> extends JDIBase
        implements IList<T>, SetValue, ISetup, ISelector {
    protected CacheValue<List<T>> elements = new CacheValue<>();

    public JList() {}
    public JList(By locator) { setLocator(locator); }
    public JList(List<WebElement> elements) {
        this.elements.setForce(toJList(elements));
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
    @JDIAction("Select '{0}' for '{names}'")
    public void select(int index) {
        get(index).click();
    }
    @JDIAction("Select ({0}) for '{name}'")
    public void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }
    @JDIAction("Get '{names}' selected value")
    public String selected() {
        T first = logger.logOff(() -> first(BaseUIElement::isSelected) );
        return first != null ? first.getText() : "";
    }
    @JDIAction(level = DEBUG)
    public String isSelected() {
        T first = logger.logOff(() -> first(T::isSelected) );
        return first != null ? first.getText() : "";
    }

    private String NO_ELEMENTS_FOUND = "Can't select '%s'. No elements with this name found";

    @JDIAction(level = DEBUG)
    public List<T> elements() {
        try {
            if (elements.hasValue() && isActual())
                return elements.get();
            if (getLocator().toString().contains("%s"))
                return new ArrayList<>();
            List<WebElement> elements = getAll();
            if (elements.size() == 0)
                throw exception("No elements found (%s)", toString());
            if (elements.size() == 1) {
                WebElement element = elements.get(0);
                String tagName = element.getTagName();
                switch (tagName) {
                    case "ul":
                        elements = element.findElements(By.tagName("li"));
                        break;
                    case "select":
                        elements = element.findElements(By.tagName("option"));
                        break;
                }
            }
            return this.elements.set(toJList(elements));
        } catch (Exception ex) { return new ArrayList<>(); }
    }
    @JDIAction(level = DEBUG)
    public T get(String value) {
            if (getLocator().toString().contains("%s"))
                return getNewInstance(super.get(value));
            refresh();
            T el = LinqUtils.first(elements(), e -> e.getText().equals(value));
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

    @JDIAction(level = DEBUG)
    public T get(int index) {
        if (index < 0)
            throw exception("Can't get element with index '%s'. Index should be more than 0", index);
        if (getLocator().toString().contains("%s")) {
            WebElement element;
            try {
                element = super.get(index + "");
            } catch (Exception ex) {
                throw exception("Can't get element with index '%s' for template locator. " +
                    "Maybe locator is wrong or you need to get element by name. Exception: %s",
                        index, ex.getMessage());
            }
            return getNewInstance(element);
        }
        if (size() < index) {
            refresh();
            if (size() < index)
                throw exception("Can't get element with index '%s'. Found only '%s' elements", index, size());
        }
        return elements().get(index)
            .setName(format("%s[%s]", getName(), index));
    }

    @JDIAction(level = DEBUG)
    public void refresh() {
        elements.clear();
    }

    @JDIAction(level = DEBUG)
    public void clear() {
        refresh();
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


    @Override
    public boolean selected(String option) {
        return get(option).isSelected();
    }

    @Override
    public List<String> checked() {
        return ifSelect(BaseUIElement::isSelected,
                BaseUIElement::getText);
    }

    public List<String> values() {
        refresh();
        return map(T::getText);
    }

    @Override
    public List<String> listEnabled() {
        return ifSelect(JDIBase::isEnabled,
                BaseUIElement::getText);
    }

    @Override
    public List<String> listDisabled() {
        return ifSelect(JDIBase::isDisabled,
                BaseUIElement::getText);
    }

    //region matchers
    public ListAssert<T> is() {
        refresh();
        return new ListAssert<>(this, this, toError());
    }
    public ListAssert<T> assertThat() {
        return is();
    }
    //endregion

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
            return elements.get().size() > 0 && isNotBlank(elements.get().get(0).getTagName());
        } catch (Exception ex) { return false; }
    }
    private List<T> toJList(List<WebElement> webElements) {
        return LinqUtils.map(webElements, this::getNewInstance);
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
}