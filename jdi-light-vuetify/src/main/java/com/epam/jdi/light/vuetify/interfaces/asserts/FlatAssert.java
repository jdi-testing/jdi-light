package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface FlatAssert<A, E extends IsFlat> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is flat")
    default A flat() {
        jdiAssert(element().isFLat(), Matchers.is(true), "Element is not flat");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not flat")
    default A notFlat() {
        jdiAssert(element().isFLat(), Matchers.is(false), "Element is flat");
        return (A) this;
    }
}
