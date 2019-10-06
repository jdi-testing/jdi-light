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

    @JDIAction(value = "Get '{name}' min value")
    public String getMinValue() {
        return uiElement.core().attr("aria-valuemin");
    }

    @JDIAction(value = "Get '{name}' max value")
    public String getMaxValue() {
        return uiElement.core().attr("aria-valuemax");
    }

    @JDIAction(value = "Get '{name}' style")
    public String getStyle() {
        return uiElement.core().attr("style");
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }

}
