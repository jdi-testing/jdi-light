package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class TextFieldAssert extends UIAssert<TextFieldAssert, IsText>
        implements ITextAssert<TextFieldAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextFieldAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    public TextFieldAssert text(String text) { return text(is(text)); }

    @JDIAction("Assert that '{name}' is placehoder")
    public TextFieldAssert placeholder(Matcher<String> condition) {
        jdiAssert(element.core().placeholder(), condition);
        return this;
    }
    public TextFieldAssert placeholder(String text) {
        return placeholder(is(text));
    }
}
