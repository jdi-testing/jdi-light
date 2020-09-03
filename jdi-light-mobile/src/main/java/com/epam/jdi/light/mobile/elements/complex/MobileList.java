package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.JDILocator;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.map.MultiMap;
import com.google.common.primitives.Ints;
import io.appium.java_client.MobileSelector;
import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getByType;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.mobile.elements.complex.MobileTextTypes.*;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.toList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.namesEqual;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.max;
import static org.apache.commons.lang3.StringUtils.isNotBlank;


public class MobileList extends JDIBase implements IList<MobileAppUIElement>, SetValue, IMobileSelector, HasMobileList,
        HasAssert<MobileSelectAssert<MobileSelectAssert<?,?>, MobileList>> {

    protected int startIndex = ELEMENT.startIndex;
    public MobileList indexFromZero() {
        return startIndex(0);
    }
    public MobileList startIndex(int index) {
        startIndex = index;
        return this;
    }
    @Override
    public MobileList mobileList() { return this; }
    public MobileAppUIElement core() {
        return new MobileAppUIElement(base());
    }
    public MobileList setup(JAction1<JDIBase> setup) {
        return setup(MobileList.class, setup);
    }
    @Override
    public MobileList setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }
    public MobileList() {
        elements.useCache(true);
    }
    public MobileList(@MarkupLocator By locator) { this(); setLocator(locator);}
    public MobileList(List<WebElement> elements) {
        this(); setWebElements(elements);
    }
    public MobileList(MapArray<String, MobileAppUIElement> map) {
        this(); elements.set(new MultiMap<>(map));
    }
    public MobileList setValues(MultiMap<String, MobileAppUIElement> map) {
        this.elements.set(map);
        return this;
    }
    public MobileList(JDIBase base) {
        super(base);
    }
    public MobileList(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
    }
    public MobileList noValidation() {
        super.noValidation();
        return this;
    }
    @Override
    public MobileList setName(String name) {
        super.setName(name);
        return this;
    }
    protected CacheValue<MultiMap<String, MobileAppUIElement>> elements =
            new CacheValue<>(() -> new MultiMap<String, MobileAppUIElement>().ignoreKeyCase());

    protected String nameFromIndex(int i) {
        return nameFromValue(i+1+"");
    }
    protected String nameFromValue(String value) {
        return format("%s[%s]", getName(), value);
    }

    @JDIAction(level = DEBUG)
    public MultiMap<String, MobileAppUIElement> elements(int minAmount) {
        if (elements.isUseCache() && elements.hasValue() && isActual() && elements.get().size() >= minAmount)
            return elements.get();
        if (locator.isTemplate())
            throw exception("You call method that can't be used with template locator. " +
                    "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(getLocator(), this));
        MultiMap<String, MobileAppUIElement> result = getListElements(minAmount);
        if (elements.isUseCache())
            elements.set(result);
        return result;
    }
    protected MultiMap<String, MobileAppUIElement> getListElements(int minAmount) {
        MultiMap<String, MobileAppUIElement> result = new MultiMap<String, MobileAppUIElement>().ignoreKeyCase();
        List<WebElement> we = getList(minAmount);
        int length = we.size();
        for (int i=0; i < length; i++) {
            int j = i;
            MobileAppUIElement el = initElement(we.get(j), () -> getList(minAmount).get(j), j);
            result.add(getElementName(j, el), el);
        }
        return result;
    }
    @Override
    public MobileAppUIElement first() {
        return get(startIndex);
    }
    @Override
    public MobileAppUIElement last() {
        return get(size() - startIndex + 1);
    }
    protected String getElementName(int i, MobileAppUIElement element) {
        return nameIndex ? nameFromIndex(i) : getElementName(element);
    }
    protected String getElementName(MobileAppUIElement element) {
        try {
            return (MOBILEAPPUIElement_NAME != null
                    ? MOBILEAPPUIElement_NAME
                    : MOBILE_SMART_LIST.func).execute(element);
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
    public MobileAppUIElement get(String value) {
        return !locator.isTemplate() && hasKey(value)
                ? elements(1).get(value)
                : getUIElement(value);
    }

    public MobileAppUIElement getUIElement(String value) {
        if (locator.isTemplate())
            return new MobileAppUIElement(base(), getLocator(value), nameFromValue(value));
        else {
            refresh();
            if (locator.isXPath())
                return new MobileAppUIElement(base(), locator.addText(value), nameFromValue(value), parent);
            MultiMap<String, MobileAppUIElement> result = timer().getResultByCondition(
                    () -> elements(1), els -> hasKey(value));
            if (result != null)
                return elements(1).get(value);
            throw exception("Can't get '%s'. No elements with this name found", value);
        }
    }
    private JFunc1<MobileAppUIElement, String> MOBILEAPPUIElement_NAME;
    private boolean nameIndex = false;

    public MobileList setMobileElementName(JFunc1<MobileAppUIElement, String> func) {
        MOBILEAPPUIElement_NAME = func;
        return this;
    }
    public MobileList setMobileElementName(MobileTextTypes type) {
        if (type.equals(MOBILE_INDEX)) {
            nameIndex = true;
            return this;
        }
        //MOBILE_SMART_LIST = type;
        return setMobileElementName(MOBILE_SMART_LIST.func);
    }
    @Override
    public boolean isUseCache() {
        return elements.isUseCache();
    }

    /**
     * @param index
     */
    @Override
    public MobileAppUIElement get(int index) {
        if (index < startIndex)
            throw exception("Can't get element with index '%s'. Index should be %s or more", index, startIndex);
        return getByIndex(index);
    }

    @JDIAction(level = DEBUG)
    private MobileAppUIElement getByIndex(int index) {
        if (index < startIndex)
            throw exception("Can't get element with index '%s'. Index should be %s or more", index, startIndex);
        int getIndex = index - startIndex;
        if (locator.isNull() && elements.isUseCache() && elements.get().size() > getIndex)
            return elements.get().get(getIndex).value;
        return (locator.isTemplate()
                ? tryGetByIndex(index)
                : getElementByLocator(getIndex, index))
                .setName(nameFromIndex(index));
    }
    private MobileAppUIElement getElementByLocator(int getIndex, int index) {
        return locator.isXPath()
                ? new MobileAppUIElement(base(), locator.addIndex(index), index+"", parent)
                : initElement(() -> getList(getIndex + 1).get(getIndex));
    }
    protected MobileAppUIElement tryGetByIndex(int index) {
        try {
            return new MobileAppUIElement(base(), getLocator(index), nameFromIndex(index));
        } catch (Exception ex) {
            throw exception(ex, "Can't get element with index '%s' for template locator. " +
                    "Maybe locator is wrong or you need to get element by name", index);
        }
    }

////
    /**
     * Select the item by the value
     * @param value
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        clickOnElement(get(value), value);
    }
    private void clickOnElement(MobileAppUIElement element, String value) {
        if (element == null)
            throw exception("Can't get element '%s'", value);
        if (textType == LABEL) {
            if (element.isDisabled())
                throw exception("Can't perform click. Element is disabled");
            element.label().click();
        }
        else element.click();
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
        for (MobileAppUIElement checkbox : elements(1).values()) {
            if (checkbox.isEnabled() && !selected(checkbox)) {
                checkbox.click();
            }
        }
    }
    @JDIAction("Uncheck all '{name}' checked options")
    public void uncheckAll() {
        for (MobileAppUIElement checkbox : elements(1).values()) {
            if (checkbox.isEnabled() && selected(checkbox)) {
                checkbox.click();
            }
        }
    }
    @JDIAction("Check only '{0}' in '{name}' list")
    public void check(String... names) {
        List<String> listNames = asList(names);
        for (MobileAppUIElement value : elements(names.length).values()) {
            if (value.isDisabled()) continue;
            if (selected(value) && !listNames.contains(value.labelText().trim())
                    || !selected(value) && listNames.contains(value.labelText().trim()))
                value.click();
        }
    }
    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    public void uncheck(String... names) {
        List<String> listNames = asList(names);
        for (MobileAppUIElement value : elements(names.length).values()) {
            if (value.isDisabled()) continue;
            if (selected(value) && listNames.contains(value.labelText().trim())
                    || !selected(value) && !listNames.contains(value.labelText().trim()))
                value.click();
        }
    }
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        int max = max(Ints.asList(indexes));
        MultiMap<String, MobileAppUIElement> elementsMap = elements(max - startIndex + 1);
        int i = startIndex;
        for (MobileAppUIElement value : elementsMap.values()) {
            if (value.isDisabled()) continue;
            if (selected(value) && !listIndexes.contains(i)
                    || !selected(value) && listIndexes.contains(i))
                value.click();
            i++;
        }
    }
    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    public void uncheck(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        int max = max(Ints.asList(indexes));
        MultiMap<String, MobileAppUIElement> elementsMap = elements(max - startIndex + 1);
        int i = startIndex;
        for (MobileAppUIElement value : elementsMap.values()) {
            if (value.isDisabled()) continue;
            if (selected(value) && listIndexes.contains(i)
                    || !selected(value) && !listIndexes.contains(i))
                value.click();
            i++;
        }
    }
    public <TEnum extends Enum<?>> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    public <TEnum extends Enum<?>> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    protected boolean selected(MobileAppUIElement value) {
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

    public <TEnum extends Enum<?>> void select(TEnum value) {
        select(getEnumValue(value));
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum<?>> void select(TEnum... values) {
        for (TEnum value : values)
            select(value);
    }

    /**
     * Select the item by the index
     * @param index
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        clickOnElement(get(index), index+"");
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
        MobileAppUIElement first = logger.logOff(() -> first(MobileAppUIElement::isSelected) );
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
            return elements.isUseCache() && elements.get().size() > 0
                    ? elements.get().size()
                    : IList.super.size();
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
        return ifSelect(ui -> getByType(ui, CanBeSelected.class).isSelected(), this::getElementName);
    }
    @JDIAction("Get '{name}' values")
    public List<String> values() {
        refresh();
        return noValidation(() -> elements(0)).keys();
    }
    @JDIAction("Get '{name}' values")
    public List<String> getValuesFast() {
        return getListFast().stream().map(WebElement::getText).collect(Collectors.toList());
    }
    @JDIAction("Get '{name}' values")
    public List<String> values(MobileTextTypes type) {
       // setUIElementName(type);
        return values();
    }

    @JDIAction("Get list of attributes for '{name}'")
    public List<String> attrs(String value) {
        return noValidation(() -> map(e -> e.attr(value)));
    }

    @JDIAction("Get list of enabled values for '{name}'")
    public List<String> listEnabled() {
        return noValidation(() -> ifSelect(MobileAppUIElement::isEnabled, this::getElementName));
    }

    @JDIAction("Get list of disabled values for '{name}'")
    public List<String> listDisabled() {
        return noValidation(() -> ifSelect(MobileAppUIElement::isDisabled, this::getElementName));
    }

    @JDIAction(value = "Check that '{name}' is displayed", timeout = 0)
    public boolean isDisplayed() {
        refresh();
        return isNotEmpty();
    }

    @JDIAction(value = "Check that '{name}' is hidden", timeout = 0)
    public boolean isHidden() {
        return !isDisplayed();
    }

    @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
    public boolean isEnabled() {
        return isNotEmpty() && first().isEnabled();
    }

    @JDIAction(value = "Check that '{name}' is disabled", timeout = 0)
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
        foreach(MobileAppUIElement::highlight);
    }
    @JDIAction(level = DEBUG)
    public void hover() {
        first().hover();
    }

    @JDIAction(level = DEBUG)
    public void show() {
        first().show();
    }
    public MobileSelectAssert<MobileSelectAssert<?,?>, MobileList> is() {
        refresh();
        MobileSelectAssert<MobileSelectAssert<?,?>, MobileList> is = new MobileSelectAssert<>();
        is.set(this);
        return is;
    }
    @JDIAction("Assert that {name} list meet condition")
    public MobileSelectAssert<MobileSelectAssert<?,?>, MobileList> is(Matcher<? super List<MobileAppUIElement>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public MobileSelectAssert<MobileSelectAssert<?,?>, MobileList> assertThat(Matcher<? super List<MobileAppUIElement>> condition) {
        return is(condition);
    }
    //endregion

    protected boolean isActual() {
        try {
            return elements.isUseCache() && elements.get().size() > 0 && isActual(elements.get().get(0).value);
        } catch (Exception ex) { return false; }
    }

    protected boolean isActual(MobileAppUIElement element) {
        try {
            return isNotBlank(element.base().get().getTagName());
        } catch (Exception ex) { return false; }
    }
    protected MobileAppUIElement initElement(JFunc<WebElement> func) {
        return initElement(func.execute(), func);
    }
    protected MobileAppUIElement initElement(WebElement el, JFunc<WebElement> func) {
        try {
            MobileAppUIElement element = new MobileAppUIElement(base(), el, func);
            element.locator = new JDILocator(element);
            return element;
        } catch (Exception ex) { throw exception(ex, "Can't init func new element for list"); }
    }
    public MobileAppUIElement initElement(WebElement el, JFunc<WebElement> func, int i) {
        return initElement(el, func, nameFromIndex(i));
    }
    private MobileAppUIElement initElement(WebElement el, JFunc<WebElement> func, String name) {
        return initElement(el, func).setName(name);
    }
    public boolean isEmpty() { return size() == 0; }
    public boolean isNotEmpty() { return size() > 0; }
    public Point getLocation() {
        return first().getLocation();
    }
    public Dimension getSize() {
        Point firstPoint = first().getLocation();
        Point lastPoint = last().getLocation();
        Dimension dLast = last().getSize();
        return new Dimension(lastPoint.x+dLast.width-firstPoint.x, lastPoint.y+dLast.height-firstPoint.y);
    }
    public void offCache() {
        super.offCache();
        elements.useCache(false);
    }
}
