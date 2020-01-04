package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Range;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RangeAssert extends UIAssert<RangeAssert, Range> {

    @JDIAction("Assert that '{name}' value {0}")
    public RangeAssert value(Matcher<Integer> value) {
        jdiAssert(getInt("value", element.core()), value);
        return this;
    }
    public RangeAssert value(int value) { return value(Matchers.is(value)); }

    @JDIAction("Assert that '{name}' min value {0}")
    public RangeAssert minValue(Matcher<Integer> min) {
        jdiAssert(getInt("min", element.core()), min);
        return this;
    }
    public RangeAssert minValue(int minValue) { return minValue(Matchers.is(minValue)); }
    @JDIAction("Assert that '{name}' max value {0}")
    public RangeAssert maxValue(Matcher<Integer> max) {
        jdiAssert(getInt("max", element.core()), max);
        return this;
    }
    public RangeAssert maxValue(int maxValue) { return maxValue(Matchers.is(maxValue)); }

    @JDIAction("Assert that '{name}' step {0}")
    public RangeAssert step(Matcher<Integer> step) {
        jdiAssert(getInt("step", element.core()), step);
        return this;
    }
    public RangeAssert step(int step) { return step(Matchers.is(step)); }
}