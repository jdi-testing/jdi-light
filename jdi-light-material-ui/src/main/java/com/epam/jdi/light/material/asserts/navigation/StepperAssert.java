package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Stepper;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepperAssert extends UISelectAssert<StepperAssert, Stepper> {

    @JDIAction("Assert that '{name}' has '{0}' steps")
    public StepperAssert steps(List<String> steps) {
        for (int i = 0; i < steps.size(); i++) {
            String labelLocator = ".MuiStepLabel-labelContainer";
            jdiAssert(element().list().get(i + 1).find(labelLocator).text(),
                    Matchers.is(steps.get(i)));
        }
        return this;
    }

    @JDIAction(value = "Check that '{name}' step is disabled", timeout = 0)
    public StepperAssert stepDisabled(int step) {
        jdiAssert(!element().stepEnabled(step) ? "disabled" : "enabled",
                Matchers.is("disabled"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' step is enabled", timeout = 0)
    public StepperAssert stepEnabled(int step) {
        jdiAssert(element().stepEnabled(step) ? "enabled" : "disabled",
                Matchers.is("enabled"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' step is completed", timeout = 0)
    public StepperAssert stepCompleted(int step) {
        jdiAssert(element().stepCompleted(step) ? "completed" : "not completed",
                Matchers.is("completed"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' step is incomplete", timeout = 0)
    public StepperAssert stepIncomplete(int step) {
        jdiAssert(!element().stepCompleted(step) ? "incomplete" : "completed",
                Matchers.is("incomplete"));
        return this;
    }
}
