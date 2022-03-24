package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.generic.IColorAssert;
import com.epam.jdi.light.material.elements.feedback.progress.Progress;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

public class ProgressAssert<A extends ProgressAssert<?, ?>, E extends Progress<?>>
    extends UIAssert<A, E> implements IColorAssert<A> {

    @JDIAction("Assert that '{name}' is indeterminate")
    public A indeterminate() {
        boolean isIndeterminate = waitCondition(() -> element().isIndeterminate());
        jdiAssert(isIndeterminate ? "is indeterminate" : "is determinate", Matchers.is("is indeterminate"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is determinate")
    public A determinate() {
        boolean isDeterminate = waitCondition(() -> element().isDeterminate());
        jdiAssert(isDeterminate ? "is determinate" : "is indeterminate", Matchers.is("is determinate"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' value is {0}")
    public A value(int value) {
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' value {0}")
    public A value(Matcher<Integer> condition) {
        jdiAssert(element().getValueNow(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' min value is {0}")
    public A min(int minValue) {
        return min(Matchers.is(minValue));
    }

    @JDIAction("Assert that '{name}' min value is {0}")
    public A min(Matcher<Integer> condition) {
        jdiAssert(element().minValue(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' max value is {0}")
    public A max(int maxValue) {
        return max(Matchers.is(maxValue));
    }

    @JDIAction("Assert that '{name}' max value is {0}")
    public A max(Matcher<Integer> condition) {
        jdiAssert(element().maxValue(), condition);
        return (A) this;
    }

    @Override
    @JDIAction("Assert that '{name}' color {0}")
    public A color(Matcher<String> condition) {
        jdiAssert(element().color(), condition);
        return (A) this;
    }
}
