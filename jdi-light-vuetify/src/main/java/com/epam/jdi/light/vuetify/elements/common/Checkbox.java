package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> {

    public String label = "//label";

    public UIElement label() {
        return linked(label, "label");
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return label().core().attr("aria-checked").equals("true");
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
