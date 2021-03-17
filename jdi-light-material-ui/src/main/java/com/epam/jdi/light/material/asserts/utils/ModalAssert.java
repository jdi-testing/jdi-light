package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ModalAssert extends UIAssert<ModalAssert, Modal> {

    @JDIAction("Assert '{name}")
    public ModalAssert titleEquals(String expectedTitle) {
        jdiAssert(element().verifyModalTitle(expectedTitle), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}")
    public ModalAssert descriptionEquals(String expectedDescription) {
        jdiAssert(element().verifyModalDescription(expectedDescription), Matchers.is(true));
        return this;
    }

}
