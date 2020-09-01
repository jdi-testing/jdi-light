package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.android.ToggleButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToggleButtonAssert extends UIAssert<ToggleButtonAssert, ToggleButton> {
    @JDIAction("Assert that '{name}' is on")
    public ToggleButtonAssert on() {
        jdiAssert(getIsOn(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that '{name}' is off")
    public ToggleButtonAssert off() {
        jdiAssert(getIsOn(), Matchers.is("false"));
        return this;
    }


    protected String getIsOn() {
        return element().isOn() ? "true" : "false";
    }

}
