package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasAlignment;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface AlignmentAssert<A, E extends HasAlignment> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' has left alignment")
    default A leftAlignment() {
        jdiAssert(element().hasLeftAlignment(), Matchers.is(true), "Element has right alignment");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has right alignment")
    default A rightAlignment() {
        jdiAssert(element().hasRightAlignment(), Matchers.is(true), "Element has left alignment");
        return (A) this;
    }
}
