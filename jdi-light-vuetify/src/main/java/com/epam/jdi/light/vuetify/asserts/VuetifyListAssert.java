package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.VuetifyList;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyListAssert extends UISelectAssert<VuetifyListAssert, VuetifyList> {

    @JDIAction("Assert that item {0} of '{name}' is active")
    public VuetifyListAssert active(int itemIndex) {
        jdiAssert(element().isActive(itemIndex) ? "active" : "not active",
                Matchers.is("active"));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is not active")
    public VuetifyListAssert notActive(int itemIndex) {
        jdiAssert(element().isActive(itemIndex) ? "active" : "not active",
                Matchers.is("not active"));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is clickable")
    public VuetifyListAssert clickable(int itemIndex) {
        jdiAssert(element().get(itemIndex).isClickable() ? "clickable" : "not clickable",
                Matchers.is("clickable"));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is not clickable")
    public VuetifyListAssert notClickable(int itemIndex) {
        jdiAssert(element().get(itemIndex).isClickable() ? "clickable" : "not clickable",
                Matchers.is("not clickable"));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is displayed")
    public VuetifyListAssert displayed(int itemIndex) {
        jdiAssert(element().get(itemIndex).isDisplayed() ? "displayed" : "not displayed",
                Matchers.is("displayed"));
        return this;
    }

    @JDIAction("Assert that sublist of item {0} of '{name}' is hidden")
    public VuetifyListAssert sublistHidden(int itemIndex) {
        jdiAssert(element().subList(itemIndex).size(), Matchers.is(0));
        return this;
    }

    @JDIAction("Assert that sublist of item {0} of '{name}' is shown")
    public VuetifyListAssert sublistShown(int itemIndex) {
        jdiAssert(element().subList(itemIndex).size(), Matchers.greaterThan(0));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' has icon")
    public VuetifyListAssert icon(int itemIndex) {
        jdiAssert(element().hasIcon(itemIndex) ? "has icon" : "has no icon",
                Matchers.is("has icon"));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' has title {1}")
    public VuetifyListAssert title(int itemIndex, String expectedTitle) {
        jdiAssert(element().title(itemIndex), Matchers.is(expectedTitle));
        return this;
    }

}
