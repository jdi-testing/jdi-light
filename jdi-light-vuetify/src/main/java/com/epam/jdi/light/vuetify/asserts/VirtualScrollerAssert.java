package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VirtualScroller;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;

public class VirtualScrollerAssert extends UIAssert<VirtualScrollerAssert, VirtualScroller>
        implements MeasurementAssert<VirtualScrollerAssert, VirtualScroller> {

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
    public VirtualScrollerAssert renderedItems(int expectedCount) {
        Timer.waitCondition(() -> !element().items().isEmpty());
        int actualRenderedItemsCount = element().items().size();
        jdiAssert(actualRenderedItemsCount, Matchers.is(expectedCount),
                String.format("Number of actual rendered items is '%d', but expected '%d'", actualRenderedItemsCount, expectedCount));
        return this;
    }

    @JDIAction("Assert that '{name}' items are exist")
    public VirtualScrollerAssert items() {
        Timer.waitCondition(()-> !element().items().isEmpty());
        jdiAssert(element().items(), Matchers.notNullValue());
        return this;
    }

    @JDIAction("Assert that '{name}' items has text {0}")
    public VirtualScrollerAssert text(String... expectedText) {
        Timer.waitCondition(()-> !element().items().isEmpty());
        List<String> actualItemsText = element().itemsText();
        jdiAssert(actualItemsText.containsAll(Arrays.asList(expectedText)), Matchers.is(true),
                String.format("Virtual scroller has '%s' items, but expected '%s'",
                        String.join(", ", actualItemsText), String.join(", ", expectedText)));
        return this;
    }
}
