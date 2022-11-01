package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ShapedAssert<A, E extends IsShaped> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is shaped")
    default A shaped() {
        jdiAssert(element().isShaped(), Matchers.is(true), "Element is not shaped");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not shaped")
    default A notShaped() {
        jdiAssert(element().isShaped(), Matchers.is(false), "Element is shaped");
        return (A) this;
    }
}
