package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.generic.ISwitchAssert;
import com.epam.jdi.light.mobile.elements.common.app.ISwitch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, ISwitch> implements ISwitchAssert{

    @JDIAction("Assert that '{name}' is on")
    public SwitchAssert on() {
        jdiAssert(getState(), Matchers.is("on"));
        return this;
    }

    @JDIAction("Assert that '{name}' is off")
    public SwitchAssert off() {
        jdiAssert(getState(), Matchers.is("off"));
        return this;
    }


    protected String getState() {
        return element().isOn() ? "on" : "off";
    }


}
