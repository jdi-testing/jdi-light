package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MeasurementAssert<A, E extends HasMeasurement> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' height is '{0}'")
    default A height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    default A width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return (A) this;
    }
}
