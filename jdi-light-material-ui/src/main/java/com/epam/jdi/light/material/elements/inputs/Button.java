package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.ButtonAssert;

public class Button extends UIBaseElement<ButtonAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }

    @Override
    public ButtonAssert has() {
        return new ButtonAssert().set(this);
    }

    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Check if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }
}
