package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.BadgeAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends UIBaseElement<BadgeAssert> implements HasClick {

    @JDIAction("Get '{name}' badge")
    public UIElement badge() {
        return this.find(".mat-badge-content");
    }

    @JDIAction("'{name}' has color '{0}'")
    public boolean color(String color) {
        return getColor().equalsIgnoreCase(color);
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @JDIAction("Get '{name}' color")
    private String getColor() {
        return getColor(badge().css("background-color"));
    }

    private String getColor(String bgValue) {
        switch (bgValue) {
            case "rgba(103, 58, 183, 1)":
                return "violet";
            case "rgba(244, 67, 54, 1)":
                return "red";
            case "rgba(255, 215, 64, 1)":
                return "yellow";
            default:
                return "unknown color";
        }
    }

    public boolean size(String value) {
        return getBadgeSize().equalsIgnoreCase(value);
    }

    private String getAttrClass() {
        return attr("class");
    }

    private String getBadgeSize() {
        return getBadgeSize(getAttrClass());
    }

    private String getBadgeSize(String aClass) {
        String medium = "mat-badge-medium";
        String large = "mat-badge-large";
        String small = "mat-badge-small";
        if (aClass.contains(medium)) {
            return "medium";
        }
        if (aClass.contains(large)) {
            return "large";
        }
        if (aClass.contains(small)) {
            return "small";
        }
        return "unknown size";
    }

    public boolean positionVertical(String position) {
        return getPositionVertical().equalsIgnoreCase(position);
    }

    private String getPositionVertical() {
        return getPositionVertical(getAttrClass());

    }

    private String getPositionVertical(String aClass) {
        String above = "mat-badge-above";
        String below = "mat-badge-below";
        if (aClass.contains(above)) {
            return "above";
        }
        if (aClass.contains(below)) {
            return "below";
        }
        return "unknown vertical position";
    }

    public boolean positionHorizontal(String position) {
        return getPositionHorizontal().equalsIgnoreCase(position);
    }

    private String getPositionHorizontal() {
        return getPositionHorizontal(getAttrClass());
    }

    private String getPositionHorizontal(String aClass) {
        String before = "mat-badge-before";
        String after = "mat-badge-after";
        if (aClass.contains(before)) {
            return "before";
        }
        if (aClass.contains(after)) {
            return "after";
        }
        return "unknown horizontal position";
    }

    public boolean overlap() {
        return getAttrClass().contains("mat-badge-overlap");
    }

    public boolean hidden() {
        return getAttrClass().contains("mat-badge-hidden");
    }

    public boolean disabled() {
        return getAttrClass().contains("mat-badge-disabled");
    }

}
