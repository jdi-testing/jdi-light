package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;

/**
 * To see an example of Dropdown Menu web element please visit https://getbootstrap.com/docs/4.3/components/dropdowns/
 */

public class DropdownMenu extends DropdownExpand {
    public DropdownMenu() {
        expandLocator = "[data-toggle=dropdown]";
        valueLocator = "//button[not(*)]";
        listLocator = ".dropdown-item";
    }
}
