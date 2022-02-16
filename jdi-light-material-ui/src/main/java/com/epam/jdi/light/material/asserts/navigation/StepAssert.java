package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import org.hamcrest.Matchers;

public class StepAssert extends UIAssert<StepAssert, Step> {


    @JDIAction("Check that '{name}' step is completed")
    public StepAssert completed() {
        jdiAssert(element().isCompleted() ? "completed" : "not completed",
            Matchers.is("completed"));
        return this;
    }

    @JDIAction("Check that '{name}' step is incomplete")
    public StepAssert incomplete() {
        jdiAssert(!element().isCompleted() ? "incomplete" : "completed",
            Matchers.is("incomplete"));
        return this;
    }
}
