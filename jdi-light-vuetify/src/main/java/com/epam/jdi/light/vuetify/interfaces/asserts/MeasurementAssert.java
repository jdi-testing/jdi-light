package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MeasurementAssert<A, E extends HasMeasurement> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' height is '{0}'")
    default A height(int height) {
        int actualHeight = element().height();
        jdiAssert(actualHeight, Matchers.is(height),
                String.format("Element has '%d' height, but expected '%d' height", actualHeight, height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    default A width(int width) {
        int actualWidth = element().width();
        jdiAssert(actualWidth, Matchers.is(width),
                String.format("Element has '%d' height, but expected '%d' height", actualWidth, width));
        return (A) this;
    }
}
