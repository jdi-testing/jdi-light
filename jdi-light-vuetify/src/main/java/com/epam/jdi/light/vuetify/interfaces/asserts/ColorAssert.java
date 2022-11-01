package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ColorAssert<A, E extends HasColor> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' has color '{0}'")
    default A color(String color) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.is(color),
                String.format("Actual color of element is '%s', but expected '%s'", actualColor, color));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has background color '{0}'")
    default A backgroundColor(String color) {
        String actualColor = element().backgroundColor();
        jdiAssert(element().backgroundColor(), Matchers.is(color),
                String.format("Actual background color of element is '%s', but expected '%s'", actualColor, color));
        return (A) this;
    }
}
