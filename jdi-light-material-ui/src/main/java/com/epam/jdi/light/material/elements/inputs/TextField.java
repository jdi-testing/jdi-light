package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;

import static com.epam.jdi.light.common.TextTypes.VALUE;

public class TextField extends UIBaseElement<TextFieldAssert> {

    private static final String MUI_INPUT_INPUT = ".MuiInput-input, .MuiFilledInput-input";

    @JDIAction("Set '{0}' value in '{name}'")
    public void setValue(String value) {
        core().find(MUI_INPUT_INPUT).input(value);
    }

    @JDIAction("Get value of '{name}'")
    public String getValue() {
        return core().find(MUI_INPUT_INPUT).text(VALUE);
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().find(MUI_INPUT_INPUT).hasClass("Mui-disabled");
    }

    @JDIAction("Clear '{name}'")
    public void clear() {
        core().find(MUI_INPUT_INPUT).clear();
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }

    @Override
    public TextFieldAssert has() {
        return this.is();
    }

}
