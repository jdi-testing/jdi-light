package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.common.JDIAction;

public class Button extends Text {
    // region Actions
    @JDIAction("Click on '{name}'")
    public void click() {
        element.click();
    }
    // endregion
}
