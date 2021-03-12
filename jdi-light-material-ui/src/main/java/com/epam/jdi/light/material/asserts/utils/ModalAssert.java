package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ModalAssert extends UIAssert<ModalAssert, Modal> {

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingTitle(String actualTitle) {
        jdiAssert(element().verifyModalTitle(actualTitle), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert verifyingDescription(String actualDescription) {
        jdiAssert(element().verifyModalDescription(actualDescription), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name} is opened")
    public ModalAssert verifyingAdditionalModalDisplayed() {
        jdiAssert(element().verifyAdditionalModalOpened(), Matchers.is(true));
        return this;
    }
}
