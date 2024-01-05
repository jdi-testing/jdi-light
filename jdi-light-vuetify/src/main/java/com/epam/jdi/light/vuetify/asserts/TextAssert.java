package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Text;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextAssert extends UIAssert<TextAssert, Text> implements ITextAssert<TextAssert> {

    @JDIAction(value = "Assert that '{name}' text matches the condition", isAssert = true)
    public TextAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public TextAssert text(String text) {
        return text(Matchers.is(text));
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public TextAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has color '{0}'", isAssert = true)
    public TextAssert backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return this;
    }
}
