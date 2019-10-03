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
    public String getWidth() {
        if (uiElement.hasAttribute("style")) {
            if (uiElement.core().attr("style").contains("width")) {
                return uiElement.core().attr("style");
            } else {
                return "width: 0%; or element is wrong";
            }
        } else {
            return "width: 0%; or element is wrong";
        }
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }
}
