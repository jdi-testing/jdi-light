package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Container;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Container}.
 */
public class ContainerAssert extends UIAssert<ContainerAssert, Container> implements ITextAssert<ContainerAssert> {

    /**
     * Checks that {@link Container} is fixed.
     *
     * @return this {@link ContainerAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is fixed", isAssert = true)
    public ContainerAssert fixed() {
        jdiAssert(element().isFixed(), Matchers.is(true), "Container is not fixed");
        return this;
    }

    /**
     * Checks that {@link Container} is fluid.
     *
     * @return this {@link ContainerAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is fluid", isAssert = true)
    public ContainerAssert fluid() {
        jdiAssert(element().isFluid(), Matchers.is(true), "Container is not fluid");
        return this;
    }

    /**
     * Checks that {@link Container} has given max width.
     *
     * @param maxWidthValue expected max width in pixels as {@code int}
     *
     * @return this {@link ContainerAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' max width is {0}", isAssert = true)
    public ContainerAssert maxWidth(int maxWidthValue) {
        jdiAssert(element().maxWidth(), Matchers.is(maxWidthValue));
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public ContainerAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
