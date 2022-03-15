package com.epam.jdi.light.material.asserts.generic;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public interface IColorAssert<A extends UIAssert<?, ?>> {

    @JDIAction("Assert that '{name}' color is '{0}'")
    default A color(String color) {
        return color(Matchers.is(color));
    }

    @JDIAction("Assert that '{name}' color {0}")
    A color(Matcher<String> condition);
}
