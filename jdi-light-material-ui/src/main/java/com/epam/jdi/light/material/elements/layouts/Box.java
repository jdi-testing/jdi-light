package com.epam.jdi.light.material.elements.layouts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layouts.BoxAssert;

public class Box  extends UIBaseElement<BoxAssert> {
    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public BoxAssert is() {
        return new BoxAssert().set(this);
    }

    public String getText() {
        return core().getText();
    }

    public boolean hasAttr(String attr, String value){
        return core().getAttribute(attr).equals(value);
    }
}
