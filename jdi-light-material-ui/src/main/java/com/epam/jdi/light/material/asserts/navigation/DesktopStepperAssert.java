package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.DesktopStepper;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Assertions for {@link DesktopStepper}.
 */
public class DesktopStepperAssert extends StepperAssert<DesktopStepperAssert, DesktopStepper> {

    /**
     * Checks that this stepper has steps with given labels (headers) in any order.
     *
     * @param labelTexts expected step label texts (headers)
     * @return this {@link DesktopStepperAssert} instance
     */
    @JDIAction("Assert that '{name}' has '{0}' steps")
    public DesktopStepperAssert steps(String[] labelTexts) {
        SoftAssert.jdiAssert(Arrays.stream(labelTexts).filter(step -> element().hasStep(step)).collect(Collectors.toList()),
            Matchers.containsInAnyOrder(labelTexts));
        return this;
    }

    /**
     * Checks that all steps in this stepper are completed.
     *
     * @return this {@link DesktopStepperAssert} instance
     */
    @JDIAction("Assert that all steps in '{name}' are completed")
    public DesktopStepperAssert allStepsCompleted() {
        SoftAssert.jdiAssert(element().hasAllStepsCompleted() ? "has all steps completed" : "hasn't all steps completed",
            Matchers.is("has all steps completed"));
        return this;
    }

    /**
     * Checks that all steps in this stepper are incomplete.
     *
     * @return this {@link DesktopStepperAssert} instance
     */
    @JDIAction("Assert that all steps in '{name}' are incomplete")
    public DesktopStepperAssert allStepsIncomplete() {
        SoftAssert.jdiAssert(element().hasAllStepsIncomplete() ? "has all steps incomplete" : "hasn't all steps incomplete",
            Matchers.is("has all steps incomplete"));
        return this;
    }
}
