package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Overlay;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OverlayAssert extends UIAssert<OverlayAssert, Overlay> implements ColorAssert<OverlayAssert, Overlay>,
        ThemeAssert<OverlayAssert, Overlay> {

    @JDIAction("Assert that '{name}' position is absolute")
    public OverlayAssert absolutePosition() {
        jdiAssert(element().isAbsolute(), Matchers.is(true), "Overlay position is not absolute");
        return this;
    }

    @JDIAction("Assert that '{name}' position is not absolute")
    public OverlayAssert notAbsolutePosition() {
        jdiAssert(element().isAbsolute(), Matchers.is(false), "Overlay position is absolute");
        return this;
    }

    @JDIAction("Check that '{name}' opacity is {0}")
    public OverlayAssert opacity(double expectedOpacity) {
        double actualOpacity = element().opacity();
        jdiAssert(actualOpacity, Matchers.is(expectedOpacity),
                String.format("Actual overlay opacity is '%f', but expected '%f'", actualOpacity, expectedOpacity));
        return this;
    }

    @JDIAction("Check that '{name}' z-index is {0}")
    public OverlayAssert zIndex(int expectedZIndex) {
        int actualZIndex = element().zIndex();
        jdiAssert(actualZIndex, Matchers.is(expectedZIndex),
                String.format("Actual overlay z-index is '%d', but expected '%d'", actualZIndex, expectedZIndex));
        return this;
    }
}
