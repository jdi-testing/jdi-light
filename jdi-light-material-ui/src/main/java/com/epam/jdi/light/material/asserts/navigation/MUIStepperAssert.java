package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.MUIStepper;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Assertions for {@link MUIStepper}.
 */
public class MUIStepperAssert extends StepperAssert<MUIStepperAssert, MUIStepper> {

    private static final String STEP_COMPLETED = "has step completed";
    private static final String STEP_INCOMPLETE = "doesn't have step completed";

    /**
     * Checks that this stepper has steps with given indexes in any order.
     *
     * @param indexes expected step indexes
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction("Assert that '{name}' has '{0}' steps")
    public MUIStepperAssert steps(Integer[] indexes) {
        SoftAssert.jdiAssert(Arrays.stream(indexes).filter(step -> element().hasStep(step)).collect(Collectors.toList()),
                Matchers.containsInAnyOrder(indexes));
        return this;
    }

    /**
     * Checks that this stepper has steps with given labels (headers) in any order.
     *
     * @param labelTexts expected step label texts (headers)
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction("Assert that '{name}' has '{0}' steps")
    public MUIStepperAssert steps(String[] labelTexts) {
        SoftAssert.jdiAssert(Arrays.stream(labelTexts).filter(step -> element().hasStep(step)).collect(Collectors.toList()),
            Matchers.containsInAnyOrder(labelTexts));
        return this;
    }

    /**
     * Checks that all steps in this stepper are completed.
     *
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction("Assert that all steps in '{name}' are completed")
    public MUIStepperAssert allStepsCompleted() {
        SoftAssert.jdiAssert(element().hasAllStepsCompleted() ? "has all steps completed" : "hasn't all steps completed",
            Matchers.is("has all steps completed"));
        return this;
    }

    /**
     * Checks that all steps in this stepper are incomplete.
     *
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction("Assert that all steps in '{name}' are incomplete")
    public MUIStepperAssert allStepsIncomplete() {
        SoftAssert.jdiAssert(element().hasAllStepsIncomplete() ? "has all steps incomplete" : "hasn't all steps incomplete",
            Matchers.is("has all steps incomplete"));
        return this;
    }

    /**
     * Waits until step with the given number is completed.
     *
     * @param stepNumber step number in this stepper
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction("Assert that step '{0}' in '{name}' is completed")
    public MUIStepperAssert stepCompleted(int stepNumber) {
        Timer timer = new Timer(base().getTimeout() * 1000L);
        SoftAssert.jdiAssert(timer.wait(() -> element().hasStepCompleted(stepNumber - 1)) ?
                        STEP_COMPLETED : STEP_INCOMPLETE, Matchers.is(STEP_COMPLETED));
        return this;
    }

    /**
     * Checks if step with the given number is incomplete.
     *
     * @param stepNumber step number in this stepper
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction("Assert that step '{0}' in '{name}' is incomplete")
    public MUIStepperAssert stepIncomplete(int stepNumber) {
        SoftAssert.jdiAssert(element().hasStepCompleted(stepNumber - 1) ?
                        STEP_COMPLETED : STEP_INCOMPLETE, Matchers.is(STEP_INCOMPLETE));
        return this;
    }
}
