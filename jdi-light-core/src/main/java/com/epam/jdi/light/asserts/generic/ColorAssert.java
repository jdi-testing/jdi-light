package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.asserts.generic.IBaseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ColorAssert<A, E extends HasColor> extends IBaseAssert<E> {

    @JDIAction("Assert that '{name}' has color '{0}'")
    default A color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has background color '{0}'")
    default A backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return (A) this;
    }
}
