package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;

public interface ISelector extends IsText, HasUIList, INamed, IHasSize, SetValue  {
    @JDIAction("Select '{0}' in '{name}'")
    default void select(String value) { list().select(value); }
    @JDIAction("Select '{0}' in '{name}'")
    default void select(int index) { list().select(index); }
    @JDIAction("Select '{0}' in '{name}'")
    default <TEnum extends Enum> void select(TEnum value) {
        select(getEnumValue(value));
    }
    @JDIAction("Get selected value")
    default String selected() { return getText(); }
    @JDIAction("Is '{0}' selected")
    default boolean selected(String option) { return list().get(option).isSelected(); }
    @JDIAction(level = DEBUG)
    default List<String> values() { return list().values(); }
    @JDIAction(level = DEBUG)
    default List<String> values(TextTypes type) { return list().values(type); }
    @JDIAction(level = DEBUG)
    default List<String> listEnabled() { return list().listEnabled(); }
    @JDIAction(level = DEBUG)
    default List<String> listDisabled() { return list().listDisabled(); }
    default String getValue() { return selected(); }
    default void setValue(String value) { select(value); }
    @JDIAction("Check that '{name}' is displayed")
    default boolean isDisplayed() { return list().isDisplayed(); }

}
