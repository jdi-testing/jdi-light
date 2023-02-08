package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyListGroup;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyListGroupAssert extends UIAssert<VuetifyListGroupAssert, VuetifyListGroup> {

    /**
     * Checks that the list item is expanded.
     *
     * @return this {@link VuetifyListGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' is expanded")
    public VuetifyListGroupAssert expanded() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is collapsed");
        return this;
    }

    /**
     * Checks that the list item is collapsed.
     *;
     * @return this {@link VuetifyListGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' is collapsed")
    public VuetifyListGroupAssert collapsed() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is expanded");
        return this;
    }

    /**
     * Checks that the list item is active.
     *
     * @return this {@link VuetifyListGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' is active")
    public VuetifyListGroupAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is not active");
        return this;
    }

    /**
     * Checks that the list item is not active.
     *
     * @return this {@link VuetifyListGroupAssert} instance
     */
    @JDIAction("Assert that '{name}' is not active")
    public VuetifyListGroupAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is active");
        return this;
    }
}
