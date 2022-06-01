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
     * Check that Divider is horizontal orientation
     */
    @JDIAction("Assert that '{name}' is horizontal orientation")
    public DividerAssert horizontal() {
        jdiAssert(element().isHorizontal() ? "is horizontal" : "is not horizontal", Matchers.is("is horizontal"));
        return this;
    }
}
