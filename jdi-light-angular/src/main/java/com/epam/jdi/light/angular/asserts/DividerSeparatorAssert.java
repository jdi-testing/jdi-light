package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.DividerSeparator;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link DividerSeparator}
 */
public class DividerSeparatorAssert extends UIAssert<DividerSeparatorAssert, DividerSeparator> {

    /**
     * Check that {@link DividerSeparator} is horizontal orientation
     *
     * @return this {@link DividerSeparatorAssert} instance
     */
    @JDIAction("Assert that '{name}' is horizontal orientation")
    public DividerSeparatorAssert horizontal() {
        jdiAssert(element().isHorizontal() ? "is horizontal" : "is not horizontal", Matchers.is("is horizontal"));
        return this;
    }

    /**
     * Check that {@link DividerSeparator} is vertical orientation
     *
     * @return this {@link DividerSeparatorAssert} instance
     */
    @JDIAction("Assert that '{name}' is vertical orientation")
    public DividerSeparatorAssert vertical() {
        jdiAssert(element().isVertical() ? "is vertical" : "is not vertical", Matchers.is("is vertical"));
        return this;
    }

    /**
     * Check that {@link DividerSeparator} has inset
     *
     * @return this {@link DividerSeparatorAssert} instance
     */
    @JDIAction("Assert that '{name}' has inset")
    public DividerSeparatorAssert inset() {
        jdiAssert(element().hasInset() ? "has inset" : "has no inset", Matchers.is("has inset"));
        return this;
    }
}
