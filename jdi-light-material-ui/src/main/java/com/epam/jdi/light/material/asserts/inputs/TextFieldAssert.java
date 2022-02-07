package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.TextField;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {
    // TODO: add method with Matcher in parameter: Matcher<String> condition
    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
    // TODO: add method with Matcher in parameter: Matcher<String> condition
    @JDIAction("Assert that '{name}'s label has expected value")
    public TextFieldAssert value(String value) {
        jdiAssert(element().getText(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that '{name}' is empty")
    public TextFieldAssert empty() {
        jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public TextFieldAssert enabled() {
        jdiAssert(element().isEnabled() ? "is enabled" : "is disabled", Matchers.is("is enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TextFieldAssert disabled() {
        jdiAssert(element().isDisabled() ? "is disabled" : "is enabled", Matchers.is("is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is readonly")
    public TextFieldAssert readonly() {
        jdiAssert(element().isReadonly() ? "is readonly" : "is not readonly", Matchers.is("is readonly"));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected helper text")
    public TextFieldAssert helperText(String text) {
        jdiAssert(element().getHelperText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s has placeholder")
    public TextFieldAssert placeholder() {
        jdiAssert(element().hasPlaceholder() ? "has placeholder" : "does not have placeholder",
                Matchers.is("has placeholder"));
        return this;
    }

    @JDIAction("Assert that '{name}'s has placeholder")
    public TextFieldAssert placeholderText(String text) {
        jdiAssert(element().getPlaceHolderText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused() ? "is focused" : "is not focused", Matchers.is("is focused"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected type")
    public TextFieldAssert type(String type) {
        jdiAssert(element().hasType(), Matchers.is(type));
        return this;
    }

    @JDIAction("Assert that '{name}' has error notification")
    public TextFieldAssert validationError() {
        jdiAssert(element().hasValidationError()  ? "has validation error" : "does not have validation error",
                Matchers.is("has validation error"));
        return this;
    }
}
