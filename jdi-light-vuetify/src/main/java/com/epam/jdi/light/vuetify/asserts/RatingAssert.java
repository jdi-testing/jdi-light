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
    @JDIAction(value = "Assert that '{name}' value is '{0}'")
    public RatingAssert value(double rating) {
        double actualRating = element().getValue();
        jdiAssert(actualRating, Matchers.is(rating), String.format("Element's actual rating '%s' is not equal to " +
                "expected '%s'", actualRating, rating));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' value is '{0}'")
    public RatingAssert value(int rating) {
        double actualRating = element().getValue();
        jdiAssert(actualRating, Matchers.is((double) rating), String.format("Element's actual rating '%s' is not equal to " +
                "expected '%s'", actualRating, rating));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main color is {0}")
    public RatingAssert color(String color) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual color '%s' is not equal to " +
                "expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' main color of button index '{0}' is '{1}'")
    public RatingAssert color(int index, String color) {
        String actualColor = element().color(index);
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual color '%s' is not equal to " +
                "expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is '{0}'")
    public RatingAssert size(int size) {
        int actualSize = element().size();
        jdiAssert(actualSize, Matchers.is(size), String.format("Elements actual size '%s' is not equal to expected " +
                "'%s'", actualSize, size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' length is '{0}'")
    public RatingAssert length(int length) {
        int actualLength = element().length();
        jdiAssert(actualLength, Matchers.is(length), String.format("Element's actual length '%s' is not equal to " +
                "expected '%s'", actualLength, length));
        return this;
    }
}
