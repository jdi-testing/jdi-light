package com.epam.jdi.light.material.asserts.popover;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.popover.PopOver;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PopOverAssert extends UIAssert<PopOverAssert, PopOver> {

    @JDIAction("Assert that '{name}' is opened")
    public PopOverAssert isOpened() {
        jdiAssert(element().isPopUpDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' enabled")
    public PopOverAssert isEnabled() {
        jdiAssert(element().isPopUpEnabled(), Matchers.is(true));
        return this;
    }
}
