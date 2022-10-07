package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Overlay;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OverlayAssert extends UIAssert<OverlayAssert, Overlay> {

    @JDIAction("Assert that '{name}' is active")
    public OverlayAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public OverlayAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is absolute")
    public OverlayAssert absolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not absolute")
    public OverlayAssert notAbsolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(false));
        return this;
    }

    @JDIAction("Check that '{name}' opacity is {0}")
    public OverlayAssert opacity(double opacity) {
        jdiAssert(element().opacity(), Matchers.is(opacity));
        return this;
    }

    @JDIAction("Check that '{name}' zIndex is {0}")
    public OverlayAssert zIndex(int zIndex) {
        jdiAssert(element().zIndex(), Matchers.is(zIndex));
        return this;
    }

    @JDIAction("Assert that '{name}' content is exist")
    public OverlayAssert contentExist() {
        jdiAssert(element().content(), Matchers.notNullValue());
        return this;
    }

    @JDIAction("Assert that '{name}' content is exist")
    public OverlayAssert contentNotExist() {
        jdiAssert(element().content(), Matchers.nullValue());
        return this;
    }

    @JDIAction("Assert that '{name}' has color {0}")
    public OverlayAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }
}
