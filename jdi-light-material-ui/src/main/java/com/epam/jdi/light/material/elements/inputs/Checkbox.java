package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/checkboxes/
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasCheck {

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return hasClass("Mui-checked");
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (!isChecked()) {
            this.click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if(isChecked()) {
            this.click();
        }
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return !this.hasClass("Mui-disabled") && super.isEnabled();
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
