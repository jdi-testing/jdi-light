package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.feedback.BackdropAssert;

public class Backdrop extends UIBaseElement<BackdropAssert> {

    @JDIAction("Click '{name}' to hide it")
    public void hide() {
        core().click();
        core().waitFor(1).element().isNotVisible();
    }

    @JDIAction("Check if '{name}' is visible")
    public boolean isVisible() {
        return "visible".equalsIgnoreCase(core().getCssValue("visibility"));
    }

    @Override
    public BackdropAssert is() {
        return new BackdropAssert().set(this);
    }
}
