package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ButtonAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class Button extends UIBaseElement<ButtonAssert> implements HasClick, IsText {

    @UI("#basic-buttons-label")
    public Label buttonsLabel;

    @JDIAction("Get '{name}''s label text")
    public String getButtonsLabelText() {
        return buttonsLabel.text();
    }

    @JDIAction("Get if '{name}' is focused")
    public boolean isFocused() {
        return hasClass("cdk-focused");
    }

    @JDIAction()
    public String getColor() {
        return core().getCssValue("color");
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }
}
