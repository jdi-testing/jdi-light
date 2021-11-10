package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextFieldAssert extends UIAssert<TextFieldAssert, TextField> {

    @JDIAction("Assert that '{name}' is readonly")
    public TextFieldAssert readonly() {
        jdiAssert(element().isReadonly() ? "readonly" : "not  readonly", Matchers.is("readonly"));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public TextFieldAssert focused() {
        jdiAssert(element().isFocused() ? "focused" : "not focused", Matchers.is("focused"));
        return this;
    }

    @JDIAction("Assert that '{name}' isn't focused")
    public TextFieldAssert notFocused() {
        jdiAssert(element().isFocused() ? "focused" : "not focused", Matchers.is("not focused"));
        return this;
    }

    @JDIAction("Assert that '{name}' is filled")
    public TextFieldAssert filled() {
        jdiAssert(element().isFilled() ? "filled" : "not filled", Matchers.is("filled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is outlined")
    public TextFieldAssert outlined() {
        jdiAssert(element().isOutlined() ? "outlined" : "not outlined", Matchers.is("outlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' is shaped")
    public TextFieldAssert shaped() {
        jdiAssert(element().isShaped() ? "shaped" : "not shaped", Matchers.is("shaped"));
        return this;
    }

    @JDIAction("Assert that '{name}' is solo")
    public TextFieldAssert solo() {
        jdiAssert(element().isSolo() ? "solo" : "not solo", Matchers.is("solo"));
        return this;
    }

    @JDIAction("Assert that '{name}' is full width")
    public TextFieldAssert fullWidth() {
        jdiAssert(element().isFullWidth() ? "full width" : "not full width", Matchers.is("full width"));
        return this;
    }

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
