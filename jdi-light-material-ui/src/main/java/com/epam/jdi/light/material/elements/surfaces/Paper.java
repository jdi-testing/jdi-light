package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;

public class Paper extends UIBaseElement<PaperAssert> {

    @Override
    public PaperAssert is() {
        return new PaperAssert().set(this);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Get text of '{name}'")
    public String getText() {
        return core().getText();
    }
}
