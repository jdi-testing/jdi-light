package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    @JDIAction("Assert that '{name}' is 'on'")
    public SwitchAssert turnedOn() {
        jdiAssert(element().isTurnedOn() ? "is turned on" : "is turned off", Matchers.is("is turned on"));
        return this;
    }

    @JDIAction("Assert that '{name}' is 'off'")
    public SwitchAssert turnedOff() {
        jdiAssert(element().isTurnedOff() ? "is turned off" : "is turned on", Matchers.is("is turned off"));
        return this;
    }

    @JDIAction("Assert that '{name}' has primary color")
    public SwitchAssert primaryColor() {
        jdiAssert(element().hasPrimaryColor() ? "has primary color" : "does not have primary color",
                Matchers.is("has primary color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary color")
    public SwitchAssert secondaryColor() {
        jdiAssert(element().hasSecondaryColor() ? "has secondary color" : "does not have secondary color",
                Matchers.is("has secondary color"));
        return this;
    }

//    @JDIAction("Assert that '{name}' has undefined color")
//    public SwitchAssert undefinedColor() {
//        jdiAssert(element().hasUndefinedColor() ? "has undefined color" : "does not have undefined color",
//                Matchers.is("has undefined color"));
//        return this;
//    }

    @JDIAction("Assert that '{name}' is enabled")
    public SwitchAssert enabled() {
        jdiAssert(element().isEnabled() ? "is enabled" : "is disabled", Matchers.is("is enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public SwitchAssert disabled() {
        jdiAssert(element().isDisabled() ? "is disabled" : "is enabled", Matchers.is("is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public SwitchAssert label() {
        jdiAssert(element().label().isDisplayed() ? "has label" : "does not have label",
                Matchers.is("has label"));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public SwitchAssert labelText(String labelText) {
        jdiAssert(element().labelText(), Matchers.is(labelText));
        return this;
    }

}