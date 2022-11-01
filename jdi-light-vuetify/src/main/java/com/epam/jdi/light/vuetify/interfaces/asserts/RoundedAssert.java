package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsRounded;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface RoundedAssert<A, E extends IsRounded> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is rounded")
    default A rounded() {
        jdiAssert(element().isRounded(), Matchers.is(true), "Element is not rounded");
        return (A) this;
    }
}
