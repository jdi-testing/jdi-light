package com.epam.jdi.light.ui.html.aserts;

import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.common.Text;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class TextAssert extends UIAssert<TextAssert, Text> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextAssert text(Matcher<String> condition) {
        jdiAssert(uiElement.getText(), condition);
        return this;
    }
    public TextAssert text(String text) { return text(is(text)); }
}