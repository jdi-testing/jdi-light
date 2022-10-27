package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsMultiple;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MultipleAssert<A, E extends IsMultiple> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is multiple")
    default A multiple() {
        jdiAssert(element().isMultiple() ? "is multiple" : "is not multiple", Matchers.is("is multiple"));
        return (A) this;
    }
}
