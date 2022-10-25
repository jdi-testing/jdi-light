package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface FlatAssert<A, E extends IsFlat> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is flat")
    default A flat() {
        jdiAssert(element().isFLat() ? "is flat" : "is not flat", Matchers.is("is flat"));
        return (A) this;
    }
}
