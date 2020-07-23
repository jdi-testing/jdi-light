package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.SnackbarAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * Angular snack-bar documentation: https://jdi-docs.github.io/jdi-light/?java#progress-spinner
 */
public class Snackbar extends UIBaseElement<SnackbarAssert> {
    protected UIElement message;
    protected UIElement action;

    public Snackbar() {
        message = new UIElement();
        message.core().setLocator("./span");

        action = new UIElement();
        action.core().setLocator(".//button");
    }

    public String getMessageText() {
        return message.getValue();
    }

    public String getActionText() {
        return action.getValue();
    }

    public void clickAction() {
        action.click();
    }

    public boolean isActionDisplayed() {
        return action.isDisplayed();
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}