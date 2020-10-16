package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Stepper;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepperAssert extends UIAssert<StepperAssert, Stepper> {

    @JDIAction("Assert that '{name}' has field '{0}' with value '{1}'")
    public StepperAssert value(final Matcher<String> value, final String field) {
        jdiAssert(element().value(field), value);
        return this;
    }

    public StepperAssert value(final String value, final String field) {
        return value(Matchers.is(field), value);
    }
}
