package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsContainer;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ContainerAssert<A, E extends IsContainer> extends VuetifyElement<E> {
    @JDIAction("Assert that '{name}' cursor has type '{0}'")
    default A hasContent() {
        jdiAssert(element().hasContent(), Matchers.equalTo(true), "Element has no content");
        return (A) this;
    }
}
