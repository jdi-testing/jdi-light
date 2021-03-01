package com.epam.jdi.light.material.asserts.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import org.hamcrest.Matchers;

public class DividerAssert extends UIAssert<DividerAssert, Divider> {

    @JDIAction("Assert that '{name}' is inset")
    public DividerAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is vertical")
    public DividerAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }

}
