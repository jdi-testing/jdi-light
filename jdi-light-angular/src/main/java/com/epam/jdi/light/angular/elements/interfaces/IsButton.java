package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.angular.elements.common.Icon;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.angular.elements.enums.ButtonsTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.jdiai.tools.map.MapArray;

/**
 * In angular element can be with Button, so this interface can be used to work with it
 */
public interface IsButton extends ICoreElement {
    String ICON_LOCATOR = ".//mat-icon";

    @JDIAction(value = "Get if '{name}' is focused")
    default boolean focused() {
        return core().hasClass("cdk-focused");
    }

    @JDIAction("Get '{name}' color")
    default String color() {
        if (core().hasAttribute("color")) {
            return AngularColors.fromName(core().attr("color"))
                    .getColor();
        }
        return core().getCssValue("background-color");
    }

    @JDIAction("Get visual type '{name}'")
    default ButtonsTypes visualType() {
        MapArray<String, String> attrsMap = this.attrs();
        for (int i = 0; i < ButtonsTypes.size(); i++) {
            if (attrsMap.has(ButtonsTypes.values()[i].getType())) {
                return ButtonsTypes.values()[i];
            }
        }
        return ButtonsTypes.UNDEFINED;
    }

    @JDIAction("Get if '{name}' has default color")
    default boolean defaultColor() {
        return attrs().has("defaultcolor");
    }

    @JDIAction("Get if there is icon inside the button")
    default boolean hasIcon() {
        return !core().finds(ICON_LOCATOR)
                .isEmpty();
    }

    @JDIAction("Get icon inside the button")
    default Icon icon() {
        return new Icon().setCore(Icon.class, core().find(ICON_LOCATOR));
    }
}
