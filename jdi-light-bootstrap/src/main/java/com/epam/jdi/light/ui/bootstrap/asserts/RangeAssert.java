package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Range;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.asInt;
import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.getInt;
import static org.hamcrest.Matchers.is;

public class RangeAssert extends UIAssert<RangeAssert, Range> {

//    @JDIAction("Assert that '{name}' thumbValue {0}")
//    public RangeAssert thumbValue(Matcher<Integer> thumbValue) {
//        jdiAssert(getInt("value", element.core()), thumbValue);
//        return this;
//    }
//    public RangeAssert thumbValue(int thumbValue) {
//        return thumbValue(is(thumbValue));
//    }

    @JDIAction("Assert that '{name}' thumbValue b {0}")
    public RangeAssert thumbValue(Matcher<Double> thumbValue) {
        jdiAssert(Double.parseDouble(element.getValue()), thumbValue);
        return this;
    }
    public RangeAssert thumbValue(double thumbValue) {
        return thumbValue(is(thumbValue));
    }

    @JDIAction("Assert that '{name}' min volume {0}")
    public RangeAssert minValue(Matcher<Integer> min) {
        jdiAssert(getInt("min", element.core()), min);
        return this;
    }
    public RangeAssert minValue(int minValue) {
        return minValue(is(minValue));
    }

    @JDIAction("Assert that '{name}' max volume {0}")
    public RangeAssert maxValue(Matcher<Integer> max) {
        jdiAssert(getInt("max", element.core()), max);
        return this;
    }
    public RangeAssert maxValue(int maxValue) {
        return maxValue(is(maxValue));
    }

    @JDIAction("Assert that '{name}' step {0}")
    public RangeAssert step(Matcher<Double> step) {
        jdiAssert(Double.parseDouble(element.core().getAttribute("step")), step);
        return this;
    }
    public RangeAssert step(double step) {
        return step(is(step));
    }

}
