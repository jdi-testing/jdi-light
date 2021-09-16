package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DividerAssert extends UIAssert<DividerAssert, Divider> {

    @JDIAction("Assert that '{name}' is horizontal")
    public DividerAssert horizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is vertical")
    public DividerAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is light")
    public DividerAssert lightTheme() {
        jdiAssert(element().themeIsLight(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    public DividerAssert darkTheme() {
        jdiAssert(element().themeIsDark(), Matchers.is(true));
        return this;
    }
}
