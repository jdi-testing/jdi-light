package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.BadgeAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public class Badge extends UIBaseElement<BadgeAssert> {

    @JDIAction("Get '{name}' badge")
    public com.epam.jdi.light.elements.common.uiElement badge() {
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
}
