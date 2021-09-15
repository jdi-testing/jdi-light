package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressAssert extends UIAssert<ProgressAssert, ProgressBar> {

    @JDIAction("Assert that '{name}' has value '{0}'")
    public ProgressAssert value(Matcher<Integer> value) {
        jdiAssert(element().getValueNow(), value);
        return this;
    }

    public ProgressAssert value(int value) {
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public void indeterminate() {
        boolean isIndeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isIndeterminate());
        jdiAssert(isIndeterminate, Matchers.is(true));
    }

    @JDIAction("Assert that '{name}' is determinate")
    public void determinate() {
        boolean isDeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDeterminate());
        jdiAssert(isDeterminate, Matchers.is(true));
    }

    @JDIAction(value = "Get '{name}' min value {0}")
    public void min(Matcher<Integer> condition) {
        jdiAssert(element().getMinValue(), condition);
    }

    public void min(int minValue) {
        min(Matchers.is(minValue));
    }

    @JDIAction(value = "Get '{name}' max value {0}")
    public void max(Matcher<Integer> condition) {
        jdiAssert(element().getMaxValue(), condition);
    }

    public void max(int maxValue) {
        max(Matchers.is(maxValue));
    }

    @JDIAction("Assert that '{name}' has correct color")
    public void color(String color) {
        jdiAssert(element().isColorCorrect(color), Matchers.is(true));
    }

    @JDIAction("Assert that '{name}' has correct colors")
    public void color(String bar1Color, String bar2Color) {
        jdiAssert(element().bufferColors(bar1Color, bar2Color), Matchers.is(true));
    }

    @JDIAction("Assert that '{name}' is buffer")
    public void buffer() {
        jdiAssert(element().isBuffer(), Matchers.is(true));
    }
}
