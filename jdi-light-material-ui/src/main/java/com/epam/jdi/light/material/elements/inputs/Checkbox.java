package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/checkboxes/
 */

public class Checkbox extends com.epam.jdi.light.ui.html.elements.common.Checkbox {

    @JDIAction("Is '{name}' selected")
    @Override
    public boolean isSelected() {
        return hasClass("Mui-checked");
    }
}
