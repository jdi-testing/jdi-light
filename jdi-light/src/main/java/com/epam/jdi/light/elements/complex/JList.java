package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.core.ListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.HasUIElement;
import com.epam.jdi.light.elements.base.IListBase;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.shortBy;
import static com.epam.jdi.light.elements.base.JDIBase.waitCondition;
import static com.epam.jdi.light.elements.init.PageFactory.initFieldUsingRules;
import static com.epam.jdi.light.elements.init.PageFactory.setupFieldUsingRules;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JList<T extends IListBase & HasUIElement>
    extends UIBaseElement<ListAssert> implements IList<T>, SetValue, ISetup, ISelector {
    protected CacheValue<List<T>> elements = new CacheValue<>();

    public JList() {}
    public JList(By locator) { core().setLocator(locator); }
    public JList(List<WebElement> elements) {
        this.elements.setForce(LinqUtils.map(elements, this::initElement));
    }
    /**
     * @param minAmount
     * @return List
     */
    protected Class<?> initClass = UIElement.class;
    public JList<T> setInitClass(Class<T> listClass) {
        initClass = listClass;
        return this;
    }

    @JDIAction(level = DEBUG)
    public List<T> elements(int minAmount) {
        if (elements.hasValue() && isActual() && elements.get().size() >= minAmount)
            return elements.get();
        if (core().getLocator().toString().contains("%s"))
            throw exception("You call method that can't be used with template locator. " +
                    "Please correct %s locator to get List<WebElement> in order to use this method", shortBy(core().getLocator()));
        int length = core().getList(minAmount).size();
        List<T> result = new ArrayList<>();
        for (int i=0; i < length; i++) {
            int j = i;
            result.add(initElement(() -> (WebElement) core().getList(minAmount).get(j)));
        }
        return this.elements.set(result);
    }

    private String NO_ELEMENTS_FOUND = "Can't select '%s'. No elements with this name found";

    /**
     * @param value
     */
    @JDIAction(level = DEBUG)
    public T get(String value) {
        if (core().getLocator().toString().contains("%s")) {
            return initElement(() -> core().get(value)).setName(value);
        }
        refresh();
        T el = first(e -> elementTitle(e).equals(value));
        if (el == null)
            throw exception(NO_ELEMENTS_FOUND, value);
        el.setName(value);
        el.core().setGetFunc(() -> first(e -> e.getText().equals(value)));
        return el;
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }

    public static JFunc1<JList, String> GET_TITLE_FIELD_NAME = list -> {
        Field[] fields = list.initClass.getFields();
        Field expectedFields = LinqUtils.first(fields, f -> f.isAnnotationPresent(Title.class));
        return expectedFields != null
                ? expectedFields.getName()
                : null;
    };

    protected String titleFieldName = null;

    protected String elementTitle(WebElement el) {
        if (titleFieldName == null)
            titleFieldName = GET_TITLE_FIELD_NAME.execute(this);
        return titleFieldName == null
                ? el.getText()
                : getElementTitle(el, titleFieldName);
    }
    protected String getElementTitle(WebElement el, String titleField) {
        T element = initElement(el);
        Field field = null;
        try {
            field = element.getClass().getField(titleField);
        } catch (Exception ignore) { /* if field name identified it is always exist */ }
        return ((WebElement) getValueField(field, element)).getText();
    }
    /**
     * @param index
     */
    @JDIAction(level = DEBUG)
    public T get(int index) {
        if (index < 0)
            throw exception("Can't get element with index '%s'. Index should be 0 or more", index);
        String name = format("%s[%s]", getName(), index);
        if (core().getLocator().toString().contains("%s")) {
            WebElement element;
            try {
                element = core().get(index);
            } catch (Exception ex) {
                throw exception("Can't get element with index '%s' for template locator. " +
                    "Maybe locator is wrong or you need to get element by name. Exception: %s",
                        index, ex.getMessage());
            }
            return initElement(element).setName(name);
        }
        return elements(index).get(index).setName(name);
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
        T first = logger.logOff(() -> first(IListBase::isSelected) );
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


    @Override
    public boolean selected(String option) {
        return get(option).isSelected();
    }

    public List<String> checked() {
        return ifSelect(IListBase::isSelected, IListBase::getText);
    }

    public List<String> values() {
        refresh();
        core().noValidation();
        return map(T::getText);
    }

    public List<String> innerValues() {
        refresh();
        core().noValidation();
        return map(T::innerText);
    }

    @Override
    public List<String> listEnabled() {
        return ifSelect(IListBase::isEnabled, IListBase::getText);
    }

    @Override
    public List<String> listDisabled() {
        return ifSelect(IListBase::isDisabled, IListBase::getText);
    }
    public boolean displayed() {
        return isNotEmpty() && get(0).isDisplayed();
    }

    @Override @JDIAction(level = DEBUG)
    public void highlight(String color) {
        foreach(el -> el.highlight(color));
    }
    @Override @JDIAction(level = DEBUG)
    public void highlight() {
        foreach(IListBase::highlight);
    }
    @Override @JDIAction(level = DEBUG)
    public void hover() {
        get(0).hover();
    }
    @Override @JDIAction(level = DEBUG)
    public void show() {
        get(0).show();
    }

    //region matchers
    public ListAssert is() {
        return new ListAssert(() -> {refresh(); return this; }, core().toError());
    }
    @JDIAction("Assert that {name} list meet condition")
    public ListAssert is(Matcher<? super List<T>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public ListAssert assertThat(Matcher<? super List<T>> condition) {
        return is(condition);
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
    protected boolean isActual() {
        try {
            return elements.get().size() > 0 && isActual(elements.get().get(0));
        } catch (Exception ex) { return false; }
    }

    protected boolean isActual(T element) {
        try {
            return isNotBlank(element.core().get().getTagName());
        } catch (Exception ex) { return false; }
    }
    protected T initElement(WebElement webElement) {
        try {
            T result = initElement();
            result.core().setWebElement(webElement);
            return result;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }
    protected T initElement(JFunc<WebElement> func) {
        try {
            T result = initElement();
            result.core().setGetFunc(func);
            return result;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }
    protected T initElement() {
        try {
            if (initClass == null)
                throw exception("Can't init List of UI Elements. Class Type is null");
            SiteInfo info = new SiteInfo(driverName).set(s -> {
                s.cl = initClass;
                s.name = getName();
                s.parent = parent;
            });
            initFieldUsingRules(info);
            if (info.instance != null)
                setupFieldUsingRules(info);
            return (T) info.instance;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }
    public boolean wait(JFunc1<JList<T>, Boolean> condition) {
        return waitCondition(condition, this);
    }

    public void offCache() {
        super.offCache();
        elements.useCache(false);
    }
}