package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ModalAssert extends UIAssert<ModalAssert, Modal> {

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingSimpleTitle(String actualSimpleTitle) {
        jdiAssert(element().verifySimpleModalTitle(actualSimpleTitle), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingTransitionTitle(String actualTransitionTitle) {
        jdiAssert(element().verifyTransitionModalTitle(actualTransitionTitle), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingServerTitle(String actualServerTitle) {
        jdiAssert(element().verifyServerModalTitle(actualServerTitle), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingSimpleDescription(String actualSimpleDescription) {
        jdiAssert(element().verifySimpleModalDescription(actualSimpleDescription), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingTransitionDescription(String actualTransitionDescription) {
        jdiAssert(element().verifyTransitionModalDescription(actualTransitionDescription), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingServerDescription(String actualServerDescription) {
        jdiAssert(element().verifyServerModalDescription(actualServerDescription), Matchers.is(true));
        return this;
    }
}
