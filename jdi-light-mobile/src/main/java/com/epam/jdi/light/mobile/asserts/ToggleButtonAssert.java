package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.android.ToggleButton;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToggleButtonAssert extends UIAssert<ToggleButtonAssert, ToggleButton> implements ITextAssert<ToggleButtonAssert> {
    @JDIAction("Assert that '{name}' is on")
    public ToggleButtonAssert on() {
        jdiAssert(getState(), Matchers.is("on"));
        return this;
    }

    @JDIAction("Assert that '{name}' is off")
    public ToggleButtonAssert off() {
        jdiAssert(getState(), Matchers.is("off"));
        return this;
    }


    protected String getState() {
        return element().isOn() ? "on" : "off";
    }

    @JDIAction("Assert that '{name}' text {0}")
    public ToggleButtonAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    public ToggleButtonAssert text(String text) { return text(Matchers.is(text)); }

}
