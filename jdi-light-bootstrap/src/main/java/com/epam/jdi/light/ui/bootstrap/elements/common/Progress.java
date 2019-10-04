package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;

public class Progress extends UIBaseElement<ProgressAssert> {
    @JDIAction(value = "Get '{name}' background color")
    public String getColor() {
        return uiElement.core().css("background-color");
    }

    @JDIAction(value = "Get '{name}' width")
    public String getAriaValue() {
        return uiElement.core().attr("aria-valuenow");
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }
}
