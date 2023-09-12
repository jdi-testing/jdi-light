package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.angular.elements.enums.BadgePosition;
import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import static com.epam.jdi.light.angular.elements.enums.BadgeSize.*;

/**
 * In angular any element can be with Badge, so this interface can be used to work with it
 */
public interface HasBadge extends ICoreElement {

    default Badge badge() {
        return new Badge().setCore(Badge.class, this.find(".mat-badge-content"));
    }

    @JDIAction("Get '{name}' size")
    default BadgeSize badgeSize() {
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
    default BadgePosition badgePositionVertical() {
        if (hasClass("mat-badge-above")) {
            return BadgePosition.ABOVE;
        }
        if (hasClass("mat-badge-below")) {
            return BadgePosition.BELOW;
        }
        return BadgePosition.UNKNOWN;
    }


    @JDIAction("Get '{name}' horizontal position")
    default BadgePosition badgePositionHorizontal() {
        if (hasClass("mat-badge-before")) {
            return BadgePosition.BEFORE;
        }
        return BadgePosition.AFTER;
    }

    @JDIAction(value = "Check that '{name}' is overlap")
    default boolean isBadgeOverlap() {
        return hasClass("mat-badge-overlap");
    }

    default boolean isBadgeHidden() {
        return hasClass("mat-badge-hidden");
    }

    default boolean isBadgeDisplayed() {
        return !isHidden();
    }

    default boolean isBadgeDisabled() {
        return hasClass("mat-badge-disabled");
    }

    default boolean isBadgeEnabled() {
        return !isDisabled();
    }

    default AngularColors badgeColor() {
        return AngularColors.fromColor(core().attr("matbadgecolor"));
    }
}
