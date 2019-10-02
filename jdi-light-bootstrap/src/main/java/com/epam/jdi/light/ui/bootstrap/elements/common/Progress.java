package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;

//public class Progress extends UIBaseElement<ProgressAssert> {
public class Progress extends Section {
    @JDIAction(value = "Get '{name}' background color")
    public String getColor() {
        return uiElement.core().css("background-color");
    }

    @JDIAction(value = "Get '{name}' width")
    public String getWidth() {
        if (uiElement.hasAttribute("style")) {
            return uiElement.core().attr("style");
        } else {
            return "width: 0%;";
        }
    }

    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }
}
