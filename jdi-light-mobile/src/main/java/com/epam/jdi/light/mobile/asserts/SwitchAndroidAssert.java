package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.generic.ISwitchAssert;
import com.epam.jdi.light.mobile.elements.common.app.android.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAndroidAssert extends UIAssert<SwitchAndroidAssert, Switch> implements ISwitchAssert {

    @JDIAction("Assert that '{name}' is on")
    public SwitchAndroidAssert on() {
        jdiAssert(getIsOn(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that '{name}' is off")
    public SwitchAndroidAssert off() {
        jdiAssert(getIsOn(), Matchers.is("false"));
        return this;
    }


    protected String getIsOn() {
        return element().isOn() ? "true" : "false";
    }

}
