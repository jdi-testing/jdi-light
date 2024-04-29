package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.asserts.generic.IBaseAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.interfaces.HasSize;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface SizeAssert<A, E extends HasSize> extends IBaseAssert<E> {

    @JDIAction(value = "Assert that '{name}' size is x-small", isAssert = true)
    default A xSmallSize() {
        jdiAssert(element().xSmallSize(), Matchers.is(true), "Chip's size is not x-small");
        return (A) this;
    }

    @JDIAction(value = "Assert that '{name}' size is small", isAssert = true)
    default A smallSize() {
        jdiAssert(element().smallSize(), Matchers.is(true), "Chip's size is not small");
        return (A) this;
    }

    @JDIAction(value = "Assert that '{name}' size is default", isAssert = true)
    default A defaultSize() {
        jdiAssert(element().defaultSize(), Matchers.is(true), "Chip's size is not default");
        return (A) this;
    }

    @JDIAction(value = "Assert that '{name}' size is large", isAssert = true)
    default A largeSize() {
        jdiAssert(element().largeSize(), Matchers.is(true), "Chip's size is not large");
        return (A) this;
    }

    @JDIAction(value = "Assert that '{name}' size is x-large", isAssert = true)
    default A xLargeSize() {
        jdiAssert(element().xLargeSize(), Matchers.is(true), "Chip's size is not x-large");
        return (A) this;
    }
}
