package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsElevated;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ElevatedAssert<A, E extends IsElevated> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' has elevation value {0}")
    default A elevation(int value) {
        if (element().isElevated()) {
            jdiAssert(element().elevation(), Matchers.is(value));
        } else {
            elevated();
        }
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is elevated")
    default A elevated() {
        jdiAssert(element().isElevated() ? "is elevated" : "is not elevated", Matchers.is("is elevated"));
        return (A) this;
    }
}
