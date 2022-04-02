package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileProgress;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class StepperWithProgressAssert extends UIAssert<StepperWithProgressAssert, MobileProgress> {

    @JDIAction("Assert that '{name}' current value is {0}")
    public StepperWithProgressAssert value(int value) {
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' current value {0}")
    public StepperWithProgressAssert value(Matcher<Integer> condition) {
        jdiAssert(element().value(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' max value is {0}")
    public StepperWithProgressAssert maxValue(int value) {
        return maxValue(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' max value {0}")
    public StepperWithProgressAssert maxValue(Matcher<Integer> condition) {
        jdiAssert(element().maxValue(), condition);
        return this;
    }

}
