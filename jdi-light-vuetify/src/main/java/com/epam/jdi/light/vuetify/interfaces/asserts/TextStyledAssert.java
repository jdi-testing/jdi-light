package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsTextStyled;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface TextStyledAssert<A, E extends IsTextStyled> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is text")
    default A textStyled() {
        jdiAssert(element().isTextStyled(), Matchers.is(true), "Element is not text");
        return (A) this;
    }
}
