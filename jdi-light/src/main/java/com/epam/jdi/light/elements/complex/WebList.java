package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.JDILocator;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MultiMap;
import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.TextTypes.INDEX;
import static com.epam.jdi.light.common.TextTypes.SMART_LIST;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.toList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.namesEqual;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebList extends JDIBase implements IList<UIElement>, SetValue, ISelector, HasUIList, HasAssert<UISelectAssert<UISelectAssert, WebList>> {
    @Override
    public WebList list() { return this; }
    public UIElement core() {
        return new UIElement(base());
    }
    public WebList setup(JAction1<JDIBase> setup) {
        return setup(WebList.class, setup);
    }
    @Override
    public WebList setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }
    public WebList() {
        elements.useCache(true);
        setTextType(SMART_LIST);
        noValidation();
    }
    public WebList(By locator) { this(); setLocator(locator);}
    public WebList(List<WebElement> elements) {
        this(); setWebElements(elements);
    }
    public WebList(JDIBase base) {
        super(base);
    }
    public WebList(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
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

    protected CacheValue<MultiMap<String, UIElement>> elements =
        new CacheValue<>(MultiMap::new);

    protected String nameFromIndex(int i) {
        return nameFromValue(i+1+"");
    }
    protected String nameFromValue(String value) {
        return format("%s[%s]", getName(), value);
    }

    @JDIAction(level = DEBUG)
    public MultiMap<String, UIElement> elements(int minAmount) {
        if (elements.isUseCache() && elements.hasValue() && isActual() && elements.get().size() >= minAmount)
            return elements.get();
        if (locator.isTemplate())
            throw exception("You call method that can't be used with template locator. " +
                "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(getLocator()));
        MultiMap<String, UIElement> result = getListElements(minAmount);
        if (elements.isUseCache())
            elements.set(result);
        return result;
    }
    protected MultiMap<String, UIElement> getListElements(int minAmount) {
        MultiMap<String, UIElement> result = new MultiMap<>();
        List<WebElement> we = getList(minAmount);
        int length = we.size();
        for (int i=0; i < length; i++) {
            int j = i;
            UIElement el = initElement(we.get(j), () -> getList(minAmount).get(j), j);
            result.add(getElementName(j, el), el);
        }
        return result;
    }
    protected String getElementName(int i, UIElement element) {
        if (nameIndex)
            return nameFromIndex(i);
        else {
            String name = getElementName(element);
            return (isNotBlank(name) ? name : nameFromIndex(i)).trim();
        }
    }
    protected String getElementName(UIElement element) {
        try {
            return (UIELEMENT_NAME != null
                ? UIELEMENT_NAME
                : getTextType().func).execute(element);
        } catch (Exception ex) {
            return "";
        }
    }
    protected boolean hasKey(String value) {
        List<String> keys = elements(1).keys();
        if (keys.isEmpty())
            return false;
        for (String key : keys)
            if (namesEqual(key, value))
                return true;
        return false;
    }
    /**
     * @param value
     */
    @JDIAction(level = DEBUG) @Override
    public UIElement get(String value) {
        return !locator.isTemplate() && hasKey(value)
            ? elements(1).get(value)
            : getUIElement(value);
    }

    public UIElement getUIElement(String value) {
        if (locator.isTemplate())
            return new UIElement(base(), getLocator(value), nameFromValue(value));
        else {
            refresh();
            MultiMap<String, UIElement> result = timer().getResultByCondition(
                () -> elements(1), els -> hasKey(value));
            if (result != null)
                return elements(1).get(value);
            throw exception("Can't get '%s'. No elements with this name found", value);
        }
    }
    private JFunc1<UIElement, String> UIELEMENT_NAME;
    private boolean nameIndex = false;

    public WebList setUIElementName(JFunc1<UIElement, String> func) {
        UIELEMENT_NAME = func;
        return this;
    }
    public WebList setUIElementName(TextTypes type) {
        if (type.equals(INDEX)) {
            nameIndex = true;
            return this;
        }
        setTextType(type);
        return setUIElementName(type.func);
    }

    /**
     * @param index
     */
    @JDIAction(level = DEBUG) @Override
    public UIElement get(int index) {
        if (index < 0)
            throw exception("Can't get element with index '%s'. Index should be 0 or more", index);
        return (locator.isTemplate()
            ? tryGetByIndex(index)
            : initElement(() -> getList(index+1).get(index)))
        .setName(nameFromIndex(index));
    }
    protected UIElement tryGetByIndex(int index) {
        try {
            return new UIElement(base(), getLocator(index), nameFromIndex(index));
        } catch (Exception ex) {
            throw exception("Can't get element with index '%s' for template locator. " +
                            "Maybe locator is wrong or you need to get element by name. %s",
                    index, safeException(ex));
        }
    }

////
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
    @JDIAction("Check all '{name}' unchecked options")
    public void checkAll() {
        for (UIElement checkbox : elements(1).values()) {
            if (checkbox.isEnabled() && !selected(checkbox)) {
                checkbox.click();
            }
        }
    }
    @JDIAction("Uncheck all '{name}' checked options")
    public void uncheckAll() {
        for (UIElement checkbox : elements(1).values()) {
            if (checkbox.isEnabled() && selected(checkbox)) {
                checkbox.click();
            }
        }
    }
    @JDIAction("Check only '{0}' in '{name}' list")
    public void check(String... names) {
        List<String> listNames = asList(names);
        for (UIElement value : elements(names.length).values()) {
            if (value.isDisabled()) continue;
            if (selected(value) && !listNames.contains(value.labelText().trim())
                    || !selected(value) && listNames.contains(value.labelText().trim()))
                value.click();
        }
    }
    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    public void uncheck(String... names) {
        List<String> listNames = asList(names);
        for (UIElement value : elements(names.length).values()) {
            if (value.isDisabled()) continue;
            if (selected(value) && listNames.contains(value.labelText().trim())
                    || !selected(value) && !listNames.contains(value.labelText().trim()))
                value.click();
        }
    }
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        for (int i = 0; i < values().size(); i++) {
            UIElement value = get(i);
            if (value.isDisabled()) continue;
            if (selected(value) && !listIndexes.contains(i+1)
                    || !selected(value) && listIndexes.contains(i+1))
                value.click();
        }
    }
    @JDIAction("Uncheck '{0}' checkboxes in  '{name}' checklist")
    public void uncheck(int... indexes) {
        if (indexes.length > 0 && list().get(indexes[0]-1).isDisplayed()) {
            List<Integer> listIndexes = toList(indexes);
            for (int i = 0; i < values().size(); i++) {
                UIElement value = get(i);
                if (value.isDisabled()) continue;
                if (selected(value) && listIndexes.contains(i+1)
                        || !selected(value) && !listIndexes.contains(i+1))
                    value.click();
            }
        }
    }
    public <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    public <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    protected boolean selected(UIElement value) {
        return value.isSelected();
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
        return first != null ? getElementName(first) : "";
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
    @Override
    public int size() {
        try {
            return noWait(() -> getList(0).size());
        } catch (Exception ex) {
            return 0;
        }
    }
    @JDIAction("Check that '{option}' is selected in '{name}'")
    public boolean selected(String option) {
        return get(option).isSelected();
    }

    @JDIAction("Get '{name}' checked values")
    public List<String> checked() {
        return ifSelect(IListBase::isSelected, this::getElementName);
    }

    @JDIAction("Get '{name}' values")
    public List<String> values() {
        refresh();
        return noValidation(() -> elements(0)).keys();
    }

    @JDIAction("Get '{name}' values")
    public List<String> values(TextTypes type) {
        setUIElementName(type);
        return values();
    }

    @JDIAction("Get list of enabled values for '{name}'")
    public List<String> listEnabled() {
        return noValidation(() -> ifSelect(IListBase::isEnabled, this::getElementName));
    }

    @JDIAction("Get list of disabled values for '{name}'")
    public List<String> listDisabled() {
        return noValidation(() -> ifSelect(IListBase::isDisabled, this::getElementName));
    }

    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        refresh();
        return isNotEmpty();
    }

    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return !isDisplayed();
    }

    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return isNotEmpty() && get(0).isEnabled();
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return !isEnabled();
    }
////
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

    @JDIAction(level = DEBUG)
    public void show() {
        get(0).show();
    }
    public UISelectAssert<UISelectAssert, WebList> is() {
        refresh();
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
            return elements.isUseCache() && elements.get().size() > 0 && isActual(elements.get().get(0).value);
        } catch (Exception ex) { return false; }
    }

    protected boolean isActual(UIElement element) {
        try {
            return isNotBlank(element.base().get().getTagName());
        } catch (Exception ex) { return false; }
    }
    protected UIElement initElement(JFunc<WebElement> func) {
        return initElement(func.execute(), func);
    }
    protected UIElement initElement(WebElement el, JFunc<WebElement> func) {
        try {
            UIElement element = new UIElement(base(), el, func);
            element.locator = new JDILocator();
            return element;
        } catch (Exception ex) { throw exception("Can't init func new element for list"); }
    }// TODO to private
    public UIElement initElement(WebElement el, JFunc<WebElement> func, int i) {
        return initElement(el, func, nameFromIndex(i));
    }
    private UIElement initElement(WebElement el, JFunc<WebElement> func, String name) {
        return initElement(el, func).setName(name);
    }
    public boolean isEmpty() { return size() == 0; }
    public boolean isNotEmpty() { return size() > 0; }

    public void offCache() {
        super.offCache();
        elements.useCache(false);
    }
}