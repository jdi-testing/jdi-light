package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.BadgeAssert;
import com.epam.jdi.light.angular.elements.enums.BadgePosition;
import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.angular.elements.enums.BadgeSize.LARGE;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.MEDIUM;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.SMALL;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends UIBaseElement<BadgeAssert> implements HasClick, IsText {

    @JDIAction("Get '{name}' badge")
    private UIElement badge() {
        return core().find(".mat-badge-content");
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        return badge().css("background-color");
    }

    @JDIAction("Get '{name}' size")
    public BadgeSize size() {
        if (hasClass("mat-badge-medium")) {
            return MEDIUM;
        }
        if (hasClass("mat-badge-large")) {
            return LARGE;
        }
        if (hasClass("mat-badge-small")) {
            return SMALL;
        }
        return BadgeSize.UNKNOWN;
    }

    @JDIAction("Get '{name}' vertical position")
    public BadgePosition positionVertical() {
        if (hasClass("mat-badge-above")) {
            return BadgePosition.ABOVE;
        }
        if (hasClass("mat-badge-below")) {
            return BadgePosition.BELOW;
        }
        return BadgePosition.UNKNOWN;
    }


    @JDIAction("Get '{name}' horizontal position")
    public BadgePosition positionHorizontal() {
        if (hasClass("mat-badge-before")) {
            return BadgePosition.BEFORE;
        }
        if (hasClass("mat-badge-after")) {
            return BadgePosition.AFTER;
        }
        return BadgePosition.UNKNOWN;
    }

    @JDIAction(value = "Check that '{name}' is overlap")
    public boolean isOverlap() {
        return hasClass("mat-badge-overlap");
    }

    @Override
    public boolean isHidden() {
        return hasClass("mat-badge-hidden");
    }

    @Override
    public boolean isDisplayed() {
        return !isHidden();
    }

    @Override
    public boolean isDisabled() {
        return hasClass("mat-badge-disabled");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public String getText() {
        return badge().getText();
    }
}
