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
    private static final String MESSAGE_LOCATOR = ".mat-mdc-snack-bar-label .mdc-snackbar__label";
    private static final String ACTION_LOCATOR = ".//button";
    private static final String OVERLAY_LOCATOR = "//ancestor::div[@class='cdk-global-overlay-wrapper']";

    @JDIAction("Get '{name}' action")
    public UIElement action() {
        return core().find(ACTION_LOCATOR);
    }

    @JDIAction("Get '{name}' message")
    public UIElement message() {
        return core().find(MESSAGE_LOCATOR);
    }

    @Override
    @JDIAction("Get '{name}' position")
    public Position position() {
        return getPositionFromAttribute("style");
    }

    @Override
    public Position getPositionFromAttribute(String attributeValue) {
        return Position.fromFullString(core().find(OVERLAY_LOCATOR)
                                               .attr(attributeValue));
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
