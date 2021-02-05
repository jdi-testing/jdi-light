package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> {

    @JDIAction("Click on '{name}'")
    public void clickOnCheckbox() {
        core().click();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isSelectedCheckbox() {
        return core().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotSelectedCheckbox() {
        return !isSelectedCheckbox();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isEnabledCheckbox() {
        return core().isEnabled();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isNotSelectedCheckbox()) {
            core().click();
        }
    }

    @JDIAction("Do not check '{name}'")
    public void unCheck() {
        if(!isNotSelectedCheckbox()) {
            core().click();
        }
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }


}
