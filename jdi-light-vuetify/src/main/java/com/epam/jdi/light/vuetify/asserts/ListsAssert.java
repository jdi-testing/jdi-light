package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Lists;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListsAssert extends UISelectAssert<ListsAssert, Lists> {

    @JDIAction("Assert that item {0} of '{name}' is active")
    public ListsAssert active(int itemIndex) {
        jdiAssert(element().isActive(itemIndex), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is not active")
    public ListsAssert notActive(int itemIndex) {
        jdiAssert(element().isActive(itemIndex), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is clickable")
    public ListsAssert clickable(int itemIndex) {
        jdiAssert(element().get(itemIndex).isClickable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is not clickable")
    public ListsAssert notClickable(int itemIndex) {
        jdiAssert(element().get(itemIndex).isClickable(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' is displayed")
    public ListsAssert displayed(int itemIndex) {
        jdiAssert(element().get(itemIndex).isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that sublist of item {0} of '{name}' is hidden")
    public ListsAssert sublistHidden(int itemIndex) {
        jdiAssert(element().subList(itemIndex).size(), Matchers.is(0));
        return this;
    }

    @JDIAction("Assert that sublist of item {0} of '{name}' is shown")
    public ListsAssert sublistShown(int itemIndex) {
        jdiAssert(element().subList(itemIndex).size(), Matchers.greaterThan(0));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' has icon")
    public ListsAssert icon(int itemIndex) {
        jdiAssert(element().hasIcon(itemIndex), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that item {0} of '{name}' has title {1}")
    public ListsAssert title(int itemIndex, String expectedTitle) {
        jdiAssert(element().hasTitle(itemIndex, expectedTitle), Matchers.is(true));
        return this;
    }

}
