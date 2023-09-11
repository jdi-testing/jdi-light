package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MeasurementAssert<A, E extends HasMeasurement> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' height is '{0}'")
    default A height(int height) {
        int actualHeight = element().height();
        jdiAssert(actualHeight, Matchers.is(height),
                String.format("Element has '%d' height, but expected '%d' height", actualHeight, height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' height is less than '{0}'")
    default A heightLessThan(int height) {
        int actualHeight = element().height();
        jdiAssert(actualHeight, Matchers.lessThan(height),
                String.format("Element has '%d' height, but expected that height is less than '%d'", actualHeight, height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' height is greater than '{0}'")
    default A heightGreaterThan(int height) {
        int actualHeight = element().height();
        jdiAssert(actualHeight, Matchers.greaterThan(height),
                String.format("Element has '%d' height, but expected that height is greater than '%d'", actualHeight, height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    default A width(int width) {
        int actualWidth = element().width();
        jdiAssert(actualWidth, Matchers.is(width),
                String.format("Element has '%d' width, but expected '%d' width", actualWidth, width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is less than '{0}'")
    default A widthLessThan(int width) {
        int actualWidth = element().width();
        jdiAssert(actualWidth, Matchers.lessThan(width),
                String.format("Element has '%d' width, but expected that width is less than '%d'", actualWidth, width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is greater than '{0}'")
    default A widthGreaterThan(int width) {
        int actualWidth = element().width();
        jdiAssert(actualWidth, Matchers.greaterThan(width),
                String.format("Element has '%d' width, but expected that width is greater than '%d'", actualWidth, width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' max height is '{0}'")
    default A maxHeight(int height) {
        int actualHeight = element().maxHeight();
        jdiAssert(actualHeight, Matchers.equalTo(height), String.format("Actual element's max height '%s px' is not " +
                "equal to expected '%s px'", actualHeight, height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' max width is '{0}'")
    default A maxWidth(int width) {
        int actualWidth = element().maxWidth();
        jdiAssert(actualWidth, Matchers.equalTo(width), String.format("Actual element's max width '%s px' is not " +
                "equal to expected '%s px'", actualWidth, width));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' min height is '{0}'")
    default A minHeight(int height) {
        int actualHeight = element().minHeight();
        jdiAssert(actualHeight, Matchers.equalTo(height), String.format("Actual element's min height '%s px' is not " +
                "equal to expected '%s px'", actualHeight, height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' min width is '{0}'")
    default A minWidth(int width) {
        int actualWidth = element().minWidth();
        jdiAssert(actualWidth, Matchers.equalTo(width), String.format("Actual element's min width '%s px' is not " +
                "equal to expected '%s px'", actualWidth, width));
        return (A) this;
    }
}
