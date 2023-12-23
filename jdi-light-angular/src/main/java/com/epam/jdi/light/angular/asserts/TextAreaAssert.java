package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.TextArea;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> {

    @JDIAction("Assert that '{name}' has attribute auto-size")
    public TextAreaAssert autoSize() {
        jdiAssert(element().hasAutoSize(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has typed text '{0}' in input field")
    public TextAreaAssert value(String text) {
        jdiAssert(element().getValue(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder '{0}'")
    public TextAreaAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.containsString(placeholder));
        return this;
    }

    @JDIAction("Assert that '{name}' has height '{0}'")
    public TextAreaAssert height(int px) {
        jdiAssert(element().attr("style").contains(String.format("height: %spx", px)),
                Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has scroll up")
    public TextAreaAssert scrollUp() {
        jdiAssert(element().hasScrollUp(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has no scroll up")
    public TextAreaAssert noScrollUp() {
        jdiAssert(element().hasScrollUp(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has scroll down")
    public TextAreaAssert scrollDown() {
        jdiAssert(element().hasScrollDown(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has no scroll down")
    public TextAreaAssert noScrollDown() {
        jdiAssert(element().hasScrollDown(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
