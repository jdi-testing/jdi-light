package com.epam.jdi.light.material.elements.inputs.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.material.elements.inputs.TextField;

public class NumberTextField extends TextField implements SetValue {

    @Override
    @JDIAction("Get '{name}' value")
    public String getValue() {
        return getText();
    }

    @Override
    @JDIAction("Set value to '{name}' text area")
    public void setValue(String value) {
        sendKeys(value);
    }

    @JDIAction("Set value to '{name}' text area")
    public void setValue(Float value) {
        if (type().equals("number")) {
            inputField().sendKeys(value.toString());
        }
    }
}
