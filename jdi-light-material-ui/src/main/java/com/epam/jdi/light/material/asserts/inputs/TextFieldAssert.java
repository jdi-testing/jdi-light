package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.TextField;
import org.hamcrest.Matcher;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {

    @JDIAction("Assert that '{name}' is empty")
    public TextFieldAssert empty() {
        jdiAssert(element().getValue(), Matchers.blankOrNullString());
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TextFieldAssert text(String text) {
        jdiAssert(element().getValue(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public TextFieldAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public TextFieldAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is read-only")
    public TextFieldAssert readOnly() {
        jdiAssert(element().isReadOnly(), Matchers.is(true));
        return this;
    }
}
