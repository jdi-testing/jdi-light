package com.epam.jdi.light.material.asserts.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link Divider}.
 */
public class DividerAssert extends UIAssert<DividerAssert, Divider> {

    /**
     * Checks that divider is inset.
     *
     * @return this {@link DividerAssert} instance
     */
    @JDIAction("Assert that '{name}' is inset")
    public DividerAssert inset() {
        jdiAssert(element().isInset() ? "inset" : "not inset", Matchers.is("inset"));
        return this;
    }

    /**
     * Checks that divider is vertical.
     *
     * @return this {@link Divider} instance
     */
    @JDIAction("Assert that '{name}' is vertical")
    public DividerAssert vertical() {
        jdiAssert(element().isVertical() ? "vertical" : "not vertical", Matchers.is("vertical"));
        return this;
    }
}
