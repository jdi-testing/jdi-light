package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.TextField;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {


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

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert text(String text) {
        jdiAssert(element().hasText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected value")
    public TextFieldAssert value(Float value) {
        jdiAssert(element().hasText(), Matchers.is(value.toString()));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected value")
    public TextFieldAssert empty() {
        jdiAssert(element().hasText(), Matchers.is(""));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert helperText(String text) {
        jdiAssert(element().getHelperText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert type(String type) {
        jdiAssert(element().hasType(), Matchers.is(type));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert error() {
        jdiAssert(element().isError(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert adornmentPosition(String position) {
        jdiAssert(element().hasAdornmentPosition(), Matchers.is(position));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert adornmentText(String text) {
        jdiAssert(element().hasAdornmentText(), Matchers.is(text));
        return this;
    }


}
