package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsClearable;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ClearableAssert<A, E extends IsClearable> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is clearable")
    default A clearable() {
        jdiAssert(element().isClearable() ? "is clearable" : "is not clearable", Matchers.is("is clearable"));
        return (A) this;
    }
}
