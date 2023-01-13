package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import com.epam.jdi.light.vuetify.interfaces.VuetifyElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface TileAssert<A, E extends IsTile> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' is tile")
    default A tile() {
        jdiAssert(element().isTile(), Matchers.is(true), "Element is not tile");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not tile")
    default A notTile() {
        jdiAssert(element().isTile(), Matchers.is(false), "Element is tile");
        return (A) this;
    }
}
