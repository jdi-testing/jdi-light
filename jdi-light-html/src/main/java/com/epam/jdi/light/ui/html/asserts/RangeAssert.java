package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Range;
import org.hamcrest.*;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.light.ui.html.HtmlUtils.*;

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
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' min volume is {0}")
    public RangeAssert minValue(Matcher<Double> min) {
        jdiAssert(element.min(), min);
        return this;
    }
    public RangeAssert minValue(double minValue) {
        return minValue(Matchers.is(minValue));
    }
    public RangeAssert minValue(int minValue) {
        return minValue(Matchers.is((double)minValue));
    }


    @JDIAction("Assert that '{name}' max volume {0}")
    public RangeAssert maxValue(Matcher<Double> max) {
        jdiAssert(element.max(), max);
        return this;
    }

    public RangeAssert maxValue(double maxValue) {
        return maxValue(Matchers.is(maxValue));
    }
    public RangeAssert maxValue(int maxValue) {
        return maxValue(Matchers.is((double)maxValue));
    }
    @JDIAction("Assert that '{name}' step is {0}")
    public RangeAssert step(Matcher<Double> step) {
        jdiAssert(element.step(), step);
        return this;
    }

    public RangeAssert step(double step) {
        return step(Matchers.is(step));
    }
    public RangeAssert step(int step) {
        return step(Matchers.is((double)step));
    }
}
