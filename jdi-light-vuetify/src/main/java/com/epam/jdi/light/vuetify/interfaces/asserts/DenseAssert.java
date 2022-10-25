package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface DenseAssert<A, E extends IsDense> extends VuetifyAssert<E> {

    @JDIAction("Assert that {name} is dense")
    default A dense() {
        jdiAssert(element().isDense() ? "is dense" : "is not dense", Matchers.is("is dense"));
        return (A) this;
    }
}
