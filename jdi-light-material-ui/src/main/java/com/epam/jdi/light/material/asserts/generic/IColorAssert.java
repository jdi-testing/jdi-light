package com.epam.jdi.light.material.asserts.generic;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Represents an assertion that checks element color.
 */
public interface IColorAssert<A extends UIAssert<?, ?>> {

    /**
     * Checks that element has given color.
     *
     * @param color expected color
     * @return this {@link IColorAssert} instance
     */
    @JDIAction("Assert that '{name}' color is '{0}'")
    default A color(String color) {
        return color(Matchers.is(color));
    }

    /**
     * Checks that element color meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link IColorAssert} instance
     */
    @JDIAction("Assert that '{name}' color {0}")
    A color(Matcher<String> condition);
}
