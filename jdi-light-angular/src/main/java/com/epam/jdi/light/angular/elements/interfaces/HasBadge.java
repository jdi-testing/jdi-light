package com.epam.jdi.light.angular.elements.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.angular.elements.enums.BadgePosition;
import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * In angular any element can be with Badge, so this interface can be used to work with it
 */
public interface HasBadge extends ICoreElement {

    default Badge badge() {
        return new Badge().setCore(Badge.class, this.find(".mat-badge-content"));
    }

    @JDIAction("Get '{name}' size")
    default BadgeSize badgeSize() {
        String styles = core().attr("class");
        Pattern bufferValuePattern = Pattern.compile("mat-badge-(medium|large|small)\\b");
        Matcher matcher = bufferValuePattern.matcher(styles);
        if (matcher.find()) {
            String sizeStyle = matcher.group();
            return BadgeSize.fromName(sizeStyle);
        }

        return BadgeSize.UNKNOWN;
    }

    @JDIAction("Get '{name}' vertical position")
    default BadgePosition badgePositionVertical() {
        if (core().hasClass("mat-badge-above")) {
            return BadgePosition.ABOVE;
        }
        if (core().hasClass("mat-badge-below")) {
            return BadgePosition.BELOW;
        }
        return BadgePosition.UNKNOWN;
    }


    @JDIAction("Get '{name}' horizontal position")
    default BadgePosition badgePositionHorizontal() {
        if (core().hasClass("mat-badge-before")) {
            return BadgePosition.BEFORE;
        }
        return BadgePosition.AFTER;
    }

    @JDIAction(value = "Check that '{name}' is overlap")
    default boolean isBadgeOverlap() {
        return core().hasClass("mat-badge-overlap");
    }

    default boolean isBadgeHidden() {
        return core().hasClass("mat-badge-hidden");
    }

    default boolean isBadgeDisplayed() {
        return !isHidden();
    }

    default boolean isBadgeDisabled() {
        return core().hasClass("mat-badge-disabled");
    }

    default boolean isBadgeEnabled() {
        return !isDisabled();
    }

    default AngularColors badgeColor() {
        return AngularColors.fromType(core().attr("matbadgecolor"));
    }
}
