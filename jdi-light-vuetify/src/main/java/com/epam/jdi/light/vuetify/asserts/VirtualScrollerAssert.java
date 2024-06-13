package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VirtualScroller;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class VirtualScrollerAssert extends UIAssert<VirtualScrollerAssert, VirtualScroller>
        implements MeasurementAssert<VirtualScrollerAssert, VirtualScroller> {

    @JDIAction(value = "Assert that number of rendered items of '{name}' are {0}", isAssert = true)
    public VirtualScrollerAssert itemsCount(int expectedCount) {
        jdiAssert(element().items().size(), Matchers.is(expectedCount));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' items match", isAssert = true)
    public VirtualScrollerAssert items(Matcher<Object> matcher) {
        jdiAssert(element().items(), matcher);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' items contains texts {0}", isAssert = true)
    public VirtualScrollerAssert itemsText(String... expectedText) {
        jdiAssert(element().itemsText(), Matchers.hasItems(expectedText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' items contains texts {0}", isAssert = true)
    public VirtualScrollerAssert itemsText(Matcher<Object> matcher) {
        jdiAssert(element().itemsText(), matcher);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} items height", isAssert = true)
    public VirtualScrollerAssert itemsHeight(int expectedItemsHeight) {
        jdiAssert(element().itemHeight(), Matchers.is(expectedItemsHeight));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} items height", isAssert = true)
    public VirtualScrollerAssert itemsHeight(Matcher<Integer> matcher) {
        jdiAssert(element().itemHeight(), matcher);
        return this;
    }
}
