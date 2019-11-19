package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.EnumUtils.getEnumValues;
import static com.epam.jdi.tools.LinqUtils.toList;
import static java.util.Arrays.asList;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IWebList<T extends IListBase> extends IList<T> {

    /**
     * Select the item by the value
     * @param value
     */
    @JDIAction("Select '{0}' for '{name}'")
    default void select(String value) {
        get(value).click();
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    default void select(String... values) {
        for (String value : values)
            select(value);
    }
    @JDIAction("Check all '{name}' unchecked options")
    default void checkAll() {
        for (T checkbox : this) {
            if (checkbox.isEnabled() && !checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
    @JDIAction("Uncheck all '{name}' checked options")
    default void uncheckAll() {
        for (T checkbox : this) {
            if (checkbox.isEnabled() && checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
    @JDIAction("Check only '{0}' in '{name}' list")
    default void check(String... names) {
        List<String> listNames = asList(names);
        for (T value : elements(names.length).values()) {
            if (value.isDisabled()) continue;
            if (value.isSelected() && !listNames.contains(value.text(base().textType).trim())
                    || !value.isSelected() && listNames.contains(value.getText().trim()))
                value.click();
        }
    }
    @JDIAction("Uncheck '{0}' checkboxes in '{name}' checklist")
    default void uncheck(String... names) {
        List<String> listNames = asList(names);
        for (T value : elements(names.length).values()) {
            if (value.isDisabled()) continue;
            if (value.isSelected() && listNames.contains(value.text(base().textType).trim())
                    || !value.isSelected() && !listNames.contains(value.text(base().textType).trim()))
                value.click();
        }
    }
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    default void check(int... indexes) {
        List<Integer> listIndexes = toList(indexes);
        for (int i = 0; i < values().size(); i++) {
            T value = get(i);
            if (value.isDisabled()) continue;
            if (value.isSelected() && !listIndexes.contains(i+1)
                    || !value.isSelected() && listIndexes.contains(i+1))
                value.click();
        }
    }
    @JDIAction("Uncheck '{0}' checkboxes in  '{name}' checklist")
    default void uncheck(int... indexes) {
        if (indexes.length > 0 && get(indexes[0]-1).isDisplayed()) {
            List<Integer> listIndexes = toList(indexes);
            for (int i = 0; i < values().size(); i++) {
                T value = get(i);
                if (value.isDisabled()) continue;
                if (value.isSelected() && listIndexes.contains(i+1)
                        || !value.isSelected() && !listIndexes.contains(i+1))
                    value.click();
            }
        }
    }
    default <TEnum extends Enum> void check(TEnum... values) {
        check(getEnumValues(values));
    }
    default <TEnum extends Enum> void uncheck(TEnum... values) {
        uncheck(getEnumValues(values));
    }

    /**
     * Select the items by the values, hover and click on them
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    default void hoverAndClick(String... values) {
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
    default void hoverAndClick(String value) {
        String[] split = value.split(">");
        if (split.length == 1)
            select(split[0]);
        else hoverAndClick(split);
    }
    default <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }

    /**
     * Select the items by the names
     * @param values
     */
    @JDIAction("Select ({0}) for '{name}'")
    default <TEnum extends Enum> void select(TEnum... values) {
        for (TEnum value : values)
            select(value);
    }

    /**
     * Select the item by the index
     * @param index
     */
    @JDIAction("Select '{0}' for '{name}'")
    default void select(int index) {
        get(index).click();
    }

    /**
     * Select the items by the indexes
     * @param indexes
     */
    @JDIAction("Select ({0}) for '{name}'")
    default void select(int... indexes) {
        for (int index : indexes)
            select(index);
    }

    /**
     * Get the selected element value
     * @return String
     */
    @JDIAction("Get '{name}' selected value")
    default String selected() {
        refresh();
        T first = logger.logOff(() -> first(T::isSelected) );
        return first != null ? getElementName(first) : "";
    }
    default String getElementName(T element) { return element.getName(); }

    @JDIAction("Check that '{option}' is selected in '{name}'")
    default boolean selected(String option) {
        return get(option).isSelected();
    }

    @JDIAction("Get '{name}' checked values")
    default List<String> checked() {
        return ifSelect(IListBase::isSelected, this::getElementName);
    }

    @JDIAction("Get '{name}' values")
    default List<String> values() {
        refresh();
        base().noValidation();
        return elements(0).keys();
    }

    @JDIAction("Get '{name}' values")
    default List<String> values(TextTypes type) {
        base().textType = type;
        return values();
    }

    @JDIAction("Get list of enabled values for '{name}'")
    default List<String> listEnabled() {
        return ifSelect(IListBase::isEnabled, this::getElementName);
    }

    @JDIAction("Get list of disabled values for '{name}'")
    default List<String> listDisabled() {
        return ifSelect(IListBase::isDisabled, this::getElementName);
    }

    @JDIAction("Check that '{name}' is displayed")
    default boolean isDisplayed() {
        return isNotEmpty() && get(0).isDisplayed();
    }

    @JDIAction("Check that '{name}' is hidden")
    default boolean isHidden() {
        return !isDisplayed();
    }

    @JDIAction("Check that '{name}' is enabled")
    default boolean isEnabled() {
        return isNotEmpty() && get(0).isEnabled();
    }

    @JDIAction("Check that '{name}' is disabled")
    default boolean isDisabled() {
        return !isEnabled();
    }
}
