package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;

public class TextField extends UIBaseElement<TextFieldAssert> {

    @JDIAction("Toggle '{name}'")
    public void setValue(CharSequence... value) {
        core().sendKeys(value);
    }



}
