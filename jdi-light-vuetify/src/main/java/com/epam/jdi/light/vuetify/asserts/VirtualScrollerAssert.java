package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VirtualScroller;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VirtualScrollerAssert extends UIAssert<VirtualScrollerAssert, VirtualScroller> {

    @JDIAction("Assert that '{name}' position is {0}")
    public VirtualScrollerAssert position(int scrolledPixels) {
        jdiAssert(element().position(), Matchers.is(scrolledPixels));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public VirtualScrollerAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that number of rendered items of '{name}' are {0}")
    public VirtualScrollerAssert renderedItems(int number) {
        Timer.waitCondition(element().getItems()::isExist);
        jdiAssert(element().getItems().size(), Matchers.is(number));
        return this;
    }

    @JDIAction("Assert that '{name}' has items")
    public VirtualScrollerAssert items() {
        Timer.waitCondition(element().getItems()::isExist);
        return this;
    }


}
