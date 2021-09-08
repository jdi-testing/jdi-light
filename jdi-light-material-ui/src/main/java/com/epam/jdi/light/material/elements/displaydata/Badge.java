package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;

public class Badge extends UIBaseElement<BadgeAssert> {
    //Exactly the same class named Badge is in the Angular module
    @JDIAction("Get '{name}' badge")
    public UIElement badge() {
        return this.find(".mat-badge-content");
    }

    @JDIAction("'{name}' has color '{0}'")
    public boolean color(String color) {
        return getColor(badge().css("background-color")).equalsIgnoreCase(color);
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    private String getColor(String bgValue) {
        //Should be overriden with current colors from your site
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
