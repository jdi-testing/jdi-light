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
    @JDIAction("Assert that '{name}' size is '{0}'")
    public VuetifyListAssert size(int size) {
        int actualSize = element().size();
        jdiAssert(actualSize, Matchers.is(size), String.format("Actual element's sixe '%s' is not equal to expected " +
                "'%s'", actualSize, size));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public VuetifyListAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public VuetifyListAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }
}
