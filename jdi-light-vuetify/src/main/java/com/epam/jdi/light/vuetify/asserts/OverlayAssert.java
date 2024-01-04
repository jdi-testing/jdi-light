package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Overlay;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OverlayAssert extends UIAssert<OverlayAssert, Overlay> implements ColorAssert<OverlayAssert, Overlay>,
        ThemeAssert<OverlayAssert, Overlay> {

    @JDIAction(value = "Assert that '{name}' position is absolute", isAssert = true)
    public OverlayAssert absolutePosition() {
        jdiAssert(element().isAbsolute(), Matchers.is(true), "Overlay position is not absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' position is not absolute", isAssert = true)
    public OverlayAssert notAbsolutePosition() {
        jdiAssert(element().isAbsolute(), Matchers.is(false), "Overlay position is absolute");
        return this;
    }

    @JDIAction(value = "Check that '{name}' opacity is {0}", isAssert = true)
    public OverlayAssert opacity(double expectedOpacity) {
        jdiAssert(element().opacity(), Matchers.is(expectedOpacity));
        return this;
    }

    @JDIAction(value = "Check that '{name}' z-index is {0}", isAssert = true)
    public OverlayAssert zIndex(int expectedZIndex) {
        jdiAssert(element().zIndex(), Matchers.is(expectedZIndex));
        return this;
    }
}
