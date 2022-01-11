package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VirtualScroller;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class VirtualScrollerAssert extends UIAssert<VirtualScrollerAssert, VirtualScroller> {

    @JDIAction("Assert that '{name}' position is between {0} and {1}")
    public VirtualScrollerAssert positionBetween(int lowerValue, int upperValue) {
        position(Matchers.greaterThan(lowerValue))
                .and().position(Matchers.lessThanOrEqualTo(upperValue));
        return this;
    }

    @JDIAction("Assert that '{name}' position is {0}")
    public VirtualScrollerAssert position(Matcher<Integer> condition) {
        jdiAssert(element().position(), condition);
        return this;
    }

    @JDIAction("Assert that number of rendered items of '{name}' are {0}")
    public VirtualScrollerAssert renderedItems(int number) {
        Timer.waitCondition(element().items()::isExist);
        jdiAssert(element().items().size(), Matchers.is(number));
        return this;
    }

    @JDIAction("Assert that '{name}' items are exist")
    public VirtualScrollerAssert items() {
        Timer.waitCondition(element().items()::isExist);
        jdiAssert(element().items(), Matchers.notNullValue());
        return this;
    }
}
