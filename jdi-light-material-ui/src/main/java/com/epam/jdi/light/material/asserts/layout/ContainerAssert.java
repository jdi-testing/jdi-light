package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Container;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ContainerAssert extends UIAssert<ContainerAssert, Container> {
    @JDIAction("Assert that {name} is fixed")
    public ContainerAssert fixed() {
        jdiAssert(element().fixed() ? "fixed" : "fluid", Matchers.is("fixed"));
        return this;
    }

    @JDIAction("Assert that {name} is fluid")
    public ContainerAssert fluid() {
        jdiAssert(element().fluid() ? "fluid" : "fixed", Matchers.is("fluid"));
        return this;
    }

    /**
     * String maxWidthValue param example: "600px"
     */
    @JDIAction("Assert that {name} max width is {0}")
    public ContainerAssert maxWidth(String maxWidthValue) {
        jdiAssert(element().getMaxWidth(), Matchers.is(maxWidthValue));
        return this;
    }
}
