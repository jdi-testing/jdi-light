package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsClearable;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ClearableAssert<A, E extends IsClearable> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is clearable")
    default A clearable() {
        jdiAssert(element().isClearable(), Matchers.is(true), "Element is not clearable");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not clearable")
    default A notClearable() {
        jdiAssert(element().isClearable(), Matchers.is(false), "Element is clearable");
        return (A) this;
    }
}
