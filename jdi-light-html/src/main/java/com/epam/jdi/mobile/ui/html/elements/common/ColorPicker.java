package com.epam.jdi.mobile.ui.html.elements.common;

import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.base.UIBaseElement;
import com.epam.jdi.mobile.elements.interfaces.base.HasLabel;
import com.epam.jdi.mobile.elements.interfaces.base.SetValue;
import com.epam.jdi.mobile.ui.html.asserts.ColorAssert;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ColorPicker extends UIBaseElement<ColorAssert> implements HasLabel, SetValue {
    // region Actions
    @JDIAction("Get '{name}' color")
    public String color() { return uiElement.attr("value"); }
    @JDIAction("Set color '{0}' for '{name}'")
    public void setColor(String color) {
        uiElement.setAttribute("value", color);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setColor(value);
    }
    public String getValue() {
        return color();
    }
    // endregion

    // region Extend assertions
    @Override
    public ColorAssert is() {
        return new ColorAssert().set(this);
    }
    // endregion
}
