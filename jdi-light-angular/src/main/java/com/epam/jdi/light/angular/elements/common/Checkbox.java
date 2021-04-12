package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.CheckboxAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/checkbox/overview.
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasLabel, HasClick, HasCheck, CanBeSelected {
    public static final String ARIA_CHECKED = "aria-checked";

    @JDIAction("Check '{name}'")
    @Override
    public void check() {
        if (!isSelected()) {
            click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    @Override
    public void uncheck() {
        if (isSelected()) {
            click();
        }
    }

    @JDIAction("Is '{name}' selected")
    @Override
    public boolean isSelected() {
        boolean attribute = hasAttribute(ARIA_CHECKED) && attr(ARIA_CHECKED).equals("true");
        return hasClass("mat-checkbox-checked") || attribute || core().isSelected();
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        if (hasClass("mat-checkbox-disabled")) {
            return false;
        } else {
            return super.isEnabled();
        }
    }

    @Override
    public boolean isDisabled() {
        return !isEnabled();
    }

    @JDIAction("Get '{name}' label")
    @Override
    public Label label() {
        if (core().label().isDisplayed()) {
            return core().label();
        }
        com.epam.jdi.light.elements.common.uiElement input = core().find("input[type=checkbox]");
        if (input.label().isDisplayed()) {
            return input.label();
        }
        throw exception("Can't find label for element %s", this);
    }

    @JDIAction("Click on '{name}'")
    @Override
    public void click() {
        if (label().isDisplayed()) {
            label().click();
        } else {
            core().click();
        }
    }

    @JDIAction("Is '{name}' indeterminate")
    public boolean isIndeterminate() {
        return hasClass("mat-checkbox-indeterminate") || attr(ARIA_CHECKED).equals("mixed");
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
