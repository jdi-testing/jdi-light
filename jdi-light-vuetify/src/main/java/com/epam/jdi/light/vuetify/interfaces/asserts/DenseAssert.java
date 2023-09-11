package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface DenseAssert<A, E extends IsDense> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is dense")
    default A dense() {
        jdiAssert(element().isDense(), Matchers.is(true), "Element is not dense");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not dense")
    default A notDense() {
        jdiAssert(element().isDense(), Matchers.is(false), "Element is dense");
        return (A) this;
    }
}
