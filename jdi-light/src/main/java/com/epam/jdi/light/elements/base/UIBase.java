package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.IListBase;

public abstract class UIBase<A extends UIAssert> extends UIBaseElement<A> implements IListBase {
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return core().isSelected();
    }
    @JDIAction("Check that '{name}' is selected")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }
    @JDIAction("Click on '{name}'")
    public String getTagName() {
        return core().getTagName();
    }
}
