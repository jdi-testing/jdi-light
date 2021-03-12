package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.CheckboxAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.ICheckbox;

public class Checkbox extends MobileAppBaseElement<CheckboxAssert> implements ICheckbox {
    @JDIAction(value = "Perform tap on '{name}' to get checked station")
    public void check() {
        if (!isChecked()) {
            core().check();
        }
    }

    @JDIAction(value = "Perform tap on '{name}' to get unchecked station")
    public void uncheck() {
        if (isChecked()) {
            core().uncheck();
        }
    }

    @JDIAction(value = "Verify '{name}' is checked")
    public boolean isChecked() {
        return core().isSelected();
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}

