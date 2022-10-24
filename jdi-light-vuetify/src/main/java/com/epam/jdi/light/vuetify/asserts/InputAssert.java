package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Input;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class InputAssert extends UIAssert<InputAssert, Input> {
    @JDIAction("Assert that '{name}' is disabled")
    public InputAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public InputAssert textInSlot() {
        jdiAssert(element().hasTextInSlot(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public InputAssert textInSlot(String text) {
        jdiAssert(element().getTextInSlot(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has text field")
    public InputAssert textField() {
        jdiAssert(element().hasTextField(), Matchers.is(true));
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

    @JDIAction("Assert that '{name}' is loading")
    public InputAssert loaded() {
        jdiAssert(element().isLoading(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public InputAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not focused")
    public InputAssert notFocused() {
        jdiAssert(!element().isFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend outer")
    public InputAssert prependOuter() {
        jdiAssert(element().hasPrependOuter(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has prepend inner")
    public InputAssert prependInner() {
        jdiAssert(element().hasPrependInner(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has append outer")
    public InputAssert appendOuter() {
        jdiAssert(element().hasAppendOuter(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has append inner")
    public InputAssert appendInner() {
        jdiAssert(element().hasAppendInner(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has switch")
    public InputAssert switchInput() {
        jdiAssert(element().hasSwitch(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}'s switch is checked")
    public InputAssert checkedSwitch() {
        jdiAssert(element().switchIsChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}'s switch is unchecked")
    public InputAssert uncheckedSwitch() {
        jdiAssert(element().switchIsChecked(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has attribute '{0}'")
    public InputAssert className(String className) {
        jdiAssert(element().hasClass(className), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not attribute '{0}'")
    public InputAssert notClassName(String className) {
        jdiAssert(element().hasAttribute(className), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public InputAssert hasNoLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public InputAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' is readonly")
    public InputAssert readonly() {
        jdiAssert(element().isReadOnly() ? "is readonly" : "is not readonly", Matchers.is("is readonly"));
        return this;
    }

    @JDIAction("Assert that '{name}' has error messages")
    public InputAssert errorMessages() {
        jdiAssert(element().hasErrorMessages() ? "has error messages" : "has no error messages", Matchers.is("has error messages"));
        return this;
    }

    @JDIAction("Assert that '{name}' has {0} error messages text")
    public InputAssert errorMessagesText(List<String> errorMessages) {
        jdiAssert(element().errorMessages().equals(errorMessages), Matchers.is(true),
                String.format("Actual: {%s}, but expected: {%s}", element().errorMessages(), errorMessages));
        return this;
    }

    @JDIAction("Assert that '{name}' has {0} error messages")
    public InputAssert errorMessagesCount(int count) {
        jdiAssert(element().errorMessagesCount() == count, Matchers.is(true),
                String.format("Actual: {%s}, but expected: {%s}", element().errorMessagesCount(), count));
        return this;
    }

    @JDIAction("Assert that '{name}' has success messages")
    public InputAssert successMessages() {
        jdiAssert(element().hasSuccessMessages() ? "has success messages" : "has no success messages", Matchers.is("has success messages"));
        return this;
    }

    @JDIAction("Assert that '{name}' has {0} success messages text")
    public InputAssert successMessagesText(List<String> successMessages) {
        jdiAssert(element().successMessages().equals(successMessages), Matchers.is(true), String.format("Actual: {%s}, but expected: {%s}", element().successMessages(), successMessages));
        return this;
    }

    @JDIAction("Assert that '{name}' has {0} success messages")
    public InputAssert successMessagesCount(int count) {
        jdiAssert(element().successMessagesCount() == count, Matchers.is(true),
                String.format("Actual: {%s}, but expected: {%s}", element().successMessagesCount(), count));
        return this;
    }
}
