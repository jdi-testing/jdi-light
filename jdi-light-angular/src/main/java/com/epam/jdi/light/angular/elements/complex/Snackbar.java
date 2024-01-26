package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SnackbarAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of Snackbar web element please visit https://material.angular.io/components/snack-bar/overview.
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> {
    protected UIElement message;
    protected String messageLocator = "//*[@matsnackbarlabel]";

    protected UIElement action;
    protected String actionLocator = ".//button";

    public Snackbar() {
        message = new UIElement();
        message.core().setLocator(messageLocator);

        action = new UIElement();
        action.core().setLocator(actionLocator);
    }

    @JDIAction("Get '{name}' message")
    public String getMessageText() {
        return message.getText();
    }

    @JDIAction("Get '{name}' action")
    public String getActionText() {
        return action.getValue();
    }

    @JDIAction("Click '{name}' action")
    public void clickAction() {
        action.click();
    }

    @JDIAction("Is '{name}' action displayed")
    public boolean isActionDisplayed() {
        return action.isDisplayed();
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
