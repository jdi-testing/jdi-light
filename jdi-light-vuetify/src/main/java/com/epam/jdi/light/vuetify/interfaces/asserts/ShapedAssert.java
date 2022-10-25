package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ShapedAssert<A, E extends IsShaped> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is shaped")
    default A shaped() {
        jdiAssert(element().isShaped() ? "shaped" : "not shaped", Matchers.is("shaped"));
        return (A) this;
    }
}
