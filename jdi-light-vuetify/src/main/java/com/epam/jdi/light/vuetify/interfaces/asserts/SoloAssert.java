package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsSolo;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface SoloAssert<A, E extends IsSolo> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is solo")
    default A solo() {
        jdiAssert(element().isSolo(), Matchers.is(true),"Element is not solo");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not solo")
    default A notSolo() {
        jdiAssert(element().isSolo(), Matchers.is(false),"Element is solo");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is solo-inverted")
    default A soloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(true),"Element is not solo-inverted");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not solo-inverted")
    default A notSoloInverted() {
        jdiAssert(element().isSoloInverted(), Matchers.is(false),"Element is solo-inverted");
        return (A) this;
    }
}
