package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.MultipleInputs;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class MultipleInputsAssert extends UIAssert<MultipleInputsAssert, MultipleInputs> {

    @JDIAction("Assert that {name} has text {0}")
    private MultipleInputsAssert text(Matcher<String> condition, String text) {
        jdiAssert(text, condition);
        return this;
    }

    public MultipleInputsAssert text(String text, int index) {
        return text(is(text), element.getText(index));
    }
}
