package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.AlertAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class Alert extends UIBaseElement<AlertAssert> implements IsText, HasIcon {

    @JDIAction("Get 'name' color")
    public String color() {
        return core().css("color");
    }

    @JDIAction("Get 'name' background color")
    public String backgroundColor() {
        return core().css("background-color");
    }

    @Override
    public AlertAssert is() {
        return new AlertAssert().set(this);
    }
}
