package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Chip}
 */
public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    /**
     * Checks that chip is deletable.
     *
     * @return this {@link ChipAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is deletable", isAssert = true)
    public ChipAssert deletable() {
        jdiAssert(element().isDeletable(), Matchers.is(true), "Chip is not deletable");
        return this;
    }

    /**
     * Checks that chip is clickable.
     *
     * @return this {@link ChipAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is clickable", isAssert = true)
    public ChipAssert clickable() {
        jdiAssert(element().isClickable(), Matchers.is(true), "Chip is not clickable");
        return this;
    }

    /**
     * Checks that chip is a link.
     *
     * @return this {@link ChipAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is a link", isAssert = true)
    public ChipAssert link() {
        jdiAssert(element().hasLink(), Matchers.is(true), "Chip is not a link");
        return this;
    }

    /**
     * Checks that chip has given href.
     *
     * @param href expected href
     * @return this {@link ChipAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has href '{0}'", isAssert = true)
    public ChipAssert ref(String href) {
        jdiAssert(element().ref(), Matchers.is(href));
        return this;
    }
}
