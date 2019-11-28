package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Range;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class RangeAssert extends UIAssert<RangeAssert, Range> {

    @JDIAction("Assert that '{name}' volume {0}")
    public RangeAssert value(Matcher<Double> value) {
        jdiAssert(getDouble("value", element.core()), value);
        return this;
    }

    public RangeAssert value(double value) {
        return value(is(value));
    }

    @JDIAction("Assert that '{name}' min volume is {0}")
    public RangeAssert minValue(Matcher<Double> min) {
        jdiAssert(element.min(), min);
        return this;
    }

    public RangeAssert minValue(double minValue) {
        return minValue(is(minValue));
    }


    @JDIAction("Assert that '{name}' max volume {0}")
    public RangeAssert maxValue(Matcher<Double> max) {
        jdiAssert(element.max(), max);
        return this;
    }

    public RangeAssert maxValue(double maxValue) {
        return maxValue(is(maxValue));
    }

    @JDIAction("Assert that '{name}' step is {0}")
    public RangeAssert step(Matcher<Double> step) {
        jdiAssert(element.step(), step);
        return this;
    }

    public RangeAssert step(double step) {
        return step(is(step));
    }
}
