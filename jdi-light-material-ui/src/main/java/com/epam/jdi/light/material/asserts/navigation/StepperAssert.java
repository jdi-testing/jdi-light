package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Stepper;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepperAssert extends UIAssert<StepperAssert, Stepper> {

    @JDIAction("Assert that '{name}' has '{0}' steps")
    public StepperAssert steps(List<String> steps) {
        jdiAssert(element().asList(), Matchers.is(steps));
        return this;
    }

    public class StepAssert extends UIAssert<StepAssert, Stepper.Step> {
        @JDIAction("Assert that '{name}' has '{0}' text")
        public StepAssert text(String text) {
            jdiAssert(element().text(), Matchers.is(text));
            return this;
        }

        @JDIAction("Assert that '{name}' is enabled")
        public StepAssert enabled() {
            jdiAssert(element().isEnabled(), Matchers.is(true));
            return this;
        }

        @JDIAction("Assert that '{name}' is disabled")
        public StepAssert disabled() {
            jdiAssert(element().isDisabled(), Matchers.is(true));
            return this;
        }

        @JDIAction("Assert that '{name}' is completed")
        public StepAssert completed() {
            jdiAssert(element().isCompleted(), Matchers.is(true));
            return this;
        }

        @JDIAction("Assert that '{name}' is not completed")
        public StepAssert incomplete() {
            jdiAssert(element().isCompleted(), Matchers.is(false));
            return this;
        }
    }
}
