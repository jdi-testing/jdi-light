package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Tabs}.
 */
public class TabsAssert extends UISelectAssert<TabsAssert, Tabs> {

    /**
     * Checks that tab with given index is disabled.
     *
     * @param index tab's index
     * @return this {@link TabsAssert} instance
     */
    @JDIAction("Assert that {0} tab in '{name}' is disabled")
    public TabsAssert disabled(int index) {
        jdiAssert(element().disabled(index), Matchers.is(true),
                String.format("Tab %d is not disabled", index));
        return this;
    }

    /**
     * Checks that tab with given index is enabled.
     *
     * @param index tab's index
     * @return this {@link TabsAssert} instance
     */
    @JDIAction("Assert that {0} tab in '{name}' is enabled")
    public TabsAssert enabled(int index) {
        jdiAssert(element().enabled(index), Matchers.is(true),
                String.format("Tab %d is not enabled", index));
        return this;
    }
}
