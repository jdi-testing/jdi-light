package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasDirection;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface DirectionAssert<A, E extends HasDirection> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is vertical")
    default A vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true),"Element is horizontal");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is horizontal")
    default A horizontal() {
        jdiAssert(element().isVertical(), Matchers.is(false), "Element is vertical");
        return (A) this;
    }
}
