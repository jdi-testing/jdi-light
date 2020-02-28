package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> implements ITextAssert<TextAreaAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextAreaAssert text(Matcher<String> condition, String ... messages) {
        jdiAssert(element.getText(), condition, messages);
        return this;
    }
    @JDIAction("Assert that '{name}' rows count {0}")
    public TextAreaAssert rowsCount(Matcher<Integer> condition, String ... messages) {
        jdiAssert(element.rows(), condition, messages);
        return this;
    }
    public TextAreaAssert rowsCount(int rowsCount, String ... messages) { return rowsCount(Matchers.is(rowsCount), messages); }

    @JDIAction("Assert that '{name}' columns count {0}")
    public TextAreaAssert colsCount(Matcher<Integer> condition, String ... messages) {
        jdiAssert(element.cols(), condition, messages);
        return this;
    }
    public TextAreaAssert colsCount(int colsCount, String ... messages) { return colsCount(Matchers.is(colsCount), messages); }

    @JDIAction("Assert that '{name}' minlength {0}")
    public TextAreaAssert minlength(Matcher<Integer> condition, String ... messages) {
        jdiAssert(element.minlength(), condition, messages);
        return this;
    }
    public TextAreaAssert minlength(int minlength, String ... messages) { return minlength(Matchers.is(minlength), messages); }

    @JDIAction("Assert that '{name}' maxlength {0}")
    public TextAreaAssert maxlength(Matcher<Integer> condition, String ... messages) {
        jdiAssert(element.maxlength(), condition, messages);
        return this;
    }
    public TextAreaAssert maxlength(int maxlength, String ... messages) { return maxlength(Matchers.is(maxlength), messages); }

}
