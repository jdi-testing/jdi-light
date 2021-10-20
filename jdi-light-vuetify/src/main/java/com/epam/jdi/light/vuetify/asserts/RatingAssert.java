package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Rating;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RatingAssert extends UIAssert<RatingAssert, Rating> {

    @JDIAction("Assert that value of '{name}' is {0}")
    public RatingAssert value(double rating) {
        jdiAssert(element().getValue(), Matchers.is(rating));
        return this;
    }

    @JDIAction("Assert that value of '{name}' is {0}")
    public RatingAssert value(int rating) {
        jdiAssert(element().getValue(), Matchers.is((double) rating));
        return this;
    }

    @JDIAction("Assert that main color of '{name}' is {0}")
    public RatingAssert color(String color) {
        jdiAssert(element().color(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that main color of '{name}' button index {0} is {1}")
    public RatingAssert color(int index, String color) {
        jdiAssert(element().color(index), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that size of '{name}' is {0}")
    public RatingAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    @JDIAction("Assert that length of '{name}' is {0}")
    public RatingAssert length(int length) {
        jdiAssert(element().length(), Matchers.is(length));
        return this;
    }

    @JDIAction("Assert that '{name}' is readonly")
    public RatingAssert readonly() {
        jdiAssert(element().hasClass("v-rating--readonly"), Matchers.is(true));
        return this;
    }
}
