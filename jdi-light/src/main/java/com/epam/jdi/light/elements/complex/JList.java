package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.ListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
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


    protected Class<?> initClass = UIElement.class;
    public JList<T> setInitClass(Class<T> listClass) {
        initClass = listClass;
        return this;
    }

    @JDIAction(level = DEBUG)
    public List<T> elements(int minAmount) {
        if (elements.hasValue() && isActual() && elements.get().size() >= minAmount)
            return elements.get();
        if (getLocator().toString().contains("%s"))
            throw exception("You call method that can't be used with template locator. " +
                    "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(getLocator()));
        return this.elements.set(toJList(getList(minAmount)));
    }

    private String NO_ELEMENTS_FOUND = "Can't select '%s'. No elements with this name found";

    @JDIAction(level = DEBUG)
    public T get(String value) {
        if (getLocator().toString().contains("%s")) {
            T element = getNewInstance(super.get(value)).setName(value);
            element.setGetFunc(() -> super.get(value));
            return element;
        }
        refresh();
        T el = first(e -> e.getText().equals(value));
        if (el == null)
            throw exception(NO_ELEMENTS_FOUND, value);
        el.setName(value);
        el.setGetFunc(() -> first(e -> e.getText().equals(value)));
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
        return elements(index).get(index).setName(format("%s[%s]", getName(), index));
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
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String... values) {
        if (ArrayUtils.isEmpty(values))
            throw exception("Nothing to select in %s", getName());
        int length = values.length;
        for (int i=0; i < length-1;i++) {
            get(values[i]).hover();
        }
        get(values[length-1]).click();
    }
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String values) {
        String[] split = values.split(">");
        if (split.length == 1)
            select(split[0]);
        else hoverAndClick(split);
    }
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum> void select(TEnum... names) {
        for (TEnum value : names)
            select(value);
    }
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        get(index).click();
    }
    @JDIAction("Select ({0}) for '{name}'")
    public void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        refresh();
        T first = logger.logOff(() -> first(BaseUIElement::isSelected) );
        return first != null ? first.getText() : "";
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

    public List<String> innerValues() {
        refresh();
        return map(T::innerText);
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
    public ListAssert<T> has() {
        return is();
    }
    public ListAssert<T> waitFor() {
        return is();
    }
    public ListAssert<T> shouldBe() {
        return is();
    }
    //endregion
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
            T instance = create(initClass);
            instance.setWebElement(element).setName(getName());
            instance.setTypeName(typeName);
            instance.setParent(parent);
            return instance;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }
}