package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.MultipleInputs;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class MultipleInputsAssert extends UIAssert<MultipleInputsAssert, MultipleInputs> {

    @JDIAction("Assert that {name} has text {0}")
    private MultipleInputsAssert assertText(Matcher<String> condition, String text) {
        jdiAssert(text, condition);
        return this;
    }

    @JDIAction("Assert that {name} has texts {0}")
    private MultipleInputsAssert assertText(Matcher<List<String>> condition, List<String> texts) {
        jdiAssert(texts, condition);
        return this;
    }

    public MultipleInputsAssert text(String text, int index) {
        return assertText(is(text), element.getText(index));
    }

    public MultipleInputsAssert text(String text, String locator) {
        return assertText(is(text), element.getText(locator));
    }

    public MultipleInputsAssert text(String text) {
        return assertText(is(text), element.getText(1));
    }

    public MultipleInputsAssert text(List<String> texts) {
        return assertText(is(texts), element.getAllTexts());
    }

    public MultipleInputsAssert text(Matcher<String> matcher, int index) {
        return assertText(matcher, element.getText(index));
    }

    public MultipleInputsAssert text(Matcher<String> matcher, String locator) {
        return assertText(matcher, element.getText(locator));
    }

    public MultipleInputsAssert text(Matcher<List<String>> texts) {
        return assertText(texts, element.getAllTexts());
    }
}
