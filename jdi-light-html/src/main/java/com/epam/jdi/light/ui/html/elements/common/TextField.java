package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.asserts.TextAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class TextField extends UIBaseElement<TextAssert> implements WithLabel, SetValue {
    // region Actions
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) { element.sendKeys(value); }
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        element.setText(value);
    }
    @JDIAction("Clear '{name}'")
    public void clear() { element.clear(); }
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        element.input(value);
    }
    @JDIAction(level = DEBUG)
    public void focus(){ sendKeys(""); }
    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return element.placeholder(); }

    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        input(value);
    }
    public String getValue() {
        return getText();
    }
    // endregion
}
