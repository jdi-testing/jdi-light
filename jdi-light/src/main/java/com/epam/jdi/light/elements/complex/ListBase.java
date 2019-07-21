package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextType;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.interfaces.HasUIList;
import com.epam.jdi.light.elements.interfaces.IListBase;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.PageFactory.initFieldUsingRules;
import static com.epam.jdi.light.elements.init.PageFactory.setupFieldUsingRules;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;

abstract class ListBase<T extends IListBase, A extends UISelectAssert>
    extends UIBaseElement<A> implements IList<T>, SetValue, ISetup, ISelector, HasUIList {
    protected WebList list;
    public WebList list() {
        if (list == null) {
            list = new WebList(core()).setUIElementName(this::elementTitle)
                    .setName(getName());
        }
        return list;
    }

    ListBase() {}
    ListBase(By locator) { list = new WebList(locator); }
    ListBase(List<WebElement> elements) { list = new WebList(elements); }
    Class<?> initClass = UIElement.class;

    private boolean actualMapValue() {
        return map.hasValue() && map.get().size() > 0 && isActual(map.get().get(0).value);
    }
    protected CacheValue<MapArray<String, T>> map;
    private boolean isActual(T element) {
        try {
            element.getTagName();
            return true;
        } catch (Exception ex) { return false; }
    }

    /**
     * @param minAmount
     * @return List
     */

    @JDIAction(level = DEBUG)
    public MapArray<String, T> elements(int minAmount) {
        if (actualMapValue())
            return map.get();
        return list().elements(minAmount).toMapArray(this::toT);
    }

    /**
     * @param value
     */
    @JDIAction(level = DEBUG)
    public T get(String value) {
        return toT(list().get(value));
    }

    public T get(Enum name) {
        return get(getEnumValue(name));
    }
    /**
     * @param index
     */
    @JDIAction(level = DEBUG)
    public T get(int index) {
        return toT(list().get(index));
    }

    /**
     * Select the item by the value
     * @param value
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(String value) {
        list().select(value);
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(String... values) {
        list().select(values);
    }

    /**
     * Select the items by the values, hover and click on them
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String... values) {
        list().hoverAndClick(values);
    }

    /**
     * Select the items by the values, hover and click on them
     * @param value
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void hoverAndClick(String value) {
        list().hoverAndClick(value);
    }
    public <TEnum extends Enum> void select(TEnum value) {
        list().select(value);
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    public <TEnum extends Enum> void select(TEnum... values) {
        list().select(values);
    }

    /**
     * Select the item by the index
     * @param index
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        list().select(index);
    }

    /**
     * Select the items by the indexes
     * @param indexes
     */
    @JDIAction("Select ({0}) for '{name}'")
    public void select(int... indexes) {
        list().select(indexes);
    }

    /**
     * Get the selected element value
     * @return String
     */
    @JDIAction("Get '{name}' selected value")
    public String selected() {
        return list().selected();
    }

    /**
     * Refresh the element
     */
    @JDIAction(level = DEBUG)
    public void refresh() {
        clear();
    }

    /**
     * Clear the element
     */
    @JDIAction(level = DEBUG)
    public void clear() {
        list().clear();
        map.clear();
    }

    public void setValue(String value) {
        list().setValue(value);
    }

    public String getValue() {
        return list().getValue();
    }

    /**
     * Show all items
     */
    @JDIAction
    public void showAll() {
        list().showAll();
    }

    @Override
    public boolean selected(String option) {
        return list().selected(option);
    }

    public List<String> checked() {
        return list().checked();
    }

    public List<String> values() {
        return list().values();
    }

    public List<String> values(TextType type) {
        return list().values(type);
    }

    public List<String> listEnabled() {
        return list().listEnabled();
    }

    public List<String> listDisabled() {
        return list().listDisabled();
    }
    @Override
    public boolean isDisplayed() {
        return list().isDisplayed();
    }
    @Override @JDIAction(level = DEBUG)
    public void highlight(String color) {
        list().highlight(color);
    }
    @Override @JDIAction(level = DEBUG)
    public void highlight() {
        list().highlight();
    }
    @Override @JDIAction(level = DEBUG)
    public void hover() {
        list().hover();
    }
    @Override @JDIAction(level = DEBUG)
    public void show() {
        get(0).show();
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
            this.initClass = initClass;
        } catch (Exception ex) { throw  exception("Can't init WebList. Weblist elements should extend UIElement"); }
    }
    private T toT(UIElement el) {
        try {
            if (initClass == null)
                throw exception("Can't init List of UI Elements. Class Type is null");
            SiteInfo info = new SiteInfo(core().driverName).set(s -> {
                s.cl = initClass;
                s.name = el.getName();
                s.parent = el.parent;
            });
            initFieldUsingRules(info);
            if (info.instance != null)
                setupFieldUsingRules(info);
            T t = (T) info.instance;
            t.core().setCore(el);
            return t;
        } catch (Exception ex) { throw exception("Can't init new element for list"); }
    }

    public static JFunc1<Field[], String> GET_TITLE_FIELD_NAME = fields -> {
        Field expectedField = LinqUtils.first(fields, f -> f.isAnnotationPresent(Title.class));
        if (expectedField != null)
            return expectedField.getName();
        List<Field> titles = LinqUtils.filter(fields, f -> f.getType() == Label.class);
        return titles.size() == 1
                ? titles.get(0).getName()
                : null;
    };
    protected String titleFieldName = null;
    protected String elementTitle(UIElement el) {
        if (titleFieldName == null)
            titleFieldName = GET_TITLE_FIELD_NAME.execute(initClass.getFields());
        return titleFieldName == null
                ? el.getText()
                : getElementTitle(el, titleFieldName);
    }
    protected String getElementTitle(UIElement el, String titleField) {
        T element = toT(el);
        Field field = null;
        try {
            field = element.getClass().getField(titleField);
        } catch (Exception ignore) { /* if field name identified it is always exist */ }
        return ((WebElement) getValueField(field, element)).getText();
    }
}