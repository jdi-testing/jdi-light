package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.RadioButtonAssert;

/**
 * Created by Dmitrii Pavlov on 24.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButton extends UIListBase<RadioButtonAssert> {

    @UI("input")
    private UIElement input;

    @JDIAction("Check '{name}'")
    public void select() {
        uiElement.check();
    }

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return input.isSelected();
    }

    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return input.isEnabled();
    }

    @JDIAction("Select '{0}' in '{name}'")
    public UIElement get(int index) {
        return list().get(index);
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        list().select(index);
    }

    @JDIAction("Click at '{name}'")
    public void click() {
            label().click();
    }

    public Label label() {
        return input.label();
    }

    @Override
    public RadioButtonAssert is() {
        return new RadioButtonAssert().set(this);
    }
}
