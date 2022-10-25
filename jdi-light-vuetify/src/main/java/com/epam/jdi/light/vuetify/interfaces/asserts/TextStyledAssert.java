package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsTextStyled;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface TextStyledAssert<A, E extends IsTextStyled> extends VuetifyAssert<E> {

    @JDIAction("Assert that {name} is text styled")
    default A textStyled() {
        jdiAssert(element().isTextStyled() ? "is text styled" : "is no text styled", Matchers.is("is text styled"));
        return (A) this;
    }
}
