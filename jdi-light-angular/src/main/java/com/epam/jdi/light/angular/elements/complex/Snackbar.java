package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SnackbarAssert;
import com.epam.jdi.light.angular.elements.enums.Position;
import com.epam.jdi.light.angular.elements.interfaces.HasPosition;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of Snackbar web element please visit https://material.angular.io/components/snack-bar/overview.
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements HasPosition {
    @Deprecated
    private UIElement message;
    @Deprecated
    protected UIElement action;
    private String messageLocator = ".mat-mdc-snack-bar-label .mdc-snackbar__label";
    private String actionLocator = ".//button";

    @Deprecated
    public Snackbar() {
        message = new UIElement();
        message.core()
                .setLocator(messageLocator);

        action = new UIElement();
        action.core()
                .setLocator(actionLocator);
    }

    @Deprecated
    @JDIAction("Get '{name}' message")
    public String getMessageText() {
        return message.getValue();
    }

    @Deprecated
    @JDIAction("Get '{name}' action")
    public String getActionText() {
        return action.getValue();
    }

    @JDIAction("Get '{name}' message")
    public String messageText() {
        return message.getValue();
    }

    @JDIAction("Get '{name}' action")
    public String actionText() {
        return action.getValue();
    }

    @Deprecated
    @JDIAction("Click '{name}' action")
    public void clickAction() {
        action.click();
    }

    @JDIAction("Click '{name}' action")
    public UIElement actionIcon() {
        return this.action;
    }

    @Deprecated
    @JDIAction("Is '{name}' action displayed")
    public boolean isActionDisplayed() {
        return action.isDisplayed();
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }

    @Override
    public Position position() {
        return null;
    }

    @Override
    public Position getPositionFromClass(final UIElement element, final String className) {
        return HasPosition.super.getPositionFromClass(element, className);
    }

    @Override
    public Position getPositionFromAttribute(final String attributeValue) {
        return HasPosition.super.getPositionFromAttribute(attributeValue);
    }
}
