package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.FabAssert;

public class Fab extends UIBaseElement<FabAssert> {

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public FabAssert is() {
        return new FabAssert().set(this);
    }

    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

}
