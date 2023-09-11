package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface FilledAssert<A, E extends IsFilled> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is filled")
    default A filled() {
        jdiAssert(element().isFilled(), Matchers.is(true), "Element is not filled");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not filled")
    default A notFilled() {
        jdiAssert(element().isFilled(), Matchers.is(false), "Element is filled");
        return (A) this;
    }
}
