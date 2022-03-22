package com.epam.jdi.light.material.asserts.utils;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popover;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

public class PopoverAssert extends UIAssert<PopoverAssert, Popover> {

    // Used by other tests. Can be deleted in future
    @Override
    @JDIAction("Assert that '{name}' is visible")
    public PopoverAssert visible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isVisible ? "is visible" : "is invisible", Matchers.is("is visible"));
        return this;
    }

    @JDIAction("Assert that '{name}' has text '{0}'")
    public PopoverAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }
}
