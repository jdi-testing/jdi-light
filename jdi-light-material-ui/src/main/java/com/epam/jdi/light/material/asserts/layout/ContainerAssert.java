package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Container;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ContainerAssert extends UIAssert<ContainerAssert, Container> {

    /**
     * String maxWidthValue param example: "600px"
     */
    @JDIAction("Assert that '{name}' max width is {0}")
    public ContainerAssert maxWidth(int maxWidthValue) {
        jdiAssert(element().getMaxWidth(), Matchers.is(maxWidthValue));
        return this;
    }
}
