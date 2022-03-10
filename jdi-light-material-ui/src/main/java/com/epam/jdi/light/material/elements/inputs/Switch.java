package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.inputs.SwitchAssert;
import com.epam.jdi.light.material.interfaces.base.HasColor;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel, HasColor {

    @JDIAction("Is '{name}' turned on")
    public boolean isTurnedOn() {
        return firstChild().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' turned off")
    public boolean isTurnedOff() {
        return !isTurnedOn();
    }

    @JDIAction("Turn '{name}' on")
    public void turnOn() {
        if (isTurnedOff()) {
            click();
        }
    }

    @JDIAction("Turn '{name}' off")
    public void turnOff() {
        if (isTurnedOn()) {
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
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
