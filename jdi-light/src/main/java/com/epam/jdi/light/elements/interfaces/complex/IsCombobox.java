package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsInput;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsCombobox extends IsDropdown, IsInput {
    @JDIAction("Is '{0}' selected") @Override
    default boolean selected(String option) { return selected().equals(option); }
    String value();
    @JDIAction("Get '{name}' text") @Override
    default String getText() {
        return value();
    }
    @JDIAction("Get selected in '{name}' option") @Override
    default String selected() {
        return getText();
    }
}
