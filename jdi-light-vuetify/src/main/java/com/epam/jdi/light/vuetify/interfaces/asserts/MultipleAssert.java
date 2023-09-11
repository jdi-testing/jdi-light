package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsMultiple;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface MultipleAssert<A, E extends IsMultiple> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is multiple")
    default A multiple() {
        jdiAssert(element().isMultiple(), Matchers.is(true), "Element is not multiple");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not multiple")
    default A notMultiple() {
        jdiAssert(element().isMultiple(), Matchers.is(false), "Element is multiple");
        return (A) this;
    }
}
