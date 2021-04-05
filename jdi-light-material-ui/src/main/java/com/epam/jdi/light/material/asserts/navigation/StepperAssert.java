package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Stepper;
import org.hamcrest.Matchers;

public class StepperAssert extends UIAssert<StepperAssert, Stepper> {

    @JDIAction("Assert that step title is correct")
    public StepperAssert text(String title) {
        jdiAssert(element().isTitleCorrect(title), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that step title is correct")
    public StepperAssert stepperDisplayed() {
        jdiAssert(element().isStepperDisplayed(), Matchers.is(true));
        return this;
    }
}
