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
    public TextAssert text(Matcher<String> condition, String... messages) {
        jdiAssert(element.getText(), condition, messages);
        return this;
    }
    public TextAssert text(String text, String... messages) { return text(Matchers.is(text), messages); }
}