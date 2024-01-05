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

    /**
     * Checks that this stepper has steps with given indexes in any order.
     *
     * @param indexes expected step indexes
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has '{0}' steps", isAssert = true)
    public MUIStepperAssert steps(Integer[] indexes) {
        SoftAssert.jdiAssert(
                Arrays.stream(indexes).filter(step -> element().hasStep(step)).collect(Collectors.toList()),
                Matchers.containsInAnyOrder(indexes));
        return this;
    }

    /**
     * Checks that this stepper has steps with given labels (headers) in any order.
     *
     * @param labelTexts expected step label texts (headers)
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has '{0}' steps", isAssert = true)
    public MUIStepperAssert steps(String[] labelTexts) {
        SoftAssert.jdiAssert(
                Arrays.stream(labelTexts).filter(step -> element().hasStep(step)).collect(Collectors.toList()),
            Matchers.containsInAnyOrder(labelTexts));
        return this;
    }

    /**
     * Checks that all steps in this stepper are completed.
     *
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that all steps in '{name}' are completed", isAssert = true)
    public MUIStepperAssert allStepsCompleted() {
        SoftAssert.jdiAssert(element().hasAllStepsCompleted(),
            Matchers.is(true),
                "Not all steps are completed");
        return this;
    }

    /**
     * Checks that all steps in this stepper are incomplete.
     *
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that all steps in '{name}' are incomplete", isAssert = true)
    public MUIStepperAssert allStepsIncomplete() {
        SoftAssert.jdiAssert(element().hasAllStepsIncomplete(),
            Matchers.is(true),
                "Not all steps are incomplete");
        return this;
    }

    /**
     * Waits until step with the given number is completed.
     *
     * @param stepNumber step number in this stepper
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that step '{0}' in '{name}' is completed", isAssert = true)
    public MUIStepperAssert stepCompleted(int stepNumber) {
        Timer timer = new Timer(base().getTimeout() * 1000L);
        SoftAssert.jdiAssert(timer.wait(() -> element().hasStepCompleted(stepNumber - 1)),
                Matchers.is(true), String.format("Step %s in not completed", stepNumber));
        return this;
    }

    /**
     * Checks if step with the given number is incomplete.
     *
     * @param stepNumber step number in this stepper
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that step '{0}' in '{name}' is incomplete", isAssert = true)
    public MUIStepperAssert stepIncomplete(int stepNumber) {
        SoftAssert.jdiAssert(element().hasStepCompleted(stepNumber - 1),
                Matchers.is(false), String.format("Step %s in not incomplete", stepNumber));
        return this;
    }

    /**
     * Checks if stepper is vertical.
     *
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is vertical", isAssert = true)
    public MUIStepperAssert isVertical() {
        SoftAssert.jdiAssert(element().isVertical(), Matchers.is(true),
                String.format("Stepper %s in not vertical", this.name));
        return this;
    }

    /**
     * Checks if stepper is horizontal.
     *
     * @return this {@link MUIStepperAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is horizontal", isAssert = true)
    public MUIStepperAssert isHorizontal() {
        SoftAssert.jdiAssert(element().isVertical(), Matchers.is(false),
                String.format("Stepper %s in vertical", this.name));
        return this;
    }
}
