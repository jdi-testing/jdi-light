package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasLoading;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface LoadingAssert<A, E extends HasLoading> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' has loading")
    default A loading() {
        jdiAssert(element().hasLoading() ? "has loading" : "has no loading", Matchers.is("has loading"));
        return (A) this;
    }
}
