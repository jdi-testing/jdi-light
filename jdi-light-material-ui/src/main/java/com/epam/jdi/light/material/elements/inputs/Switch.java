package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.inputs.SwitchAssert;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.HasColor;

/**
 * Represent switch MUI component on GUI. Switches toggle the state of a single setting on or off ('checked' and
 * 'unchecked' states respectively).
 *
 * @see <a href="https://v4.mui.com/components/switches/">Switch MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel, CanBeDisabled, HasColor {

    /**
     * Checks if the switch is checked or not.
     *
     * @return {@code true} if the switch is checked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is checked")
    public boolean isChecked() {
        return firstChild().hasClass("Mui-checked");
    }

    /**
     * Checks if the switch is unchecked or not.
     *
     * @return {@code true} if the switch is unchecked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is unchecked")
    public boolean isUnchecked() {
        return !isChecked();
    }

    /**
     * Checks this switch. If it's already checked, does nothing.
     */
    @JDIAction("Check '{name}'")
    public void check() {
        if (isUnchecked()) {
            click();
        }
    }

    /**
     * Unchecks this switch. If it's already unchecked, does nothing.
     */
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

    @JDIAction("Check that '{name}' is enabled")
    @Override
    public boolean isEnabled() {
        return !this.isDisabled();
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
