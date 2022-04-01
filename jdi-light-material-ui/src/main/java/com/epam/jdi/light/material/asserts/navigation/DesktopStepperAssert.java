package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.DesktopStepper;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DesktopStepperAssert extends StepperAssert<DesktopStepperAssert, DesktopStepper> {

    @JDIAction("Assert that '{name}' has '{0}' steps")
    public DesktopStepperAssert stepsLabels(String[] steps) {
        jdiAssert(Arrays.stream(steps).filter(step -> element().hasStep(step)).collect(Collectors.toList()),
            Matchers.contains(steps));
        return this;
    }

    @JDIAction("Assert that all steps in '{name}' are completed")
    public DesktopStepperAssert allStepsCompleted() {
        jdiAssert(element().hasAllStepsCompleted() ? "has all steps completed" : "hasn't all steps completed",
            Matchers.is("has all steps completed"));
        return this;
    }

    @JDIAction("Assert that all steps in '{name}' are incomplete")
    public DesktopStepperAssert allStepsIncomplete() {
        jdiAssert(element().hasAllStepsIncomplete() ? "has all steps incomplete" : "hasn't all steps incomplete",
            Matchers.is("has all steps incomplete"));
        return this;
    }
}
