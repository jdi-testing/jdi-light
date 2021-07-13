package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;

import static com.epam.jdi.light.common.TextTypes.VALUE;

public class TextField extends UIBaseElement<TextFieldAssert> {

    public TextField(){}

    public TextField(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Set '{0}' value in '{name}'")
    public void setValue(String value) {
        core().input(value);
    }

    @JDIAction("Clear the existing data Set '{0}' value in '{name}'")
    public void clearAndSetValue(String value) {
        core().clear();
        core().input(value);
    }

    @JDIAction("Get value of '{name}'")
    public String getValue() {
        return core().text(VALUE);
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} read-only")
    public boolean isReadOnly() {
        return core().hasAttribute("readonly");
    }

    @JDIAction("Get text of '{name}")
    public String getText() {
        return core().getText();
    }

    @JDIAction("Clear '{name}'")
    public void clear() {
        core().clear();
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }

    @Override
    public TextFieldAssert has() {
        return this.is();
    }

    @JDIAction("Click to focus on '{name}' textfield")
    public void click() {
        core().click();
    }
}
