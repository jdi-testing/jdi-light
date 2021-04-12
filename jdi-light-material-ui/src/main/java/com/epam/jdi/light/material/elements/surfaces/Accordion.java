package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;

/**
 * https://material-ui.com/components/accordion/#accordion
 */
public class Accordion extends Dropdown {

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return value().hasClass("Mui-disabled");
    }

}
