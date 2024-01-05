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
    @JDIAction(value = "Assert that '{name}' is inset", isAssert = true)
    public DividerAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Divider is not inset");
        return this;
    }

    /**
     * Checks that divider is vertical.
     *
     * @return this {@link Divider} instance
     */
    @JDIAction(value = "Assert that '{name}' is vertical", isAssert = true)
    public DividerAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Divider is not vertical");
        return this;
    }
}
