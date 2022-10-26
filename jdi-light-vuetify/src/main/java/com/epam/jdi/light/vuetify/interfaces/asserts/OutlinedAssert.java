package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface OutlinedAssert<A, E extends IsOutlined> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is outlined")
    default A outlined() {
        jdiAssert(element().isOutlined() ? "is outlined" : "is not outlined", Matchers.is("is outlined"));
        return (A) this;
    }
}
