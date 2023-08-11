package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ButtonAssert;
import com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

@UI("button")
public class Button extends UIBaseElement<ButtonAssert> implements HasClick, IsText {

    @JDIAction(value = "Get if '{name}' is focused")
    public boolean focused() {
        return hasClass("cdk-focused");
    }

    @JDIAction(value = "Get '{name}' color")
    public String color() {
        return core().getAttribute("color");
    }

    @JDIAction(value = "Get if '{name}' has default color")
    public boolean defaultColor() {
        return attrs().has("defaultcolor");
    }

    @JDIAction(value = "Get if '{name}' has expected visual type '{0}'")
    public String visualTypeOfButton() {
        for (int i = 0; i < ButtonsTypes.size(); i++) {
            if (attrs().has(ButtonsTypes.values()[i].getType())) {
                return ButtonsTypes.values()[i].getType();
            }
        }
        return null;
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }
}
