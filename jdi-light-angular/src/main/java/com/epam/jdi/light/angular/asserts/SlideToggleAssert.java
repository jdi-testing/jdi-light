package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.SlideToggle;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class SlideToggleAssert extends UIAssert<SlideToggleAssert, SlideToggle> {

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SlideToggleAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SlideToggleAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }
}
