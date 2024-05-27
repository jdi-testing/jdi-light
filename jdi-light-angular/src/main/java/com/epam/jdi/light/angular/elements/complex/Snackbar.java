package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.SnackbarAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * To see an example of Snackbar web element please visit https://material.angular.io/components/snack-bar/overview.
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> {
    protected String messageLocator = ".mdc-snackbar__label";
    protected String actionLocator = ".//button";

    @JDIAction("Get '{name}' message")
    public Button actionButton() {
        return new Button().setCore(Button.class, core().find(this.actionLocator));
    }

    @JDIAction("Get Snackbar message")
    public String messageText() {
        return this.find(messageLocator).getText();
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
