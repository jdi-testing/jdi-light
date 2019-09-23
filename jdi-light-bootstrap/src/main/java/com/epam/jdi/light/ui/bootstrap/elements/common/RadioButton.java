package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.asserts.RadioButtonAssert;

public class RadioButton extends UIBaseElement<RadioButtonAssert> {

    @JDIAction("Check '{name}'")
    public void select() {
        uiElement.check();
    }

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return uiElement.isSelected();
    }

    @Override
    public RadioButtonAssert is() {
        return new RadioButtonAssert().set(this);
    }
}
