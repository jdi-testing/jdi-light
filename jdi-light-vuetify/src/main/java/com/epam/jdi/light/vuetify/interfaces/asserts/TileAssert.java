package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface TileAssert<A, E extends IsTile> extends VuetifyAssert<E> {

    @JDIAction("Assert that '{name}' is tile")
    default A tile() {
        jdiAssert(element().isTile() ? "is tile" : "is not tile", Matchers.is("is tile"));
        return (A) this;
    }
}
