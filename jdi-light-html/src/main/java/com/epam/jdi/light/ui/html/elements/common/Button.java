package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.IButton;

public class Button extends Text implements IButton {
    // region Actions
    @JDIAction("Click on '{name}'")
    public void click() {
        element.click();
    }
    // endregion
}
