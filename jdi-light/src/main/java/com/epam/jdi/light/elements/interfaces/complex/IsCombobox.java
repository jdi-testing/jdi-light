package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsInput;

public interface IsCombobox extends IsDropdown, IsInput {
    @JDIAction("Is '{0}' selected") @Override
    default boolean selected(String option) { return selected().equals(option); }
}
