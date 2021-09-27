package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.CheckboxAssert;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see an example of Checkbox web element please visit https://vuetifyjs.com/en/components/checkboxes/
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasLabel {

    public String input = "div input";
    public UIElement input() {
        return $(input, this);
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return input().attr("aria-checked").equalsIgnoreCase("true");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotChecked() {
        return !isChecked();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isNotChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if(isChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Is '{name}' disabled")
    @Override
    public boolean isDisabled() {
        return this.core().hasClass("v-input--is-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public Label label() {
        Label label = safeGetLabel();
        if (label != null) {
            return label;
        }
        throw exception("Can't find label for element %s", this);
    }
    private Label safeGetLabel() {
        if (core().label().isDisplayed()) {
            return core().label();
        }
        UIElement input = core().find("input[type=checkbox]");
        boolean hasLabelInput;
        try {
            hasLabelInput = input.label().isDisplayed();
        } catch (Exception ignore) { hasLabelInput = false; }
        return hasLabelInput ? input.label() : null;
    }

    @JDIAction("'{name}' has '{className}' class")
    public String labelText() {
        return label().getText();
    }

    @JDIAction("'{name}' is indeterminate")
    public boolean isIndeterminate() {
        return this.core().hasClass("v-input--indeterminate");
    }

    @JDIAction("'{name}' has '{className}' class")
    @Override
    public boolean hasClass(String className) {
        return this.core().hasClass(className);
    }
}
