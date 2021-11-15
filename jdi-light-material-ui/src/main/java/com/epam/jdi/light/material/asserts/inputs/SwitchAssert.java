package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    @JDIAction("Assert that '{name}' is 'on'")
    public SwitchAssert turnedOn() {
        jdiAssert(element().isTurnedOn(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is 'off'")
    public SwitchAssert turnedOff() {
        jdiAssert(element().isTurnedOff(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has primary color")
    public SwitchAssert primaryColor() {
        jdiAssert(element().hasPrimaryColor(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary color")
    public SwitchAssert secondaryColor() {
        jdiAssert(element().hasSecondaryColor(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary color")
    public SwitchAssert undefinedColor() {
        jdiAssert(element().hasUndefinedColor(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public SwitchAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public SwitchAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

}