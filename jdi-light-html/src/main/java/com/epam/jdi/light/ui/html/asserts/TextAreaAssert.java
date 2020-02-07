package com.epam.jdi.mobile.ui.html.asserts;

import com.epam.jdi.mobile.asserts.generic.ITextAssert;
import com.epam.jdi.mobile.asserts.generic.UIAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.ui.html.elements.common.TextArea;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TextAreaAssert extends UIAssert<TextAreaAssert, TextArea> implements ITextAssert<TextAreaAssert> {
    @JDIAction("Assert that '{name}' text {0}")
    public TextAreaAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' rows count {0}")
    public TextAreaAssert rowsCount(Matcher<Integer> condition) {
        jdiAssert(element.rows(), condition);
        return this;
    }
    public TextAreaAssert rowsCount(int rowsCount) { return rowsCount(Matchers.is(rowsCount)); }

    @JDIAction("Assert that '{name}' columns count {0}")
    public TextAreaAssert colsCount(Matcher<Integer> condition) {
        jdiAssert(element.cols(), condition);
        return this;
    }
    public TextAreaAssert colsCount(int colsCount) { return colsCount(Matchers.is(colsCount)); }

    @JDIAction("Assert that '{name}' minlength {0}")
    public TextAreaAssert minlength(Matcher<Integer> condition) {
        jdiAssert(element.minlength(), condition);
        return this;
    }
    public TextAreaAssert minlength(int minlength) { return minlength(Matchers.is(minlength)); }

    @JDIAction("Assert that '{name}' maxlength {0}")
    public TextAreaAssert maxlength(Matcher<Integer> condition) {
        jdiAssert(element.maxlength(), condition);
        return this;
    }
    public TextAreaAssert maxlength(int maxlength) { return maxlength(Matchers.is(maxlength)); }

}
