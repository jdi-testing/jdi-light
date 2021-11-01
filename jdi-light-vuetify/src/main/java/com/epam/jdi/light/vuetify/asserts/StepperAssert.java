package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Step;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepperAssert extends UIAssert<StepperAssert, Step> {

    @JDIAction("Assert that '{name}' is active")
    public StepperAssert active() {
        jdiAssert(element().stepIsActive(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public StepperAssert notActive() {
        jdiAssert(element().stepIsActive(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is complete")
    public StepperAssert complete() {
        jdiAssert(element().stepIsComplete(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not complete")
    public StepperAssert notComplete() {
        jdiAssert(element().stepIsComplete(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is editable")
    public StepperAssert editable() {
        jdiAssert(element().stepIsEditable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not editable")
    public StepperAssert notEditable() {
        jdiAssert(element().stepIsEditable(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' text is {0}")
    public StepperAssert text(String currentText) {
        jdiAssert(element().getName(), Matchers.is(currentText));
        return this;
    }

    @JDIAction("Assert that '{name}' contains {0}")
    public StepperAssert contains(String locator) {
        jdiAssert(element().core().getAttribute("class").contains(locator), Matchers.is(true));
        return this;
    }
}