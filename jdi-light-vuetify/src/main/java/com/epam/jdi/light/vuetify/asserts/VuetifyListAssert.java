package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyListAssert extends UIAssert<VuetifyListAssert, VuetifyList> {

    @JDIAction("Assert that '{name}' is two-line")
    public VuetifyListAssert twoLine() {
        jdiAssert(element().isTwoLine() ? "is two-line" : "is not two-line",
            Matchers.is("is two-line"));
        return this;
    }

    @JDIAction("Assert that '{name}' is three-line")
    public VuetifyListAssert threeLine() {
        jdiAssert(element().isThreeLine() ? "is three-line" : "is not three-line",
            Matchers.is("is three-line"));
        return this;
    }

    @JDIAction("Assert that '{name}' item with title '{0}' is not displayed")
    public VuetifyListAssert itemNotDisplayed(String title) {
        jdiAssert(element().isItemDisplayed(title) ? "is item displayed" : "is item not displayed",
            Matchers.is("is item not displayed"));
        return this;
    }
}