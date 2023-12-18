package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.jdiai.tools.HasStartIndex;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.jdiai.tools.EnumUtils.getEnumValue;
import static com.jdiai.tools.LinqUtils.map;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ISelector extends IsText, HasUIList, INamed, IHasSize, SetValue, HasStartIndex {
    @JDIAction("Select '{0}' in '{name}'")
    default void select(String value) {
        list().select(value);
    }

    @JDIAction("Select '{0}' in '{name}'")
    default void select(int index) { list().select(index); }

    @JDIAction("Select '{0}' in '{name}'")
    default <EnumType extends Enum<?>> void select(EnumType value) {
        select(getEnumValue(value));
    }

    @JDIAction("Select '{0}' in '{name}'")
    default void select(String... values) {
        list().select(values);
    }

    @JDIAction("Select '{0}' in '{name}'")
    default <EnumType extends Enum<?>> void select(EnumType... values) {
        list().select(values);
    }

    @JDIAction("Select '{0}' in '{name}'")
    default void select(int... values) {
        list().select(values);
    }

    @JDIAction("Get selected value")
    default String selected() { return list().selected(); }

    @JDIAction("Is '{0}' selected")
    default boolean selected(String option) { return list().selected(option); }

    @JDIAction("Is '{0}' selected")
    default boolean selected(int index) { return list().selected(index); }

    @JDIAction(level = DEBUG)
    default List<String> values() {
        WebList list = list();
        return list.noValidation(list::values);
    }

    @JDIAction(level = DEBUG)
    default List<String> values(TextTypes type) {
        WebList list = list();
        return list.noValidation(() -> list.values(type));
    }

    @JDIAction(level = DEBUG)
    default List<String> listEnabled() { return list().listEnabled(); }

    @JDIAction(level = DEBUG)
    default List<String> listDisabled() { return list().listDisabled(); }

    @JDIAction(level = DEBUG)
    default List<String> attrs(String value) {
        return list().attrs(value);
    }

    @Override
    default String getText() {
        return selected();
    }

    default String getValue() { return selected(); }

    default void setValue(String value) { select(value); }

    @JDIAction("Check that '{name}' is displayed")
    default boolean isDisplayed() { return list().isDisplayed(); }

    @JDIAction("Check that '{name}' is hidden")
    default boolean isHidden() { return !isDisplayed(); }

    default int size() { return list().size(); }

    default boolean isEmpty() { return size() == 0; }

    default boolean isNotEmpty() { return size() > 0; }

    default List<Label> labels() {
        return map(list(), UIElement::label);
    }
}
