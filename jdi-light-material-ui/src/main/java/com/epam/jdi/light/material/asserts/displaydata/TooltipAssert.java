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

    /**
     * Checks that tooltip is interactive.
     *
     * @return this {@link TooltipAssert} instance
     */
    @JDIAction("Assert that '{name}' is interactive")
    public TooltipAssert interactive() {
        jdiAssert(element().isInteractive(), Matchers.is(true), "Tooltip is not interactive");
        return this;
    }

    @JDIAction("Assert that '{name}' is not interactive")
    public TooltipAssert notInteractive() {
        jdiAssert(element().isInteractive(), Matchers.is(false), "Tooltip is interactive");
        return this;
    }
}
