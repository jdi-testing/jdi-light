package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.angular.asserts.SnackbarAssert;

import com.epam.jdi.light.common.JDIAction;

/**
 * Angular snack-bar documentation: https://jdi-docs.github.io/jdi-light/?java#progress-spinner
 */
public class Snackbar extends UIBaseElement<SnackbarAssert> {
    protected UIElement message;
    protected String messageLocator = "./span";

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
        return message.getValue();
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