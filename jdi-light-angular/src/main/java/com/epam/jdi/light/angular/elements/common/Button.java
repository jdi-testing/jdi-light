package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ButtonAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.angular.elements.enums.ButtonsTypes;
import com.epam.jdi.light.angular.elements.interfaces.HasBadge;
import com.epam.jdi.light.angular.elements.interfaces.HasLink;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.jdiai.tools.map.MapArray;

public class Button extends UIBaseElement<ButtonAssert> implements HasBadge, HasClick, IsText, HasLink {

    private static final String ICON_LOCATOR = ".//mat-icon";
    private static final String LABEL_LOCATOR = ".mdc-button__label";

    @JDIAction(value = "Get if '{name}' is focused")
    public boolean focused() {
        return core().hasClass("cdk-focused");
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        if (core().hasAttribute("color")) {
            return AngularColors.fromName(core().attr("color")).getColor();
        }
        return core().getCssValue("background-color");
    }

    @JDIAction("Get if '{name}' has default color")
    public boolean defaultColor() {
        return attrs().has("defaultcolor");
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().find(LABEL_LOCATOR).text();
    }

    @JDIAction("Get visual type '{name}'")
    public ButtonsTypes visualType() {
        MapArray<String, String> attrsMap = this.attrs();
        for (int i = 0; i < ButtonsTypes.size(); i++) {
            if (attrsMap.has(ButtonsTypes.values()[i].getType())) {
                return ButtonsTypes.values()[i];
            }
        }
        return ButtonsTypes.UNDEFINED;
    }

    @JDIAction("Get if there is icon inside the button")
    public boolean hasIcon() {
        return !core().finds(ICON_LOCATOR).isEmpty();
    }

    @JDIAction("Get icon inside the button")
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(ICON_LOCATOR));
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }
}
