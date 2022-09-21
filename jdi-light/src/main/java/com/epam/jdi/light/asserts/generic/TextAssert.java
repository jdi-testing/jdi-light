package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TextAssert extends UIAssert<TextAssert, IsText>
        implements ITextAssert<TextAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
    public TextAssert text(String text) { return text(Matchers.is(text)); }

    @JDIAction("Assert that '{name}' has label")
    public TextAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public TextAssert hasNoLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There is a label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public TextAssert color(String color) {
        jdiAssert(element().core().css("color"), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has background-color '{0}'")
    public TextAssert backgroundColor(String color) {
        jdiAssert(element().css("background-color"), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has border color '{0}'")
    public TextAssert borderColor(String color) {
        jdiAssert(element().css("border-color"), Matchers.is(color));
        return this;
    }
}