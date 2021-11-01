package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public TextFieldAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is readonly")
    public TextFieldAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' isn't focused")
    public TextFieldAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' text is empty")
    public TextFieldAssert empty() {
        jdiAssert(element().getText(), Matchers.is(""));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TextFieldAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' text type is '{0}'")
    public TextFieldAssert textType(String textType) {
        jdiAssert(element().getTextType(), Matchers.is(textType));
        return this;
    }

    @JDIAction("Assert that '{name}' message is '{0}'")
    public TextFieldAssert message(String message) {
        jdiAssert(element().getMessage(), Matchers.is(message));
        return this;
    }

    @JDIAction("Assert that '{name}' has message")
    public TextFieldAssert message() {
        jdiAssert(element().getMessage(), Matchers.not(""));
        return this;
    }

    @JDIAction("Assert that '{name}' hasn't message")
    public TextFieldAssert noMessage() {
        jdiAssert(element().getMessage(), Matchers.is(""));
        return this;
    }

    @JDIAction("Assert that '{name}' counter is '{0}' / '{1}'")
    public TextFieldAssert counter(int currentCounter, int maxCounter) {
        String[] counter = element().getCounter().replaceAll("\\s", "").split("/");
        jdiAssert(Integer.parseInt(counter[0]), Matchers.is(currentCounter));
        jdiAssert(Integer.parseInt(counter[1]), Matchers.is(maxCounter));
        return this;
    }

    @JDIAction("Assert that '{name}' label is '{0}'")
    public TextFieldAssert label(String label) {
        jdiAssert(element().labelText(), Matchers.is(label));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public TextFieldAssert color(String color) {
        jdiAssert(element().core().getAttribute("class"), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}' have '{0}' peculiarity")
    public TextFieldAssert peculiarity(String peculiarity) {
        jdiAssert(element().core().getAttribute("class"), Matchers.containsString(peculiarity));
        return this;
    }

    @JDIAction("Assert that '{name}' placeholder is '{0}'")
    public TextFieldAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.containsString(placeholder));
        return this;
    }

    @JDIAction("Assert that '{name}' prefix is '{0}'")
    public TextFieldAssert prefix(String prefix) {
        jdiAssert(element().getPrefix(), Matchers.is(prefix));
        return this;
    }

    @JDIAction("Assert that '{name}' suffix is '{0}'")
    public TextFieldAssert suffix(String suffix) {
        jdiAssert(element().getSuffix(), Matchers.is(suffix));
        return this;
    }
}
