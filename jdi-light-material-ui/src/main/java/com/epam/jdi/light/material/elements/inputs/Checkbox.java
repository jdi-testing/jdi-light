package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/checkboxes/
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasLabel, HasColor, CanBeDisabled {

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
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
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, core().findUp());
    }

    @JDIAction("Is '{name}' indeterminate")
    public boolean isIndeterminate() {
        return hasClass("MuiCheckbox-indeterminate");
    }

    @JDIAction("Get '{name}'s label position")
    public String getLabelPosition() {
        if (label().isDisplayed()) {
            String labelPosition;
            String position = Arrays.stream(label().attr("class")
                            .split("[^a-zA-Z0-9]"))
                    .filter(s -> s.startsWith("labelPlacement"))
                    .collect(Collectors.joining())
                    .replace("labelPlacement", "");
            switch (position) {
                case ("Top"):
                    labelPosition = "top";
                    break;
                case ("Start"):
                    labelPosition = "start";
                    break;
                case ("Bottom"):
                    labelPosition = "bottom";
                    break;
                default:
                    labelPosition = "end";
                    break;
            }
            return labelPosition;
        } else {
            throw exception("Checkbox does not have label");
        }
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
