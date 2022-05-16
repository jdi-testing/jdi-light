package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {
    @JDIAction("Assert that '{name}' text is '{0}'")
    public TextFieldAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
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

    @JDIAction("Assert that '{name}' has message")
    public TextFieldAssert message() {
        jdiAssert(element().message().isExist() ? "exist" : "not exist", Matchers.is("exist"));
        return this;
    }

    @JDIAction("Assert that '{name}' hasn't message")
    public TextFieldAssert noMessage() {
        jdiAssert(element().message().isExist() ? "exist" : "not exist", Matchers.is("not exist"));
        return this;
    }

    @JDIAction("Assert that '{name}' placeholder is '{0}'")
    public TextFieldAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.is(placeholder));
        return this;
    }

    @JDIAction("Assert that '{name}' counter is '{0}' / '{1}'")
    public TextFieldAssert counter(int currentCounter, int maxCounter) {
        String[] counter = element().counter().text().replaceAll("\\s", "").split("/");
        jdiAssert(Integer.parseInt(counter[0]), Matchers.is(currentCounter));
        jdiAssert(Integer.parseInt(counter[1]), Matchers.is(maxCounter));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public TextFieldAssert color(String color) {
        jdiAssert(element().core().css("color"), Matchers.is(color));
        return this;
    }
}
