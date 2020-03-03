package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MultiMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.initT;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getByType;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
abstract class ListBase<T extends ICoreElement, A extends UISelectAssert>
    extends UIBaseElement<A> implements IList<T>, ISetup, ISelector {
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
    protected CacheValue<MultiMap<String, T>> map = new CacheValue<>(() -> new MultiMap<String, T>().ignoreKeyCase());
    private boolean isActual(T element) {
        try {
            element.getTagName();
            return true;
        } catch (Exception ex) { return false; }
    }

    @JDIAction(level = DEBUG)
    public MultiMap<String, T> elements(int minAmount) {
        if (actualMapValue())
            return map.get();
        return list().elements(minAmount).toMultiMap(this::toT);
    }

    /**
     * @param value
     */
    @JDIAction(level = DEBUG)
    public T get(String value) {
        return toT(list().get(value));
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
        T item = get(value);
        getByType(item, IClickable.class).click();
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

    @Override
    public int size() { return list().size(); }
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
        refresh();
        T first = logger.logOff(() ->
                first(item -> getByType(item, CanBeSelected.class).isSelected()));
        if (first == null)
            return "";
        return getByType(first, IsText.class).getText();
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

    public List<String> values(TextTypes type) {
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
    @Override
    public boolean isHidden() {
        return list().isHidden();
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
        } catch (Exception ex) { throw  exception(ex, "Can't init WebList. Weblist elements should extend UIElement"); }
    }
    protected T toT(UIElement el) {
        return initT(el, this, initClass);
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
        return getTextElement(field, element).getText();
    }
    private IsText getTextElement(Field field, Object element) {
        Object title = getValueField(field, element);
        IsText textElement = getByType((ICoreElement) title, IsText.class);
        textElement.base().noValidation();
        return textElement;
    }
    public boolean isEmpty() { return size() == 0; }
    public boolean isNotEmpty() { return size() > 0; }

}