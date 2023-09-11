package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface SingleLineAssert<A, E extends IsSingleLine> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' is single line")
    default A singleLine() {
        jdiAssert(element().isSingleLine(), Matchers.is(true), "Element is not single line");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not single line")
    default A notSingleLine() {
        jdiAssert(element().isSingleLine(), Matchers.is(false), "Element is single line");
        return (A) this;
    }
}
