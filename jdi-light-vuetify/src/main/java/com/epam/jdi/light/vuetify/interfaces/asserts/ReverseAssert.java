package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ReverseAssert<A, E extends IsReverse> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is reversed")
    default A reversed() {
        jdiAssert(element().isReverse() ? "is reversed" : "is not reversed", Matchers.is("is reversed"));
        return (A) this;
    }
}
