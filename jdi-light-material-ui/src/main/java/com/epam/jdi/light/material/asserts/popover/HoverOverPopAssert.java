package com.epam.jdi.light.material.asserts.popover;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.popover.HoverOverPop;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class HoverOverPopAssert extends UIAssert<HoverOverPopAssert, HoverOverPop> {

    @JDIAction("Assert that '{name}' is displayed")
    public HoverOverPopAssert hoverOverIsOpened() {
        jdiAssert(element().isPopUpWindowOpened(), Matchers.is(true));
        return this;
    }
}
