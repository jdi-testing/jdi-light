package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ButtonAssert;
import com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class Button extends UIBaseElement<ButtonAssert> implements HasClick, IsText {

    @UI("#basic-buttons-label")
    public Label basicbuttonLabel;
    @UI("#raised-buttons-label")
    public Label raisedButtonLabel;
    @UI("#stroked-buttons-label")
    public Label strokedButtonLabel;
    @UI("#flat-buttons-label")
    public Label flatButtonLabel;
    @UI("#icon-buttons-label")
    public Label iconButtonLabel;
    @UI("#fab-buttons-label")
    public Label fabButtonLabel;
    @UI("#minifab-buttons-label")
    public Label miniFabButtonLabel;

    @JDIAction(value = "Get '{name}''s label text")
    public String buttonLabelText(ButtonsTypes type) {
        switch (type) {
            case BASIC:
                return basicbuttonLabel.text();
            case RAISED:
                return raisedButtonLabel.text();
            case STROKED:
                return strokedButtonLabel.text();
            case FLAT:
                return flatButtonLabel.text();
            case ICON:
                return iconButtonLabel.text();
            case FAB:
                return fabButtonLabel.text();
            case MINI_FAB:
                return miniFabButtonLabel.text();
        }
        return null;
    }

    @JDIAction(value = "Get if '{name}' is focused")
    public boolean focused() {
        return hasClass("cdk-focused");
    }

    @JDIAction(value = "Get '{name}' color")
    public String color() {
        return core().getCssValue("color");
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }
}
