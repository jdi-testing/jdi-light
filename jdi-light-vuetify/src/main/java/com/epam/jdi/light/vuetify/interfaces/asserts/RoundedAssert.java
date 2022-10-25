package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsRounded;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface RoundedAssert<A, E extends IsRounded> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is rounded")
    default A rounded() {
        jdiAssert(element().isRounded() ? "is rounded" : "is not rounded",
                Matchers.is("is rounded"));
        return (A) this;
    }
}
