package com.epam.jdi.mobile.elements.interfaces.complex;

import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.interfaces.common.IsInput;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsCombobox extends IsDropdown, IsInput {
    @JDIAction("Is '{0}' selected") @Override
    default boolean selected(String option) { return selected().equals(option); }
}
