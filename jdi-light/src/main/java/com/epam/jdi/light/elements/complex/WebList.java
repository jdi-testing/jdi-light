package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextType;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasText;
import com.epam.jdi.light.elements.interfaces.HasUIList;
import com.epam.jdi.light.elements.interfaces.IListBase;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.namesEqual;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class WebList extends JDIBase implements IList<UIElement>, SetValue, ISelector, HasUIList, HasAssert<UISelectAssert<UISelectAssert, WebList>> {
    @Override
    public WebList list() { return this; }
    public UIElement core() {
        return new UIElement(base()).setName(getName());
    }
    public WebList setup(JAction1<JDIBase> setup) {
        return setup(WebList.class, setup);
    }
    public WebList() { elements.set( new MapArray<>()); }
    public WebList(By locator) { this(); setLocator(locator);}
    public WebList(List<WebElement> elements) {
        this(); setWebElements(elements);
    }
    public WebList(JDIBase base) {
        super(base);
    }
    public WebList noValidation() {
        super.noValidation();
        return this;
    }
    @Override
    public WebList setName(String name) {
        super.setName(name);
        return this;
    }
    protected CacheValue<MapArray<String, UIElement>> elements = new CacheValue<>();

    private String elementName(int i) {
        return format("%s[%s]", getName(), i);
    }

    @JDIAction(level = DEBUG)
    public MapArray<String, UIElement> elements(int minAmount) {
        if (elements.hasValue() && isActual() && elements.get().size() >= minAmount)
            return elements.get();
        if (locator.isTemplate())
            throw exception("You call method that can't be used with template locator. " +
                    "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(getLocator()));
        List<WebElement> webElements = getList(minAmount);
        int length = webElements.size();
        elements.set(new MapArray<>());
        for (int i=0; i < length; i++) {
            int j = i;
            UIElement element = initElement(webElements.get(j), () -> getList(minAmount).get(j), j);
            addElement(element, UIELEMENT_NAME.execute(element));
        }
        return elements.get();
    }
    private void addElement(UIElement el, String name) {
        elements.get().add(name, el);
    }

    private String NO_ELEMENTS_FOUND = "Can't select '%s'. No elements with this name found";
    public boolean hasKey(String value) {
        if (elements.get() == null)
            elements.set(new MapArray<>());
        return hasKey(elements.get(), value);
    }
    public boolean hasKey(MapArray<String, UIElement> map, String value) {
        List<String> keys = map.keys();
        if (keys.isEmpty())
            return false;
        for (String key : keys)
            if (namesEqual(key, value))
                return true;
        return false;
    }
    public boolean hasNoKey(String value) {
        return !hasKey(value);
    }
    /**
     * @param value
     */
    @JDIAction(level = DEBUG)
    public UIElement get(String value) {
        if (hasNoKey(value)) {
            if (locator.isTemplate()) {
                addElement($(getLocator(value), parent)
                        .setName(getName() + ":" + value), value);
            }
            else {
                refresh();
                timer().wait(() -> hasKey(elements(1), value));
            }
            if (hasNoKey(value))
                throw exception(NO_ELEMENTS_FOUND, value);
        }
        return elements.get().get(value);
    }
    private JFunc1<UIElement, String> UIELEMENT_NAME = UIElement::getText;

    public WebList setUIElementName(JFunc1<UIElement, String> func) {
        UIELEMENT_NAME = func;
        return this;
    }

    public UIElement get(Enum name) {
        return get(getEnumValue(name));
    }
    /**
     * @param index
     */
    @JDIAction(level = DEBUG)
    public UIElement get(int index) {
        if (index < 0)
            throw exception("Can't get element with index '%s'. Index should be 0 or more", index);
        return (locator.isTemplate()
            ? tryGetByIndex(index)
            : elements(index).get(index).value)
        .setName(elementName(index));
    }
    private UIElement tryGetByIndex(int index) {
        try {
            return $(getLocator(index), parent);
        } catch (Exception ex) {
            throw exception("Can't get element with index '%s' for template locator. " +
                            "Maybe locator is wrong or you need to get element by name. Exception: %s",
                    index, ex.getMessage());
        }
    }

    /**
     * Select the item by the value
     * @param value
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        get(value).click();
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(String... values) {
        for (String value : values)
            select(value);
    }

    /**
     * Select the items by the values, hover and click on them
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String... values) {
        if (ArrayUtils.isEmpty(values))
            throw exception("Nothing to select in %s", getName());
        if (values.length < 2)
            throw exception("Hover and click method should have at list 2 parameters");
        int length = values.length;
        for (int i=0; i < length-1;i++) {
            get(values[i]).hover();
        }
        get(values[length-1]).click();
    }

    /**
     * Select the items by the values, hover and click on them
     * @param value
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String value) {
        String[] split = value.split(">");
        if (split.length == 1)
            select(split[0]);
        else hoverAndClick(split);
    }
    public <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum> void select(TEnum... values) {
        for (TEnum value : values)
            select(value);
    }

    /**
     * Select the item by the index
     * @param index
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        get(index).click();
    }

    /**
     * Select the items by the indexes
     * @param indexes
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }

    /**
     * Get the selected element value
     * @return String
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        refresh();
        UIElement first = logger.logOff(() -> first(UIElement::isSelected) );
        return first != null ? first.getText() : "";
    }

    /**
     * Refresh the element
     */
    @JDIAction(level = DEBUG)
    public void refresh() {
        elements.clear();
    }

    /**
     * Clear the element
     */
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

    /**
     * Show all items
     */
    @JDIAction
    public void showAll() {
        int size;
        do {
            size = size();
            get(size-1).show();
            clear();
        } while (size < size());
    }


    public boolean selected(String option) {
        return get(option).isSelected();
    }

    public List<String> checked() {
        return ifSelect(IListBase::isSelected, HasText::getText);
    }

    public List<String> values() {
        refresh();
        core().noValidation();
        return map(UIElement::getText);
    }

    public List<String> values(TextType type) {
        refresh();
        core().noValidation();
        return map(t -> t.text(type));
    }

    public List<String> listEnabled() {
        return ifSelect(IListBase::isEnabled, IListBase::getText);
    }

    public List<String> listDisabled() {
        return ifSelect(IListBase::isDisabled, IListBase::getText);
    }
    public boolean isDisplayed() {
        return isNotEmpty() && get(0).isDisplayed();
    }

    public boolean isHidden() {
        return !isDisplayed();
    }

    @JDIAction(level = DEBUG)
    public void highlight(String color) {
        foreach(el -> el.highlight(color));
    }
    @JDIAction(level = DEBUG)
    public void highlight() {
        foreach(IListBase::highlight);
    }
    @JDIAction(level = DEBUG)
    public void hover() {
        get(0).hover();
    }

    public boolean isEnabled() {
        return isNotEmpty() && get(0).isEnabled();
    }

    public boolean isDisabled() {
        return !isEnabled();
    }

    @JDIAction(level = DEBUG)
    public void show() {
        get(0).show();
    }
    public UISelectAssert<UISelectAssert, WebList> is() {
        offCache();
        return new UISelectAssert<>().set(this);
    }
    @JDIAction("Assert that {name} list meet condition")
    public UISelectAssert<UISelectAssert, WebList> is(Matcher<? super List<UIElement>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public UISelectAssert<UISelectAssert, WebList> assertThat(Matcher<? super List<UIElement>> condition) {
        return is(condition);
    }
    //endregion

    protected boolean isActual() {
        try {
            return elements.get().size() > 0 && isActual(elements.get().get(0).value);
        } catch (Exception ex) { return false; }
    }

    protected boolean isActual(UIElement element) {
        try {
            return isNotBlank(element.core().get().getTagName());
        } catch (Exception ex) { return false; }
    }
    protected UIElement initElement(WebElement el, JFunc<WebElement> func) {
        try {
            return $(el).setup(j->j.setWebElement(el).setGetFunc(func).setParent(this));
        } catch (Exception ex) { throw exception("Can't init func new element for list"); }
    }
    private UIElement initElement(WebElement el, JFunc<WebElement> func, int i) {
        return initElement(el, func, elementName(i));
    }
    private UIElement initElement(WebElement el, JFunc<WebElement> func, String name) {
        return initElement(el, func).setName(name);
    }

    public void offCache() {
        super.offCache();
        elements.useCache(false);
    }
}