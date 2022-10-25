package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface SingleLineAssert<A, E extends IsSingleLine> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is single line")
    default A singleLine() {
        jdiAssert(element().isSingleLine() ? "is single line" : "is not single line", Matchers.is("is single line"));
        return (A) this;
    }
}
