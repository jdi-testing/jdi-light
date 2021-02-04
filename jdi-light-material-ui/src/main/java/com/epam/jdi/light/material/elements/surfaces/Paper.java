package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;

public class Paper extends UIBaseElement<PaperAssert> {

    @JDIAction("Get text for '{name}'")
    public String getText() {
        return core().getText();
    }

    @Override
    public PaperAssert is() {
        return new PaperAssert().set(this);
    }
}
