package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.feedback.BackdropAssert;

public class Backdrop extends UIBaseElement<BackdropAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }
}
