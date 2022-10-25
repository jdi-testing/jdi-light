package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface FilledAssert<A, E extends IsFilled> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is filled")
    default A filled() {
        jdiAssert(element().isFilled() ? "is filled" : "is not filled", Matchers.is("is filled"));
        return (A) this;
    }
}
