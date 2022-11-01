package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface RoundedAssert<A, E extends HasRounded> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is rounded")
    default A rounded() {
        jdiAssert(element().isRounded(), Matchers.is(true), "Element is not rounded");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has rounded value {0}")
    default A rounded(String value) {
        if (element().isRounded()) {
            String actualRounded = element().rounded();
            jdiAssert(actualRounded, Matchers.is(value),
                    String.format("Element has '%s' rounded value, but expected '%s' value", actualRounded, value));
        } else {
            rounded();
        }
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has rounded value {0}")
    default A rounded(int value) {
        return rounded(String.valueOf(value));
    }
}
