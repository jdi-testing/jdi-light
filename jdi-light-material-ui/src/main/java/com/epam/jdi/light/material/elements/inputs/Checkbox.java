package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Represents Checkbox MUI component on GUI. Checkboxes allow the user to select one or more items from a set.
 *
 * @see <a href="https://mui.com/components/checkboxes/">Checkbox MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasLabel, CanBeDisabled {

    /**
     * Icon that represents the checkbox icon.
     */
    @UI("svg")
    public Icon icon;

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, core().findUp());
    }

    /**
     * Checks this checkbox. If it's already checked, does nothing.
     */
    @JDIAction("Check '{name}'")
    public void check() {
        if (isUnchecked()) {
            click();
        }
    }

    /**
     * Unchecks this checkbox. If it's already unchecked, does nothing.
     */
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isChecked()) {
            click();
        }
    }

    /**
     * Checks if the checkbox is checked or not.
     *
     * @return {@code true} if the checkbox is checked, otherwise {@code false}
     */
    @JDIAction("Check '{name}' is checked")
    public boolean isChecked() {
        return core().find("input").isSelected();
    }

    /**
     * Checks if the checkbox is unchecked or not.
     *
     * @return {@code true} if the checkbox is unchecked, otherwise {@code false}
     */
    @JDIAction("Check '{name}' is unchecked")
    public boolean isUnchecked() {
        return !isChecked();
    }

    /**
     * Checks if the checkbox is indeterminate or not. A checkbox input can only have two states in a form: checked or unchecked.
     * But visually, there are three states a checkbox can be in: checked, unchecked, or indeterminate.
     *
     * @return {@code true} if the checkbox is indeterminate, otherwise {@code false}
     */
    @JDIAction("Check '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return core().hasClass("MuiCheckbox-indeterminate");
    }

    @Override
    @JDIAction("Check '{name}' is enable")
    public boolean isEnabled() {
        return core().find("input").isEnabled();
    }

    /**
     * Gets the position of the label relative to the checkbox
     *
     * @return position as {@link Position}
     * @throws RuntimeException if the checkbox does not have the label
     */
    @JDIAction("Get '{name}'s label position")
    public Position labelPosition() {
        Label lbl = label();
        if (lbl.isDisplayed()) {
            String positionClsName = "labelPlacement";
            String positionClass = lbl.classLike(positionClsName);
            if (positionClass.isEmpty()) {
                return Position.END;
            }
            return Position.fromFullString(positionClass.split(positionClsName)[1]);
        } else {
            throw runtimeException("Checkbox does not have the label");
        }
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
