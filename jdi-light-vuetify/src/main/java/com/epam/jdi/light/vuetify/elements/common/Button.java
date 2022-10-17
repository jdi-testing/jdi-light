package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ButtonAssert;


public class Button extends UIBaseElement<ButtonAssert>  {

    @JDIAction("Get 'name' color")
    public String color() {
        return core().css("color");
    }

    @JDIAction("Get 'name' background color")
    public String backgroundColor() {
        return core().css("background-color");
    }

    @JDIAction("Get 'name' border color")
    public String borderColor() {
        return core().css("border-color");
    }

    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }
}
