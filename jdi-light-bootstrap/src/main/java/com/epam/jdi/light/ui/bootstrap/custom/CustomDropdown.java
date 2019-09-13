package com.epam.jdi.light.ui.bootstrap.custom;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;

public class CustomDropdown extends DropdownExpand {
    public CustomDropdown() {
        expandLocator = "*[data-toggle=collapse]";
        listLocator = ".collapse .show";
    }
}
