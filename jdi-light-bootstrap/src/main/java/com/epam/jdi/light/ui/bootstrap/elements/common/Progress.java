package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;

public class Progress extends UIBaseElement<ProgressAssert> {
    @JDIAction(value = "Get '{name}' background color")
    public String getColor() {
        return uiElement.core().css("background-color");
    }

    @JDIAction(value = "Get '{name}' progress value")
    public String getAriaValue() {
        return uiElement.core().attr("aria-valuenow");
    }

    @JDIAction(value = "Get '{name}' style")
    public String getStyle() {
        return uiElement.core().attr("style");
    }

    @JDIAction(value = "Get '{name}' max limit")
    public String getMaxValue() {
        return uiElement.attr("aria-valuemax");
    }

    @JDIAction(value = "Get '{name}' min limit")
    public String getMinValue() {
        return uiElement.attr("aria-valuemin");
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }
}