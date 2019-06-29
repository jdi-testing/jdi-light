package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextType;
import com.epam.jdi.light.elements.base.UIBaseElement;

public class Label extends UIBaseElement<UIAssert> {
    @JDIAction("Click on '{name}'")
    public void click() {
        element.click();
    }
    @JDIAction("Get '{name}' text")
    public String getText() {
        return element.getText();
    }
    @JDIAction("Get '{name}' text")
    public String text(TextType type) {
        return core().text(type);
    }
}
