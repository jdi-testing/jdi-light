package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;

public abstract class UIBase<A extends UIAssert> extends UIBaseElement<A> implements IListBase {
    @JDIAction("Click on '{name}'")
    public void click() {
        core().click();
    }
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().getText();
    }
    @JDIAction("Get '{name}' text")
    public String innerText() {
        return core().innerText();
    }
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return core().isSelected();
    }
    @JDIAction("Check that '{name}' is selected")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }
}
