package com.epam.jdi.light.material.asserts.layouts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layouts.Box;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BoxAssert  extends UIAssert<BoxAssert, Box> {
    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public BoxAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public BoxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public BoxAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }
}
