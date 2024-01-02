package com.epam.jdi.light.vuetify.asserts.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Step;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepAssert extends UIAssert<StepAssert, Step> implements ColorAssert<StepAssert, Step> {

    @JDIAction(value = "Assert that '{name}' is active")
    public StepAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Step is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not active")
    public StepAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Step is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is complete")
    public StepAssert complete() {
        jdiAssert(element().isComplete(), Matchers.is(true), "Step is not complete");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not complete")
    public StepAssert notComplete() {
        jdiAssert(element().isComplete(), Matchers.is(false), "Step is complete");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is editable")
    public StepAssert editable() {
        jdiAssert(element().isEditable(), Matchers.is(true), "Step is not editable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not editable")
    public StepAssert notEditable() {
        jdiAssert(element().isEditable(), Matchers.is(false), "Step is editable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text is {0}")
    public StepAssert text(String currentText) {
        jdiAssert(element().getName(), Matchers.is(currentText));
        return this;
    }

    // TODO: Check this method
    @JDIAction(value = "Assert that '{name}' contains {0}")
    public StepAssert contains(String locator) {
        jdiAssert(element().core().getAttribute("class").contains(locator),
                Matchers.is(true), "Step doesn't contain element with locator " + locator);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' step has error")
    public StepAssert error() {
        jdiAssert(element().hasError(), Matchers.is(true), "Step has no error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' step has error")
    public StepAssert noError() {
        jdiAssert(element().hasError(), Matchers.is(false), "Step has an error");
        return this;
    }
}
