package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IHasSize;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.map;

public interface IMobileSelector extends IsText, HasMobileList, INamed, IHasSize, SetValue {
    @JDIAction("Select '{0}' in '{name}'")
    default void select(String value) { mobileList().select(value); }
    @JDIAction("Select '{0}' in '{name}'")
    default void select(int index) { mobileList().select(index); }
    @JDIAction("Select '{0}' in '{name}'")
    default <TEnum extends Enum<?>> void select(TEnum value) {
        select(getEnumValue(value));
    }
    @JDIAction("Select '{0}' in '{name}'")
    default void select(String... values) {
        mobileList().select(values);
    }
    @JDIAction("Select '{0}' in '{name}'")
    default <TEnum extends Enum<?>> void select(TEnum... values) {
        mobileList().select(values);
    }
    @JDIAction("Select '{0}' in '{name}'")
    default void select(int... values) {
        mobileList().select(values);
    }
    @JDIAction("Get selected value")
    default String selected() { return mobileList().selected(); }
    @JDIAction("Is '{0}' selected")
    default boolean selected(String option) { return mobileList().selected(option); }
    @JDIAction("Is '{0}' selected")
    default boolean selected(int index) { return mobileList().selected(index); }
    @JDIAction(level = DEBUG)
    default List<String> values() { return mobileList().values(); }
    @JDIAction(level = DEBUG)
    default List<String> values(TextTypes type) {
        return mobileList().values(type);
    }
    @JDIAction(level = DEBUG)
    default List<String> listEnabled() { return mobileList().listEnabled(); }
    @JDIAction(level = DEBUG)
    default List<String> listDisabled() { return mobileList().listDisabled(); }
    @Override
    default String getText() {
        return selected();
    }
    default String getValue() { return selected(); }
    default void setValue(String value) { select(value); }
    @JDIAction("Check that '{name}' is displayed")
    default boolean isDisplayed() { return mobileList().isDisplayed(); }
    @JDIAction("Check that '{name}' is hidden")
    default boolean isHidden() { return !isDisplayed();}
    default int size() { return mobileList().size(); }
    default boolean isEmpty() { return size() == 0; }
    default boolean isNotEmpty() { return size() > 0; }
    default List<Label> labels() {
        return map(mobileList(), UIElement::label);
    }

}
