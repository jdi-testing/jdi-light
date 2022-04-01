package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popover;
import com.jdiai.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PopoverAssert extends UIAssert<PopoverAssert, Popover> implements ITextAssert<PopoverAssert> {

    // Used by other tests. Can be deleted in future
    @Override
    @JDIAction("Assert that '{name}' is visible")
    public PopoverAssert visible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isVisible ? "is visible" : "is invisible", Matchers.is("is visible"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public PopoverAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }
}
