package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ReadOnlyAssert<A, E extends IsReadOnly> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is readonly")
    default A readonly() {
        jdiAssert(element().isReadOnly(), Matchers.is(true), "Element is not readonly");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not readonly")
    default A notReadonly() {
        jdiAssert(element().isReadOnly(), Matchers.is(false), "Element is readonly");
        return (A) this;
    }
}
