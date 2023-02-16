package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasStyledText;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface TextStyledAssert<A, E extends HasStyledText> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' has styled text")
    default A styledText() {
        jdiAssert(element().hasStyledText(), Matchers.is(true), "Element has not styled text");
        return (A) this;
    }
}
