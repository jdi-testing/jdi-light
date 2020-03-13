package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsCombobox extends IsDropdown, IsText, IsInput {
    @JDIAction("Is '{0}' selected") @Override
    default boolean selected(String option) { return selected().equals(option); }
    @JDIAction("Get selected in '{name}' option") @Override
    default String selected() {
        return getText();
    }
}
