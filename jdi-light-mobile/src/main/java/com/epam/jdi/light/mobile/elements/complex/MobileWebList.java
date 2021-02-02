package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.JDILocator;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileTextTypes;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.light.mobile.elements.init.MobileUIFactory;
import com.epam.jdi.light.mobile.settings.MobileElementSettings;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getByType;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.toList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.namesEqual;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.max;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class MobileWebList extends JDIBase implements IList<MobileUIElement>, SetValue, ISelector, HasUIList,
        HasAssert<UISelectAssert<UISelectAssert<?, ?>, MobileWebList>> {
    protected int startIndex = MOBILE_ELEMENT.startIndex;
    protected CacheValue<MapArray<String, MobileUIElement>> map = new CacheValue<>(MapArray::new);
    public static MobileElementSettings MOBILE_ELEMENT = new MobileElementSettings();
    public MobileTextTypes mobileTextType = MOBILE_ELEMENT.getTextType;

    public MobileWebList() {
        webElements.useCache(true);
        webElement.useCache(true);
        textType = SMART_LIST;
    }

    public MobileWebList(@MarkupLocator By locator) {
        this();
        setLocator(locator);
    }

    public MobileWebList(List<WebElement> elements) {
        this();
        setWebElements(elements);
    }

    public MobileWebList(MapArray<String, MobileUIElement> map) {
        this.map.set(map);
    }

    public MobileWebList(List<String> header, List<MobileUIElement> elements) {
        this(new MapArray<>(header, elements));
    }

    public MobileWebList(JDIBase base) {
        super(base);
    }

    public MobileWebList(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
    }

    @Override
    public MobileWebList setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public MobileUIElement core() {
        return new MobileUIElement(base());
    }

    public MobileWebList setup(JAction1<JDIBase> setup) {
        return setup(MobileWebList.class, setup);
    }

    protected SearchContext getDefaultContext() {
        return driver();
    }

    @Override
    public boolean isUseCache() {
        return webElements.isUseCache();
    }

    protected boolean isActual(WebElement element) {
        try {
            if (isClass(element.getClass(), MobileUIElement.class))
                return ((MobileUIElement) element).noWait(() -> isNotBlank(element.getTagName()));
            return isNotBlank(element.getTagName());
        } catch (Exception ex) {
            map.clear();
            return false;
        }
    }

    protected MobileUIElement initElement(JFunc<WebElement> func) {
        return initElement(func.execute(), func);
    }

    protected MobileUIElement initElement(WebElement el, JFunc<WebElement> func) {
        try {
            MobileUIElement element = new MobileUIElement(base(), el, func);
            element.locator = new JDILocator(element);
            return element;
        } catch (Exception ex) {
            throw exception(ex, "Can't init func new element for list");
        }
    }

    private MobileUIElement getElementByLocator(int getIndex, int index) {
        return locator.isXPath()
                ? new MobileUIElement(base(), locator.addIndex(index), index + "", parent)
                : initElement(() -> getList(getIndex + 1).get(getIndex));
    }

    private MobileUIElement getByIndex(int index) {
        if (index < getStartIndex())
            throw exception("Can't get element with index '%s'. Index should be %s or more", index, getStartIndex());
        int getIndex = index - getStartIndex();
        if (locator.isNull() && isUseCache()) {
            if (map.hasValue() && map.get().size() > 0 && map.get().size() >= getIndex && isActualMap())
                return map.get().values().get(getIndex);
            if (webElements.hasValue() && webElements.get().size() > 0 && webElements.get().size() >= getIndex && isActual(webElements.get().get(0)))
                return MobileUIFactory.$(webElements.get().get(getIndex));
        }
        MobileUIElement element = locator.isTemplate()
                ? tryGetByIndex(index)
                : getElementByLocator(getIndex, index);
        return element.setName(nameFromIndex(index));
    }

    protected MobileUIElement tryGetByIndex(int index) {
        try {
            return new MobileUIElement(base(), getLocator(index), nameFromIndex(index));
        } catch (Exception ex) {
            throw exception(ex, "Can't get element with index '%s' for template locator. " +
                    "Maybe locator is wrong or you need to get element by name", index);
        }
    }

    /**
     * Select the item by the index
     *
     * @param index
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        clickOnElement(get(index), index + "");
    }

    /**
     * Select the item by the value
     *
     * @param value
     */
    @JDIAction("Select '{0}' for '{name}'")
    @Override
    public void select(String value) {
        clickOnElement(get(value), value);
    }

    private void clickOnElement(MobileUIElement element, String value) {
        if (element == null)
            throw exception("Can't get element '%s'", value);
        if (textType == LABEL) {
            if (element.isDisabled())
                throw exception("Can't perform click. Element is disabled");
            element.label().click();
        } else element.click();
    }

    /**
     * @param value
     */
    @JDIAction(level = DEBUG)
    @Override
    public MobileUIElement get(String value) {
        return hasKey(value)
                ? getByKey(value)
                : getUIElement(value);
    }

    protected boolean hasKey(String value) {
        if (map.hasValue() && any(map.get().keys(), key -> namesEqual(key, value)))
            return isActual(getByKey(value));
        return false;
    }

    protected MobileUIElement getByKey(String value) {
        return map.get().first((key, v) -> namesEqual(key, value)).value;
    }

    protected String getElementName(MobileUIElement element) {
        try {
            return nameFunc().execute(element);
        } catch (Exception ex) {
            return "";
        }
    }

    @JDIAction(level = DEBUG)
    @Override
    public MobileWebList elements(int minAmount) {
        return new MobileWebList(uiElements(minAmount));
    }

    protected List<WebElement> uiElements(int minAmount) {
        if (minAmount < 0)
            throw exception("uiElements failed. minAmount should be more than 0, but " + minAmount);
        if (isUseCache()) {
            if (map.hasValue() && map.get().size() > 0 && map.get().size() >= minAmount && isActualMap())
                return LinqUtils.select(map.get().values(), el -> el.get());
            if (webElements.hasValue() && webElements.get().size() > 0 && webElements.get().size() >= minAmount && isActual(webElements.get().get(0)))
                return webElements.get();
        }
        if (locator.isTemplate())
            throw exception("You call method that can't be used with template locator. " +
                    "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(getLocator(), this));
        return getListElements(minAmount);
    }

    public boolean isActualMap() {
        return isActual(map.get().values().get(0));
    }

    /**
     * @param index
     */
    @Override
    public MobileUIElement get(int index) {
        if (index < getStartIndex())
            throw exception("Can't get element with index '%s'. Index should be %s or more", index, getStartIndex());
        return getByIndex(index);
    }

    protected MobileUIElement firstUIElement(String value) {
        MapArray<String, MobileUIElement> nameElement = new MapArray<>();
        try {
            MobileWebList elements = elements(1);
            for (int i = 0; i < elements.size(); i++) {
                MobileUIElement element = elements.get(i + 1);
                String name = getElementName(element);
                nameElement.add(name, element);
                if (namesEqual(name, value))
                    return element;
            }
            return null;
        } finally {
            if (map.hasValue()) {
                for (Pair<String, MobileUIElement> pair : map.get())
                    if (!any(nameElement.keys(), name -> namesEqual(name, pair.key)))
                        nameElement.add(pair);
            }
            map.set(nameElement);
        }
    }

    public MobileUIElement getUIElement(String value) {
        MobileUIElement element = locator.isTemplate()
                ? new MobileUIElement(base(), getLocator(value), nameFromValue(value))
                : getNewElementByValue(value);
        map.get().update(value, element);
        return element;
    }

    protected MobileUIElement getNewElementByValue(String value) {
        refresh();
        if (locator.isXPath())
            return new MobileUIElement(base(), locator.addText(value), nameFromValue(value), parent);
        MobileUIElement result = firstUIElement(value);
        if (result == null)
            throw exception("Failed to get '%s' in list '%s'. No elements with this name found", value, getName());
        return result;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public MobileWebList indexFromZero() {
        setStartIndex(0);
        return this;
    }

    public void setStartIndex(int index) {
        startIndex = index;
    }

    public List<WebElement> webElements() {
        if (isUseCache()) {
            if (map.hasValue())
                return LinqUtils.select(map.get().values(), el -> el.get());
            if (webElements.hasValue())
                return webElements.get();
        }
        return elements(1).webElements();
    }

    @Override
    public MobileWebList setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }

    public static MobileWebList newList(List<UIElement> elements) {
        return new MobileWebList(LinqUtils.map(elements, JDIBase::get));
    }

    @Override
    public MobileWebList noValidation() {
        super.noValidation();
        return this;
    }

    protected String nameFromIndex(int i) {
        return nameFromValue(i + 1 + "");
    }

    protected String nameFromValue(String value) {
        return format("%s[%s]", getName(), value);
    }

    @Override
    public Iterator<MobileUIElement> iterator() {
        return LinqUtils.map(uiElements(0), el -> MobileUIFactory.$(el)).iterator();
    }

    protected List<WebElement> getListElements(int minAmount) {
        return getList(minAmount);
    }

    @Override
    public MobileUIElement first() {
        return get(getStartIndex());
    }

    @Override
    public MobileUIElement last() {
        return get(size() - getStartIndex() + 1);
    }

    protected String getElementName(int i, MobileUIElement element) {
        return nameIndex ? nameFromIndex(i) : getElementName(element);
    }

    protected JFunc1<MobileUIElement, String> nameFunc() {
        return MOBILE_UIELEMENT_NAME != null ? MOBILE_UIELEMENT_NAME : mobileTextType.func;
    }

    private JFunc1<MobileUIElement, String> MOBILE_UIELEMENT_NAME;
    private boolean nameIndex = false;

    public MobileWebList setUIElementName(JFunc1<MobileUIElement, String> func) {
        MOBILE_UIELEMENT_NAME = func;
        return this;
    }

    public MobileWebList setUIElementName(MobileTextTypes type) {
        if (type.equals(INDEX)) {
            nameIndex = true;
            return this;
        }
        mobileTextType = type;
        return setUIElementName(type.func);
    }

    @JDIAction("Check all '{name}' unchecked options")
    public void checkAll() {
        for (UIElement checkbox : elements(1)) {
            if (checkbox.isEnabled() && !selected(checkbox)) {
                checkbox.click();
            }
        }
    }

    @JDIAction("Uncheck all '{name}' checked options")
    public void uncheckAll() {
        for (UIElement checkbox : elements(1)) {
            if (checkbox.isEnabled() && selected(checkbox)) {
                checkbox.click();
            }
        }
    }

    @JDIAction("Check only '{0}' in '{name}' list")
    public void check(String... names) {
        List<String> listNames = asList(names);
        for (UIElement value : elements(names.length)) {
            if (value.isDisabled()) continue;
            if (selected(value) && !listNames.contains(value.labelText().trim())
                    || !selected(value) && listNames.contains(value.labelText().trim()))
                value.click();
        }
    }

    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    public void uncheck(String... names) {
        List<String> listNames = asList(names);
        for (UIElement value : elements(names.length)) {
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
        List<MobileUIElement> elements = elements(max - getStartIndex() + 1);
        int i = getStartIndex();
        for (UIElement element : elements) {
            if (element.isDisabled()) continue;
            if (selected(element) && !listIndexes.contains(i)
                    || !selected(element) && listIndexes.contains(i))
                element.click();
            i++;
        }
    }

    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    public void uncheck(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        int max = max(Ints.asList(indexes));
        List<MobileUIElement> elements = elements(max - getStartIndex() + 1);
        int i = getStartIndex();
        for (UIElement element : elements) {
            if (element.isDisabled()) continue;
            if (selected(element) && listIndexes.contains(i)
                    || !selected(element) && !listIndexes.contains(i))
                element.click();
            i++;
        }
    }

    public <TEnum extends Enum<?>> void check(TEnum... values) {
        check(getEnumValues(values));
    }

    public <TEnum extends Enum<?>> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    protected boolean selected(UIElement value) {
        return value.isSelected();
    }

    /**
     * Select the items by the values, hover and click on them
     *
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String... values) {
        if (ArrayUtils.isEmpty(values))
            throw exception("Nothing to select in %s", getName());
        if (values.length < 2)
            throw exception("Hover and click method should have at list 2 parameters");
        int length = values.length;
        for (int i = 0; i < length - 1; i++) {
            get(values[i]).hover();
        }
        get(values[length - 1]).click();
    }

    public <TEnum extends Enum<?>> void select(TEnum value) {
        select(getEnumValue(value));
    }

    /**
     * Select the items by the names
     *
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum<?>> void select(TEnum... values) {
        for (TEnum value : values)
            select(value);
    }

     /**
     * Select the items by the indexes
     *
     * @param indexes
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }

    /**
     * Get the selected element value
     *
     * @return String
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        refresh();
        MobileUIElement first = logger.logOff(() -> first(MobileUIElement::isSelected));
        return first != null ? getElementName(first) : "";
    }

    /**
     * Refresh the element
     */
    @JDIAction(level = DEBUG)
    public void refresh() {
        webElements.clear();
        map.clear();
        webElement.clear();
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
            get(size - 1).show();
            clear();
        } while (size < size());
    }

    @Override
    public int size() {
        try {
            if (isUseCache()) {
                if (map.hasValue() && map.get().size() > 0)
                    return map.get().size();
                if (webElements.hasValue() && webElements.get().size() > 0)
                    return webElements.get().size();
            }
            return IList.super.size();
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
        List<String> values;
        MobileWebList elements;
        if (isUseCache()) {
            if (map.hasValue() && map.get().size() > 0 && isActualMap())
                return map.get().keys();
            if (webElements.hasValue() && webElements.get().size() > 0 && isActual(webElements.get().get(0))) {
                values = LinqUtils.map(webElements.get(), element -> MobileUIFactory.$(element).text(textType));
                HashSet<String> unique = new HashSet<>(values);
                if (unique.size() == values.size()) {
                    map.set(new MapArray<>(values, LinqUtils.map(webElements.get(), el -> MobileUIFactory.$(el))));
                }
                return values;
            }
        }
        refresh();
        elements = noValidation(() -> elements(0));
        if (elements == null || elements.isEmpty())
            return new ArrayList<>();
        values = LinqUtils.map(elements, el -> el.noValidation(() -> el.text(textType)));
        HashSet<String> unique = new HashSet<>(values);
        if (unique.size() == values.size()) {
            map.set(new MapArray<>(values, elements));
        }
        return values;
    }

    @JDIAction("Get '{name}' values")
    public List<String> getValuesFast() {
        return getListFast().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' values")
    public List<String> values(MobileTextTypes type) {
        setUIElementName(type);
        return values();
    }

    @JDIAction("Get list of attributes for '{name}'")
    public List<String> attrs(String value) {
        return noValidation(() -> map(e -> e.attr(value)));
    }

    @JDIAction("Get list of enabled values for '{name}'")
    public List<String> listEnabled() {
        return noValidation(() -> ifSelect(UIElement::isEnabled, this::getElementName));
    }

    @JDIAction("Get list of disabled values for '{name}'")
    public List<String> listDisabled() {
        return noValidation(() -> ifSelect(UIElement::isDisabled, this::getElementName));
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
        foreach(UIElement::highlight);
    }

    @JDIAction(level = DEBUG)
    public void hover() {
        first().hover();
    }

    @JDIAction(level = DEBUG)
    public void show() {
        first().show();
    }

    public UISelectAssert<UISelectAssert<?, ?>, MobileWebList> is() {
        refresh();
        UISelectAssert<UISelectAssert<?, ?>, MobileWebList> is = new UISelectAssert<>();
        is.set(this);
        return is;
    }

    @JDIAction("Assert that {name} list meet condition")
    public UISelectAssert<UISelectAssert<?, ?>, MobileWebList> is(Matcher<? super List<MobileUIElement>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }

    public UISelectAssert<UISelectAssert<?, ?>, MobileWebList> assertThat(Matcher<? super List<MobileUIElement>> condition) {
        return is(condition);
    }

    public MobileUIElement initElement(WebElement el, JFunc<WebElement> func, int i) {
        return initElement(el, func, nameFromIndex(i));
    }

    private MobileUIElement initElement(WebElement el, JFunc<WebElement> func, String name) {
        return initElement(el, func).setName(name);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isNotEmpty() {
        return size() > 0;
    }

    public Point getLocation() {
        return first().getLocation();
    }

    public Dimension getSize() {
        Point firstPoint = first().getLocation();
        Point lastPoint = last().getLocation();
        Dimension dLast = last().getSize();
        return new Dimension(lastPoint.x + dLast.width - firstPoint.x, lastPoint.y + dLast.height - firstPoint.y);
    }

    public void offCache() {
        super.offCache();
        map.useCache(false);
    }

    @Override
    public WebList list() {
        return null;
    }

    public MobileWebList findsMobileElements(By locator) {
        List<WebElement> els = elements(1).selectMany(el -> el.finds(locator).webElements());
        return MobileUIFactory.$$(els, context + ">" + locator);
    }
}
