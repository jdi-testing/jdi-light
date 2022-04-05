package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Assertions for all {@link Stepper} types.
 *
 * @param <A> type of {@link UIAssert} to be used with concrete {@link Stepper} type
 * @param <E> concrete {@link Stepper} type
 */
public class StepperAssert<A extends UIAssert<?, ?>, E extends Stepper<?>> extends UIAssert<A, E> {

    /**
     * Checks that current step index of this stepper matches given value.
     *
     * @param index expected current step index
     * @return this {@link StepperAssert} instance
     */
    @JDIAction("Assert that '{name}' current index is {0}")
    public StepperAssert<A, E> currentIndex(int index) {
        return currentIndex(Matchers.is(index));
    }

    /**
     * Checks that current step index of this stepper meets given condition.
     *
     * @param condition expected condition
     * @return this {@link StepperAssert} instance
     */
    @JDIAction("Assert that '{name}' current value {0}")
    public StepperAssert<A, E> currentIndex(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().currentIndex(), condition);
        return this;
    }

    /**
     * Checks that maximal step index of this stepper matches given value.
     *
     * @param index expected maximal step index
     * @return this {@link StepperAssert} instance
     */
    @JDIAction("Assert that '{name}' max index is {0}")
    public StepperAssert<A, E> maxIndex(int index) {
        return maxIndex(Matchers.is(index));
    }

    /**
     * Checks that maximal step index of this stepper meets given condition.
     *
     * @param condition expected condition
     * @return this {@link StepperAssert} instance
     */
    @JDIAction("Assert that '{name}' max value {0}")
    public StepperAssert<A, E> maxIndex(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().maxIndex(), condition);
        return this;
    }
}
