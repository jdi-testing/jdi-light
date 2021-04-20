package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert>{

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return this.core().hasClass("Mui-checked");
    }

    @JDIAction("'{name}' has {className} class")
    @Override
    public boolean hasClass(String className) {
        return this.core().hasClass(className);
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
        return this.core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
