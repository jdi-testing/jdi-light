package com.epam.jdi.light.material.asserts.utils;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Modal;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class ModalAssert extends UIAssert<ModalAssert, Modal> implements ITextAssert<ModalAssert> {

    @Override
    @JDIAction("Assert that {name} has text {0}")
    public ModalAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), Matchers.is(condition));
        return this;
    }
}
