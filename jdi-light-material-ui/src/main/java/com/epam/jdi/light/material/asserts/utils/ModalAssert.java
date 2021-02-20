package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ModalAssert extends UIAssert<ModalAssert, Modal> {

    private String actualSimpleDescription;
    private String actualTransitionDescription;

    @JDIAction("Assert that '{name} enabled")
    public ModalAssert simpleAssertEnabled() {
        jdiAssert(element().isModalEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name} opened")
    public ModalAssert isSimpleModalPageOpened() {
        jdiAssert(element().isSimpleModalWindowOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that description is '{name}'")
    public ModalAssert simpleModalDescription(String expectedDescription) {
        jdiAssert(element().getSimpleModalDescription(expectedDescription), Matchers
                .is(actualSimpleDescription));
        return this;
    }

    @JDIAction("Assert that '{name} enabled")
    public ModalAssert isTransitionModalEnabled() {
        jdiAssert(element().isModalEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name} opened")
    public ModalAssert isTransitionModalOpened() {
        jdiAssert(element().isTransitionModalOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that description is '{name}'")
    public ModalAssert transitionModalDescription(String expectedDescription) {
        jdiAssert(element().getTransitionModalDescription(expectedDescription), Matchers.is(actualTransitionDescription));
        return this;
    }

    @JDIAction("Assert that '{name} enabled")
    public ModalAssert isSpringModalEnabled() {
        jdiAssert(element().isModalEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name} opened")
    public ModalAssert isSpringModalOpened() {
        jdiAssert(element().isSpringModalWindowOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that description is '{name}'")
    public ModalAssert springModalDescription(String expectedDescription) {
        jdiAssert(element().getSpringModalDescription(expectedDescription), Matchers.is(actualTransitionDescription));
        return this;
    }
}
