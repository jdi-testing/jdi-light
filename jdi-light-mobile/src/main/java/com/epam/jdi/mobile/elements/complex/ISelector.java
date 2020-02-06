package com.epam.jdi.mobile.elements.complex;

import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.common.TextTypes;
import com.epam.jdi.mobile.elements.interfaces.base.HasUIList;
import com.epam.jdi.mobile.elements.interfaces.base.INamed;
import com.epam.jdi.mobile.elements.interfaces.base.SetValue;
import com.epam.jdi.mobile.elements.interfaces.common.IsText;

import java.util.List;

import static com.epam.jdi.mobile.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface ISelector extends IsText, HasUIList, INamed, IHasSize, SetValue {
    @JDIAction("Select '{0}' in '{name}'")
    default void select(String value) { list().select(value); }
    @JDIAction("Select '{0}' in '{name}'")
    default void select(int index) { list().select(index-1); }
    @JDIAction("Select '{0}' in '{name}'")
    default <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }
    @JDIAction("Select '{0}' in '{name}'")
    default void select(String... values) {
        list().select(values);
    }
    @JDIAction("Select '{0}' in '{name}'")
    default <TEnum extends Enum> void select(TEnum... values) {
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
    @JDIAction(level = DEBUG)
    default List<String> values() { return list().values(); }
    @JDIAction(level = DEBUG)
    default List<String> values(TextTypes type) {
        return list().values(type);
    }
    @JDIAction(level = DEBUG)
    default List<String> listEnabled() { return list().listEnabled(); }
    @JDIAction(level = DEBUG)
    default List<String> listDisabled() { return list().listDisabled(); }
    @Override
    default String getText() {
        return selected();
    }
    default String getValue() { return selected(); }
    default void setValue(String value) { select(value); }
    @JDIAction("Check that '{name}' is displayed")
    default boolean isDisplayed() { return list().isDisplayed(); }
    default int size() { return list().size(); }
    default boolean isEmpty() { return size() == 0; }
    default boolean isNotEmpty() { return size() > 0; }

}
