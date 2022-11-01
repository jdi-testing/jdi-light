package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface LoadingAssert<A, E extends IsLoading> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is loading")
    default A loading() {
        jdiAssert(element().isLoading(), Matchers.is(true), "Element is not loading now");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has been loaded")
    default A loaded() {
        Timer.waitCondition(() -> !element().isLoading());
        jdiAssert(element().isLoading(), Matchers.is(false), "Element is loading now");
        return (A) this;
    }
}
