package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> implements ITextAssert<TextAreaAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public TextAreaAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
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

    @JDIAction("Assert that '{name}' rows count {0}")
    public TextAreaAssert rowsCount(Matcher<Integer> condition) {
        jdiAssert(element().rows(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' rows count equal to {0}")
    public TextAreaAssert rowsCount(int rowsCount) {
        return rowsCount(Matchers.is(rowsCount));
    }

    @JDIAction("Assert that '{name}' has lines {0}")
    public TextAreaAssert lines(Matcher<? super List<String>> condition) {
        jdiAssert(element().getLines(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has lines: {0}")
    public TextAreaAssert lines(String... lines) {
        return lines(containsInAnyOrder(lines));
    }

    @JDIAction("Assert that '{name}' has lines: {0}")
    public TextAreaAssert lines(List<String> lines) {
        return lines(containsInAnyOrder(lines.toArray()));
    }
}
