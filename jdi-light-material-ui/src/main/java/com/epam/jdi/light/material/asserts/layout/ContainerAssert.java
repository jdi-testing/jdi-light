package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Container;
import org.hamcrest.Matchers;

import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ContainerAssert extends UIAssert<ContainerAssert, Container> {
    @JDIAction("Assert that style consists '{name}'")
    public ContainerAssert hasStyle(String style) {
        jdiAssert(element().hasStyle(style), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is displayed")
    @Override
    public ContainerAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }
}
