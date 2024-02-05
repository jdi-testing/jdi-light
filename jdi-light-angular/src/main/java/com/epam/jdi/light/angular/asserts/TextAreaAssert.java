package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.TextArea;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> {

    @JDIAction(value = "Assert that '{name}' has attribute auto-size", isAssert = true)
    public TextAreaAssert autoSize() {
        jdiAssert(element().hasAutoSize(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has typed text '{0}' in input field", isAssert = true)
    public TextAreaAssert value(String text) {
        jdiAssert(element().getValue(), Matchers.containsString(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder '{0}'", isAssert = true)
    public TextAreaAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.containsString(placeholder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has height '{0}'", isAssert = true)
    public TextAreaAssert height(int px) {
        jdiAssert(element().attr("style").contains(String.format("height: %spx", px)),
                Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has scroll up", isAssert = true)
    public TextAreaAssert scrollUp() {
        jdiAssert(element().hasScrollUp(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no scroll up", isAssert = true)
    public TextAreaAssert noScrollUp() {
        jdiAssert(element().hasScrollUp(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has scroll down", isAssert = true)
    public TextAreaAssert scrollDown() {
        jdiAssert(element().hasScrollDown(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no scroll down", isAssert = true)
    public TextAreaAssert noScrollDown() {
        jdiAssert(element().hasScrollDown(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
