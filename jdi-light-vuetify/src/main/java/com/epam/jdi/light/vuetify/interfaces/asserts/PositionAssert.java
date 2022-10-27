package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasPosition;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface PositionAssert<A, E extends HasPosition> extends VuetifyElement<E> {

    @JDIAction("Assert that '{name}' has left position")
    default A leftPosition() {
        jdiAssert(element().hasLeftPosition() ? "has left position" : "has right position", Matchers.is("has left position"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has right position")
    default A rightPosition() {
        jdiAssert(element().hasRightPosition() ? "has right position" : "has left position", Matchers.is("has right position"));
        return (A) this;
    }
}
