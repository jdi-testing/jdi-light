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
        jdiAssert(element().isHorizontal(), Matchers.is(true), "Default divider separator is not horizontal");
        return this;
    }

    /**
     * Check that {@link DividerSeparator} is vertical orientation
     *
     * @return this {@link DividerSeparatorAssert} instance
     */
    @JDIAction("Assert that '{name}' is vertical orientation")
    public DividerSeparatorAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Vertical divider separator is not vertical");
        return this;
    }

    /**
     * Check that {@link DividerSeparator} has inset
     *
     * @return this {@link DividerSeparatorAssert} instance
     */
    @JDIAction("Assert that '{name}' has inset")
    public DividerSeparatorAssert inset() {
        jdiAssert(element().hasInset(), Matchers.is(true), "Inset divider separator doesn't have inset");
        return this;
    }
}
