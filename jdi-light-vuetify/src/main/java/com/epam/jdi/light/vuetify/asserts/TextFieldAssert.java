package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TextFieldAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' message is '{0}'")
    public TextFieldAssert message(String message) {
        jdiAssert(element().getMessage(), Matchers.is(message));
        return this;
    }

    @JDIAction("Assert that '{name}' counter is '{0}'")
    public TextFieldAssert counter(String counter) {
        jdiAssert(element().getCounter(), Matchers.is(counter));
        return this;
    }

    @JDIAction("Assert that '{name}' label is '{0}'")
    public TextFieldAssert label(String label) {
        jdiAssert(element().labelText(), Matchers.is(label));
        return this;
    }
}
