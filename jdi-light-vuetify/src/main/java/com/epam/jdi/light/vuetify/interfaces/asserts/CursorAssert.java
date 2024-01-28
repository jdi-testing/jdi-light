package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasCursor;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface CursorAssert<A, E extends HasCursor> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' cursor has type '{0}'")
    default A cursorType(String cursorType) {
        jdiAssert(element().getCursorType(), Matchers.equalTo(cursorType));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' cursor has type progress")
    default A cursorTypeProgress() {
        cursorType("progress");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' cursor has type auto")
    default A cursorTypeAuto() {
        cursorType("auto");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' cursor has type pointer")
    default A cursorTypePointer() {
        cursorType("pointer");
        return (A) this;
    }
}
