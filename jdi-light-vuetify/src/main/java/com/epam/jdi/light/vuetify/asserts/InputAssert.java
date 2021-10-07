package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Input;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class InputAssert extends UIAssert<InputAssert, Input> {
    @JDIAction("Assert that '{name}' is disabled")
    public InputAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public InputAssert textFromDisabled(String text) {
        jdiAssert(element().getTextFromDisabled(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has typed text in input field")
    public InputAssert typedText() {
        jdiAssert(element().hasTypedText(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has typed text '{0}' in input field")
    public InputAssert typedText(String text) {
        jdiAssert(element().getTypedText(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public InputAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has label '{0}'")
    public InputAssert label(String text) {
        jdiAssert(element().getLabel(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has message")
    public InputAssert message() {
        jdiAssert(element().hasMessage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has message '{0}'")
    public InputAssert message(String text) {
        jdiAssert(element().getMessage(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is loading")
    public InputAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }
}
