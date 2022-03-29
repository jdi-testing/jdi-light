package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyListAssert extends UIAssert<VuetifyListAssert, VuetifyList> {

    @JDIAction("Assert that '{name}' item with title '{0}' is not displayed")
    public VuetifyListAssert itemNotDisplayed(String title) {
        jdiAssert(element().isItemDisplayed(title) ? "is item displayed" : "is item not displayed",
            Matchers.is("is item not displayed"));
        return this;
    }
}
