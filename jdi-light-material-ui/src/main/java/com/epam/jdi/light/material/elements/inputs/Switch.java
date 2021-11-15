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

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel {

    @JDIAction("Assert that '{name}' is turned on")
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

    @JDIAction("Is '{name}' disabled")
    @Override
    public boolean isDisabled() {
        return buttonBase().attr("aria-disabled").equals("true");
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public Label label() {
        return castToLabel(core().find("ancestor::label"));
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().find(".MuiFormControlLabel-label").getText();
    }

    private Label castToLabel(UIElement element) {
        return new Label().setCore(Label.class, element);
    }

    private UIElement buttonBase() {
        return $(".MuiButtonBase-root", this);
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
