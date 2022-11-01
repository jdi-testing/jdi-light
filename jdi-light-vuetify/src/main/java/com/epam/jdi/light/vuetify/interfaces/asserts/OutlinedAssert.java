package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface OutlinedAssert<A, E extends IsOutlined> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is outlined")
    default A outlined() {
        jdiAssert(element().isOutlined(), Matchers.is(true), "Element is not outlined");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not outlined")
    default A notOutlined() {
        jdiAssert(element().isOutlined(), Matchers.is(false), "Element is outlined");
        return (A) this;
    }
}
