package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Divider;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Divider}
 */
public class DividerAssert extends UIAssert<DividerAssert, Divider> {

    /**
     * Check that {@link Divider} is horizontal orientation
     *
     * @return this {@link DividerAssert} instance
     */
    @JDIAction("Assert that '{name}' is horizontal orientation")
    public DividerAssert horizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(true), "Default divider is not horizontal");
        return this;
    }

    /**
     * Check that {@link Divider} is vertical orientation
     *
     * @return this {@link DividerAssert} instance
     */
    @JDIAction("Assert that '{name}' is vertical orientation")
    public DividerAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Vertical divider is not vertical");
        return this;
    }

    /**
     * Check that {@link Divider} has inset
     *
     * @return this {@link DividerAssert} instance
     */
    @JDIAction("Assert that '{name}' has inset")
    public DividerAssert inset() {
        jdiAssert(element().hasInset(), Matchers.is(true), "Inset divider doesn't have inset");
        return this;
    }
}
