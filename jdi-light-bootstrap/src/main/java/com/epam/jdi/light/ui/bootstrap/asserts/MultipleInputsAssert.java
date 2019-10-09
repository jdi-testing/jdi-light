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
        return text(text, 1);
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

    public MultipleInputsAssert texts(List<String> texts) {
        return assertText(is(texts), element.getAllTexts());
    }

    public MultipleInputsAssert placeholder(String text, int index) {
        return assertText(is(text), element.placeholder(index));
    }

    public MultipleInputsAssert placeholder(String text, String locator) {
        return assertText(is(text), element.placeholder(locator));
    }

    public MultipleInputsAssert placeholder(String text) {
        return placeholder(text, 1);
    }

    public MultipleInputsAssert placeholders(List<String> texts) {
        return assertText(is(texts), element.placeholderAll());
    }

    public MultipleInputsAssert placeholder(Matcher<String> matcher, int index) {
        return assertText(matcher, element.placeholder(index));
    }

    public MultipleInputsAssert placeholder(Matcher<String> matcher, String locator) {
        return assertText(matcher, element.placeholder(locator));
    }

    public MultipleInputsAssert placeholder(Matcher<String> matcher) {
        return placeholder(matcher, 1);
    }

    public MultipleInputsAssert placeholders(Matcher<List<String>> matcher) {
        return assertText(matcher, element.placeholderAll());
    }

    public MultipleInputsAssert value(String text, int index) {
        return assertText(is(text), element.getValue(index));
    }

    public MultipleInputsAssert value(String text, String locator) {
        return assertText(is(text), element.getValue(locator));
    }

    public MultipleInputsAssert value(String text) {
        return value(text, 1);
    }

    public MultipleInputsAssert values(List<String> texts) {
        return assertText(is(texts), element.getAllValues());
    }

    public MultipleInputsAssert value(Matcher<String> matcher, int index) {
        return assertText(matcher, element.getValue(index));
    }

    public MultipleInputsAssert value(Matcher<String> matcher, String locator) {
        return assertText(matcher, locator);
    }

    public MultipleInputsAssert value(Matcher<String> matcher) {
        return value(matcher, 1);
    }

    public MultipleInputsAssert values(Matcher<List<String>> matcher) {
        return assertText(matcher, element.getAllValues());
    }
}
