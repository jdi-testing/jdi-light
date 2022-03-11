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
import com.epam.jdi.light.material.interfaces.base.HasColor;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Checkbox group List web element please visit
 * https://mui.com/components/checkboxes/
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasLabel, HasColor {

    @UI("svg")
    private Icon icon;

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, core().findUp());
    }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() { return icon; }

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

    @JDIAction("Check '{name}' is checked")
    public boolean isChecked() {
        return core().find("input").isSelected();
    }

    @JDIAction("Check '{name}' is unchecked")
    public boolean isUnchecked() {
        return !isChecked();
    }

    @Override
    @JDIAction("Check '{name}' is enable")
    public boolean isEnabled() {
        return core().find("input").isEnabled();
    }


    @JDIAction("Is '{name}' indeterminate")
    public boolean isIndeterminate() {
        return core().hasClass("MuiCheckbox-indeterminate");
    }

    @JDIAction("Get '{name}'s label position")
    public Position labelPosition() {
        if (label().isDisplayed()) {
            String position = Arrays.stream(label().attr("class")
                            .split("[^a-zA-Z0-9]"))
                    .filter(s -> s.startsWith("labelPlacement"))
                    .collect(Collectors.joining())
                    .replace("labelPlacement", "");
            return Position.fromString(position);
        } else {
            throw runtimeException("Checkbox does not have label");
        }
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
