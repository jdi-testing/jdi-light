package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepperAssert<A extends UIAssert<?, ?>, E extends Stepper<?>> extends UIAssert<A, E> {

    @JDIAction("Assert that '{name}' current value is '{0}'")
    public StepperAssert<A, E> currentIndex(int value) {
        return currentIndex(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' current value '{0}'")
    public StepperAssert<A, E> currentIndex(Matcher<Integer> condition) {
        jdiAssert(element().currentIndex(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' max value is '{0}'")
    public StepperAssert<A, E> maxIndex(int value) {
        return maxIndex(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' max value '{0}'")
    public StepperAssert<A, E> maxIndex(Matcher<Integer> condition) {
        jdiAssert(element().maxIndex(), condition);
        return this;
    }
}
