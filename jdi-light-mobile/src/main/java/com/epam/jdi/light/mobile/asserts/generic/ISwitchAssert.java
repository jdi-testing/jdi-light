package com.epam.jdi.light.mobile.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.asserts.SwitchAssert;

public interface ISwitchAssert<A> {
    @JDIAction("Assert that '{name}' is on")
    A on();

    @JDIAction("Assert that '{name}' is off")
    A off();

}
