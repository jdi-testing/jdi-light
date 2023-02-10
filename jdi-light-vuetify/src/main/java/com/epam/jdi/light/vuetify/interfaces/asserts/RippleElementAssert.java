package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasRippleElement;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface RippleElementAssert <A, E extends HasRippleElement> extends VuetifyElement<E> {
    @JDIAction("Assert that '{name}' has ripple element")
    default A rippleElement(String element) {
        jdiAssert(element().hasRippleElement(element), Matchers.is(true),"Element does not have ripple element");
        return (A) this;
    }
}
