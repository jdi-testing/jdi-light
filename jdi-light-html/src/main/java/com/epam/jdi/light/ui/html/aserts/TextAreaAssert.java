package com.epam.jdi.light.ui.html.aserts;

import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.asserts.HtmlAssertion;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.common.TextArea;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextAreaAssert text(Matcher<String> condition) {
        jdiAssert(uiElement.getText(), condition);
        return this;
    }
    public TextAreaAssert text(String text) { return text(is(text)); }

    @JDIAction("Assert that '{name}' rows count {0}")
    public TextAreaAssert rowsCount(Matcher<Integer> condition) {
        jdiAssert(uiElement.rows(), condition);
        return this;
    }
    public TextAreaAssert rowsCount(int rowsCount) { return rowsCount(is(rowsCount)); }

    @JDIAction("Assert that '{name}' columns count {0}")
    public TextAreaAssert colsCount(Matcher<Integer> condition) {
        jdiAssert(uiElement.cols(), condition);
        return this;
    }
    public TextAreaAssert colsCount(int colsCount) { return colsCount(is(colsCount)); }

    @JDIAction("Assert that '{name}' minlength {0}")
    public TextAreaAssert minlength(Matcher<Integer> condition) {
        jdiAssert(uiElement.minlength(), condition);
        return this;
    }
    public TextAreaAssert minlength(int minlength) { return minlength(is(minlength)); }

    @JDIAction("Assert that '{name}' maxlength {0}")
    public TextAreaAssert maxlength(Matcher<Integer> condition) {
        jdiAssert(uiElement.maxlength(), condition);
        return this;
    }
    public TextAreaAssert maxlength(int maxlength) { return maxlength(is(maxlength)); }

}
