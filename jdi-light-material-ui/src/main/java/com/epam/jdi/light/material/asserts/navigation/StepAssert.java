package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import org.hamcrest.Matchers;

public class StepAssert extends UIAssert<StepAssert, Step> {

    @JDIAction(value = "Check that '{name}' step is completed", isAssert = true)
    public StepAssert completed() {
        jdiAssert(element().isCompleted(), Matchers.is(true),
                "Step is not completed");
        return this;
    }

    @JDIAction(value = "Check that '{name}' step is incomplete", isAssert = true)
    public StepAssert incomplete() {
        jdiAssert(element().isCompleted(), Matchers.is(false),
                "Step is completed");
        return this;
    }
}
