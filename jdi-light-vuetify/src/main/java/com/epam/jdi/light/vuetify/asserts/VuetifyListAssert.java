package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link VuetifyList}
 */
public class VuetifyListAssert extends UIAssert<VuetifyListAssert, VuetifyList> {

    /**
     * Checks that the list has given size.
     *
     * @param amount expected size
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' size is '{0}'")
    public VuetifyListAssert size(int amount) {
        jdiAssert(element().size(), Matchers.is(amount));
        return this;
    }
}
