package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface OrientationAssert<A, E extends HasOrientation> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is vertical")
    default A vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Element is horizontal");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is horizontal")
    default A horizontal() {
        jdiAssert(element().isVertical(), Matchers.is(false), "Element is vertical");
        return (A) this;
    }
}
