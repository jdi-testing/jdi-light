package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;

public class RadioButton extends Checkbox {

    @JDIAction("Check '{name}'")
    public void select() {
        uiElement.check();
    }

}
