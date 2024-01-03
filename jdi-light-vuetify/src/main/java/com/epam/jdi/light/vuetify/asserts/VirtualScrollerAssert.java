package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VirtualScroller;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;

public class VirtualScrollerAssert extends UIAssert<VirtualScrollerAssert, VirtualScroller>
        implements MeasurementAssert<VirtualScrollerAssert, VirtualScroller> {

    @JDIAction(value = "Assert that number of rendered items of '{name}' are {0}", isAssert = true)
    public VirtualScrollerAssert itemsCount(int expectedCount) {
        Timer.waitCondition(() -> !element().items().isEmpty());
        int actualCount = element().items().size();
        jdiAssert(actualCount, Matchers.is(expectedCount),
                String.format("Number of actual rendered items is '%d', but expected '%d'", actualCount, expectedCount));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' items are exist", isAssert = true)
    public VirtualScrollerAssert items() {
        Timer.waitCondition(()-> !element().items().isEmpty());
        jdiAssert(element().items(), Matchers.notNullValue());
        return this;
    }

    @JDIAction(value = "Assert that '{name}' items has text {0}", isAssert = true)
    public VirtualScrollerAssert text(String... expectedText) {
        Timer.waitCondition(()-> !element().items().isEmpty());
        List<String> actualItemsText = element().itemsText();
        jdiAssert(actualItemsText.containsAll(Arrays.asList(expectedText)), Matchers.is(true),
                String.format("Virtual scroller has '%s' items, but expected '%s'",
                        String.join(", ", actualItemsText), String.join(", ", expectedText)));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} items height", isAssert = true)
    public VirtualScrollerAssert itemsHeight(int expectedItemsHeight) {
        int actualItemsHeight = element().itemHeight();
        jdiAssert(actualItemsHeight, Matchers.is(expectedItemsHeight),
                String.format("Actual item height is '%d', but expected '%d'", actualItemsHeight, expectedItemsHeight));
        return this;
    }
}
