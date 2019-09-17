package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;

public class ButtonWithDropdown extends DropdownExpand {

    public ButtonWithDropdown() {
        expandLocator = ".input-group-prepend";
        valueLocator = ".dropdown-toggle";
        listLocator = ".dropdown-item";
    }
}
