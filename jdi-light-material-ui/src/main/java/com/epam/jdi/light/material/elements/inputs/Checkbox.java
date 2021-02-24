package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> {

    @JDIAction("Click on '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isSelected() {
        return core().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotSelected() {
        return !isSelected();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isEnabled() {
        return core().isEnabled();
    }

    @JDIAction("Check '{name}'")
    public boolean check() {
        if (isSelected()) {
            return true;
        } else
            return false;
    }

    @JDIAction("Do not check '{name}'")
    public boolean unCheck() {
        if(isNotSelected()) {
            return true;
        } else
            return false;
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isDisabledCheckbox() {
        return core().hasClass("Mui-disabled");
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
