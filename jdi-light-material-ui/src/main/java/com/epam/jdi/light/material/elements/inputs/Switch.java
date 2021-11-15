package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.inputs.SwitchAssert;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel {

    @JDIAction("Is '{name}' turned on")
    public boolean isTurnedOn() {
        return buttonBase().hasClass("Mui-checked");
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

    @JDIAction("Does '{name}' have primary color")
    public boolean hasPrimaryColor() {
        return getColor().equals("colorPrimary");
    }

    @JDIAction("Does '{name}' have secondary color")
    public boolean hasSecondaryColor() {
        return getColor().equals("colorSecondary");
    }

    @JDIAction("Does '{name}' have secondary color")
    public boolean hasUndefinedColor() {
        return getColor().equals("");
    }

    @Override
    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled() {
        return buttonBase().attr("aria-disabled").equals("true");
    }

    @Override
    @JDIAction("Is '{name}' enabled")
    public boolean isEnabled() {
        return !isDisabled();
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

    private UIElement buttonBase() {
        return find(".MuiButtonBase-root");
    }

    private String getColor() {
        return Arrays.stream(buttonBase().getAttribute("class")
                        .split("[^a-zA-Z0-9]"))
                .filter(s -> s.startsWith("color"))
                .collect(Collectors.joining());
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }

    @Override
    public SwitchAssert has() {
        return is();
    }

}
