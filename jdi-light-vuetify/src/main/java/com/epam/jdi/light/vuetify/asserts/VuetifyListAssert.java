package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyListAssert extends UIAssert<VuetifyListAssert, VuetifyList> {

    @JDIAction("Assert that '{name}' size is '{0}'")
    public VuetifyListAssert size(int value) {
        jdiAssert(element().size(), Matchers.is(value));
        return this;
    }
}
