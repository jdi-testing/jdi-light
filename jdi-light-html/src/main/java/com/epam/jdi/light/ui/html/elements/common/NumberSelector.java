package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.ui.html.asserts.NumberAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class NumberSelector extends UIBaseElement<NumberAssert> implements WithLabel, HasValue {
    // region Actions

    @JDIAction(value = "Get '{name}' placeholder", level = DEBUG)
    public String placeholder() { return element.attr("placeholder"); }
    @JDIAction(value = "Get '{name}' min value", level = DEBUG)
    public String min() { return element.attr("min"); }
    @JDIAction(value = "Get '{name}' max value", level = DEBUG)
    public String max() { return element.attr("max"); }
    @JDIAction(value = "Get '{name}' value", level = DEBUG)
    public String value() { return element.attr("value"); }
    @JDIAction(value = "Get '{name}' step size", level = DEBUG)
    public String step() { return element.attr("step"); }
    @JDIAction("Select number '{0}' for '{name}'")
    public void setNumber(String number) {
        setValue(number);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setNumber(value);
    }
    public String getValue() {
        return value()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public NumberAssert is() {
        return new NumberAssert().set(this);
    }
    // endregion

}
