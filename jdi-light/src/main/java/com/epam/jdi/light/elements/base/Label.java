package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.light.common.JDIAction;

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
    public String innerText() {
        return element.innerText();
    }
}
