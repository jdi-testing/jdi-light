package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Tabs}
 */
public class TabsAssert extends UISelectAssert<TabsAssert, Tabs> {

    /**
     * Checks that switch is disabled.
     *
     * @return this {@link TabsAssert} instance
     */
    @JDIAction("Assert that {0} tab in '{name}' is disabled")
    public TabsAssert disabled(int index) {
        jdiAssert(element().disabled(index) ? "disabled" : "not disabled", Matchers.is("disabled"));
        return this;
    }

    /**
     * Checks that switch is enabled.
     *
     * @return this {@link TabsAssert} instance
     */
    @JDIAction("Assert that {0} tab in '{name}' is enabled")
    public TabsAssert enabled(int index) {
        jdiAssert(element().enabled(index) ? "enabled" : "not enabled", Matchers.is("enabled"));
        return this;
    }
}
