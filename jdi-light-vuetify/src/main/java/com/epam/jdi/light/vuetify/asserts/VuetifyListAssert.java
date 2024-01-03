package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link VuetifyList}
 */
public class VuetifyListAssert extends UIAssert<VuetifyListAssert, VuetifyList> implements
        ThemeAssert<VuetifyListAssert, VuetifyList>, ElevationAssert<VuetifyListAssert, VuetifyList>,
        DenseAssert<VuetifyListAssert, VuetifyList>, FlatAssert<VuetifyListAssert, VuetifyList>,
        RoundedAssert<VuetifyListAssert, VuetifyList>, ShapedAssert<VuetifyListAssert, VuetifyList> {

    /**
     * Checks that the list has given size.
     *
     * @param size expected size
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' size is '{0}'", isAssert = true)
    public VuetifyListAssert size(int size) {
        int actualSize = element().size();
        jdiAssert(actualSize, Matchers.is(size), String.format("Actual element's sixe '%s' is not equal to expected " +
                "'%s'", actualSize, size));
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public VuetifyListAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    public VuetifyListAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    /**
     * Checks that the group list has specified size.
     *
     * @param groupSize expected group size
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' groups count is {0}", isAssert = true)
    public VuetifyListAssert groupSize(int groupSize) {
        jdiAssert(element().groups().size(), Matchers.is(groupSize));
        return this;
    }

    /**
     * Checks that the dividers list has specified size.
     *
     * @param divSize expected dividers count
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' dividers count is {0}", isAssert = true)
    public VuetifyListAssert dividersSize(int divSize) {
        jdiAssert(element().dividers().size(), Matchers.is(divSize));
        return this;
    }
}
