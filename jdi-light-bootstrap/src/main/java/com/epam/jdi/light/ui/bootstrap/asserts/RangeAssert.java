package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Range;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssertUtils.jdiAssert;
import static org.hamcrest.Matchers.is;

public class RangeAssert extends UIAssert<RangeAssert, Range> {

    @JDIAction("Assert that '{name}' thumbValue is {0}")
    public RangeAssert thumbValue(Matcher<Double> thumbValue) {
        jdiAssert(element.thumbValue(), thumbValue);
        return this;
    }

    public RangeAssert thumbValue(double thumbValue) {
        return thumbValue(is(thumbValue));
    }

    @JDIAction("Assert that '{name}' min volume is {0}")
    public RangeAssert minValue(Matcher<Double> min) {
        jdiAssert(element.min(), min);
        return this;
    }

    public RangeAssert minValue(double minValue) {
        return minValue(is(minValue));
    }

    @JDIAction("Assert that '{name}' max volume is {0}")
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
