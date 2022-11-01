package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ElevationAssert<A, E extends HasElevation> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' has elevation value {0}")
    default A elevation(int value) {
        if (element().isElevated()) {
            int actualElevation = element().elevation();
            jdiAssert(actualElevation, Matchers.is(value),
                    String.format("Element has '%d' elevation value, but expected '%d' value", actualElevation, value));
        } else {
            elevated();
        }
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is elevated")
    default A elevated() {
        jdiAssert(element().isElevated(), Matchers.is(true),"Element is not elevated");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not elevated")
    default A notElevated() {
        jdiAssert(element().isElevated(), Matchers.is(false), "Element is elevated");
        return (A) this;
    }
}
