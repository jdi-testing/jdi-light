package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popover;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PopoverAssert extends UIAssert<PopoverAssert, Popover> {

    @JDIAction("Assert that '{name}' is visible")
    public PopoverAssert visible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is invisible")
    public PopoverAssert invisible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> !element().isDisplayed());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text equals '{0}'")
    public PopoverAssert textEquals(final String expectedText) {
        jdiAssert(element().getText().equals(expectedText), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text equals '{0}' (ignore case)")
    public PopoverAssert textEqualsIgnoreCase(final String expectedText) {
        jdiAssert(element().getText().equalsIgnoreCase(expectedText), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text contains '{0}'")
    public PopoverAssert textContains(final String expectedSubstring) {
        jdiAssert(element().getText().contains(expectedSubstring), Matchers.is(true));
        return this;
    }
}
