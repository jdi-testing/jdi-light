package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsFullWidth;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface FullWidthAssert<A, E extends IsFullWidth> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is full-width")
    default A fullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(true), "Element is not full-width");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not full-width")
    default A notFullWidth() {
        jdiAssert(element().isFullWidth(), Matchers.is(false), "Element is full-width");
        return (A) this;
    }


}
