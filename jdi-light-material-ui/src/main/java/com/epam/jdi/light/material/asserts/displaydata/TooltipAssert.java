package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Tooltip;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Tooltip}
 */
public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> implements ITextAssert<TooltipAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public TooltipAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is visible")
    public TooltipAssert visible() {
        jdiAssert(element().isVisible() ? "is visible" : "is invisible", Matchers.is("is visible"));
        return this;
    }

    /**
     * Checks that tooltip is interactive.
     *
     * @return this {@link TooltipAssert} instance
     */
    @JDIAction("Assert that '{name}' is interactive")
    public TooltipAssert interactive() {
        jdiAssert(element().isInteractive() ? "is interactive" : "is not interactive", Matchers.is("is interactive"));
        return this;
    }
}
