package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class TextAreaAssert extends com.epam.jdi.light.ui.html.asserts.TextAreaAssert {

    @Override
    public TextArea element() {
        return (TextArea) super.element();
    }

    @JDIAction("Assert that '{name}' is filled")
    public TextAreaAssert filled() {
        jdiAssert(element().isFilled() ? "filled" : "not filled", Matchers.is("filled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is outlined")
    public TextAreaAssert outlined() {
        jdiAssert(element().isOutlined() ? "outlined" : "not outlined", Matchers.is("outlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' is autoGrow")
    public TextAreaAssert autoGrow() {
        jdiAssert(element().isAutoGrow() ? "auto grow" : "not auto grow", Matchers.is("auto grow"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not resizable")
    public TextAreaAssert notResizable() {
        jdiAssert(element().isNotResizable() ? "not resizable" : "resizable", Matchers.is("not resizable"));
        return this;
    }

    @JDIAction("Assert that '{name}' height {0}")
    public TextAreaAssert height(Matcher<Integer> condition) {
        jdiAssert(element().height(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' background-color {0}")
    public TextAreaAssert backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), equalTo(color));
        return this;
    }

    public TextAreaAssert backgroundColor(Enum<?> color) {
        backgroundColor(color.toString());
        return this;
    }

    @Override
    public TextAreaAssert colsCount(Matcher<Integer> condition) {
        return this;
    }

    @Override
    public TextAreaAssert colsCount(int colsCount) {
        return this;
    }

    @Override
    public TextAreaAssert minlength(Matcher<Integer> condition) {
        return this;
    }

    @Override
    public TextAreaAssert minlength(int minlength) {
        return this;
    }

    @Override
    public TextAreaAssert maxlength(Matcher<Integer> condition) {
        return this;
    }

    @Override
    public TextAreaAssert maxlength(int maxlength) {
        return this;
    }

    @Override
    public TextAreaAssert is() {
        return this;
    }

    @Override
    public TextAreaAssert assertThat() {
        return is();
    }

    @Override
    public TextAreaAssert has() {
        return is();
    }

    @Override
    public TextAreaAssert waitFor() {
        return is();
    }

    @Override
    public TextAreaAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public TextAreaAssert shouldBe() {
        return is();
    }

    @Override
    public TextAreaAssert verify() {
        assertSoft();
        return is();
    }

    @Override
    public TextAreaAssert and() {
        return this;
    }
}
