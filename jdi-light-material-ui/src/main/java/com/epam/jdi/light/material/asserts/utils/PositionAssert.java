package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.HasPosition;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public abstract class PositionAssert<A extends UIAssert<?, ?>, E extends HasPosition> extends UIAssert<A, E> {

    @JDIAction(value = "Assert that '{name}' has position '{0}'", isAssert = true)
    public A position(String position) {
        jdiAssert(element().position(), Matchers.is(Position.fromFullString(position)));
        return (A) this;
    }

    @JDIAction(value = "Assert that '{name}' has position '{0}'", isAssert = true)
    public A position(Position position) {
        jdiAssert(element().position(), Matchers.is(position));
        return (A) this;
    }

}
