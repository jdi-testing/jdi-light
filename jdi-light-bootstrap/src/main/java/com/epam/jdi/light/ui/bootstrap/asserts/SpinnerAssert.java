package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class SpinnerAssert extends UIAssert<SpinnerAssert, Spinner> {
    @JDIAction("Assert that '{name}' color {0}")
    public SpinnerAssert color(Matcher<String> condition) {
        jdiAssert(element.getColor(), condition);
        return this;
    }

    public SpinnerAssert color(String condition) {
        return color(is(condition));
    }
}
