package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.inputs.SwitchAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.base.HasColor;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel, HasColor, CanBeDisabled {

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return firstChild().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
    public boolean isUnchecked() {
        return !isChecked();
    }

    @JDIAction("Checked '{name}'")
    public void checked() {
        if (isUnchecked()) {
            click();
        }
    }

    @JDIAction("Unchecked '{name}'")
    public void unchecked() {
        if (isChecked()) {
            click();
        }
    }

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, core().findUp());
    }

    @Override
    @JDIAction("Get '{name}'s label text")
    public String labelText() {
        return label().find(".MuiFormControlLabel-label").getText();
    }

    @Override
    public boolean isDisabled() {
        return this.containsDisabled();
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
