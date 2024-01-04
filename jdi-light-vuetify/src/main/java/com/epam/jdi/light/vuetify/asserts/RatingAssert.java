package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Rating;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RatingAssert extends UIAssert<RatingAssert, Rating> implements ReadOnlyAssert<RatingAssert, Rating>,
        ColorAssert<RatingAssert, Rating>, DenseAssert<RatingAssert, Rating>, ThemeAssert<RatingAssert, Rating> {
    @JDIAction(value = "Assert that '{name}' value is '{0}'", isAssert = true)
    public RatingAssert value(double rating) {
        jdiAssert(element().getValue(), Matchers.is(rating),);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' value is '{0}'", isAssert = true)
    public RatingAssert value(int rating) {
        double actualRating = element().getValue();
        jdiAssert(element().getValue(), Matchers.is((double) rating));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main color is {0}", isAssert = true)
    public RatingAssert color(String color) {
        jdiAssert(element().color(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main color of button index '{0}' is '{1}'", isAssert = true)
    public RatingAssert color(int index, String color) {
        jdiAssert(element().color(index), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is '{0}'", isAssert = true)
    public RatingAssert size(int size) {
        jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' length is '{0}'", isAssert = true)
    public RatingAssert length(int length) {
        int actualLength = element().length();
        jdiAssert(element().length(), Matchers.is(length));
        return this;
    }
}
