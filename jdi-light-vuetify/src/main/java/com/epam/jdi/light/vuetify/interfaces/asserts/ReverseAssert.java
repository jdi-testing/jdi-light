package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ReverseAssert<A, E extends IsReverse> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is reversed")
    default A reversed() {
        jdiAssert(element().isReverse(), Matchers.is(true), "Element is not reversed");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not reversed")
    default A notReversed() {
        jdiAssert(element().isReverse(), Matchers.is(false), "Element is reversed");
        return (A) this;
    }
}
