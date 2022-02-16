package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;
import java.util.stream.Collectors;
import org.hamcrest.Matchers;

public class StepperAssert extends UIAssert<StepperAssert, Stepper> {

    @JDIAction("Assert that '{name}' has '{0}' steps")
    public StepperAssert stepsLabels(String[] steps) {
        jdiAssert(element().steps().stream().map(Step::labelText).collect(Collectors.toList()),
            Matchers.contains(steps));
        return this;
    }

    @JDIAction("Assert that all steps in '{name}' are completed")
    public StepperAssert allStepsCompleted() {
        jdiAssert(element().steps().stream().map(Step::isCompleted).collect(Collectors.toList()),
            Matchers.everyItem(Matchers.is(Boolean.TRUE)));
        return this;
    }
}
