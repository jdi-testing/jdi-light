package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.RadioButtonAssert;

public class RadioButton extends UIBaseElement<RadioButtonAssert> {
    @JDIAction("Toggle '{name}'")
    public void toggle() {
        core().click();
    }

    @JDIAction("Is '{name}' checked")
    public Boolean isChecked() {
        return core().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
    public Boolean isUnchecked() {
        return !isChecked();
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public RadioButtonAssert is() {
        return new RadioButtonAssert().set(this);
    }
}
