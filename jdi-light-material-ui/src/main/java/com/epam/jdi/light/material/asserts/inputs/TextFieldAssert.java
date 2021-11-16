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

    @JDIAction("Assert that '{name}' has helper text")
    public TextFieldAssert helperTextField() {
        jdiAssert(element().hasHelperText() ? "has helper text" : "does not have helper text",
                Matchers.is("has helper text"));
        return this;
    }

    @JDIAction("Assert that '{name}'s label has expected text")
    public TextFieldAssert helperText(String text) {
        jdiAssert(element().getHelperText(), Matchers.is(text));
        return this;
    }


}
