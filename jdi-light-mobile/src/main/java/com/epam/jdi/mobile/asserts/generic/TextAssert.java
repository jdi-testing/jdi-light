package com.epam.jdi.mobile.asserts.generic;

import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.interfaces.common.IsText;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TextAssert extends UIAssert<TextAssert, IsText>
        implements ITextAssert<TextAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    public TextAssert text(String text) { return text(Matchers.is(text)); }
}