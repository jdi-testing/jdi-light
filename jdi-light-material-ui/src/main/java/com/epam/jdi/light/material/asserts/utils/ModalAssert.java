package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Modal}
 */
public class ModalAssert extends UIAssert<ModalAssert, Modal> implements ITextAssert<ModalAssert> {

    @Override
    @JDIAction("Assert that {name} text {0}")
    public ModalAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), Matchers.is(condition));
        return this;
    }
}
