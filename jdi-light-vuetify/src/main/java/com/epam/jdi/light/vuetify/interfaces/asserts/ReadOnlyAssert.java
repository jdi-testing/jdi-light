package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ReadOnlyAssert<A, E extends IsReadOnly> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is readonly")
    default A readonly() {
        jdiAssert(element().isReadOnly() ? "is readonly" : "is not readonly", Matchers.is("is readonly"));
        return (A) this;
    }
}
