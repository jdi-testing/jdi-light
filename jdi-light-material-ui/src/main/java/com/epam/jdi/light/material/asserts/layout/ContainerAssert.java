package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Container;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Container}
 */
public class ContainerAssert extends UIAssert<ContainerAssert, Container> {

    /**
     * Checks that Container is fixed
     */
    @JDIAction("Assert that '{name}' is fixed")
    public ContainerAssert fixed() {
        jdiAssert(element().fixed() ? "fixed" : "fluid", Matchers.is("fixed"));
        return this;
    }

    /**
     * Checks that Container is fluid
     */
    @JDIAction("Assert that '{name}' is fluid")
    public ContainerAssert fluid() {
        jdiAssert(element().fluid() ? "fluid" : "fixed", Matchers.is("fluid"));
        return this;
    }

    /**
     * Checks that container maximum width has given value
     *
     * @param maxWidthValue expected max width as {@code int}
     */
    @JDIAction("Assert that '{name}' max width is {0}")
    public ContainerAssert maxWidth(int maxWidthValue) {
        jdiAssert(element().getMaxWidth(), Matchers.is(maxWidthValue));
        return this;
    }
}
