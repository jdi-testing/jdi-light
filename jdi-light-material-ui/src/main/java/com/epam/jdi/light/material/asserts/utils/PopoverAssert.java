package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popover;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PopoverAssert extends UIAssert<PopoverAssert, Popover> {

    // Used by other tests. Can be deleted in future
    @JDIAction("Assert that '{name}' is visible")
    public PopoverAssert visible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has text {0}")
    public PopoverAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }
}
