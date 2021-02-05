package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.ButtonGroupAssert;

public class ButtonGroup extends UIBaseElement<ButtonGroupAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

}
