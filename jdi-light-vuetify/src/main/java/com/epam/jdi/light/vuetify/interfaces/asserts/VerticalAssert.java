package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsVertical;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface VerticalAssert<A, E extends IsVertical> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is vertical")
    default A vertical() {
        jdiAssert(element().isVertical() ? "is vertical" : "is not vertical", Matchers.is("is vertical"));
        return (A) this;
    }
}
