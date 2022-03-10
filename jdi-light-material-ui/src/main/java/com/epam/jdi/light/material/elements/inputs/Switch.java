package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.inputs.SwitchAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;

/**
 * To see an example of Switch web element please visit
 * https://mui.com/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel, CanBeDisabled {

    @JDIAction("Check that '{name}' is checked")
    public boolean isChecked() {
        return firstChild().hasClass("Mui-checked");
    }

    @JDIAction("Check that '{name}' is unchecked")
    public boolean isUnchecked() {
        return !isChecked();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isUnchecked()) {
            click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isChecked()) {
            click();
        }
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return new Label().setCore(Label.class, core().findUp());
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().core().find(".MuiFormControlLabel-label").getText();
    }

    @JDIAction("Check that '{name}' is disabled")
    @Override
    public boolean isDisabled() {
        return containsDisabled();
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
