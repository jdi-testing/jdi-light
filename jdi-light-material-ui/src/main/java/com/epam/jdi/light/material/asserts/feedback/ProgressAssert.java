package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.progress.Progress;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Assertions for {@link Progress}
 */
public class ProgressAssert<A extends ProgressAssert<?, ?>, E extends Progress<?>>
    extends UIAssert<A, E> {

    /**
     * Checks that progress is indeterminate.
     *
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' is indeterminate")
    public A indeterminate() {
        boolean isIndeterminate = waitCondition(() -> element().isIndeterminate());
        jdiAssert(isIndeterminate, Matchers.is(true), "Progress is not indeterminate");
        return (A) this;
    }

    /**
     * Checks that progress is determinate.
     *
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' is determinate")
    public A determinate() {
        boolean isDeterminate = waitCondition(() -> element().isDeterminate());
        jdiAssert(isDeterminate, Matchers.is(true), "Progress is not determinate");
        return (A) this;
    }

    /**
     * Checks that progress has given current value.
     *
     * @param value expected current value
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' value is {0}")
    public A value(int value) {
        return value(Matchers.is(value));
    }

    /**
     * Checks that progress current value meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' value {0}")
    public A value(Matcher<Integer> condition) {
        jdiAssert(element().getValueNow(), condition);
        return (A) this;
    }

    /**
     * Checks that progress has given min value.
     *
     * @param minValue expected min value
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' min value is {0}")
    public A min(int minValue) {
        return min(Matchers.is(minValue));
    }

    /**
     * Checks that progress min value meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' min value {0}")
    public A min(Matcher<Integer> condition) {
        jdiAssert(element().minValue(), condition);
        return (A) this;
    }

    /**
     * Checks that progress has given max value.
     *
     * @param maxValue expected max value
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' max value is {0}")
    public A max(int maxValue) {
        return max(Matchers.is(maxValue));
    }

    /**
     * Checks that progress max value meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link ProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' max value {0}")
    public A max(Matcher<Integer> condition) {
        jdiAssert(element().maxValue(), condition);
        return (A) this;
    }
}
