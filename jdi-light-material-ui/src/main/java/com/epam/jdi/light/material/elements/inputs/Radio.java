package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.RadioAssert;

public class Radio extends UIBaseElement<RadioAssert> {
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

    public String getValue() {
        return core().getText();
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
    public RadioAssert is() {
        return new RadioAssert().set(this);
    }
}
