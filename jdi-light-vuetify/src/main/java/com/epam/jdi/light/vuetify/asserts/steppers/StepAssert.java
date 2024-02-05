package com.epam.jdi.light.vuetify.asserts.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Step;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepAssert extends UIAssert<StepAssert, Step> implements ColorAssert<StepAssert, Step> {

    @JDIAction(value = "Assert that '{name}' is active", isAssert = true)
    public StepAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Step is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not active", isAssert = true)
    public StepAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Step is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is complete", isAssert = true)
    public StepAssert complete() {
        jdiAssert(element().isComplete(), Matchers.is(true), "Step is not complete");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not complete", isAssert = true)
    public StepAssert notComplete() {
        jdiAssert(element().isComplete(), Matchers.is(false), "Step is complete");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is editable", isAssert = true)
    public StepAssert editable() {
        jdiAssert(element().isEditable(), Matchers.is(true), "Step is not editable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not editable", isAssert = true)
    public StepAssert notEditable() {
        jdiAssert(element().isEditable(), Matchers.is(false), "Step is editable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text is {0}", isAssert = true)
    public StepAssert text(String currentText) {
        jdiAssert(element().getName(), Matchers.is(currentText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' step has error", isAssert = true)
    public StepAssert error() {
        jdiAssert(element().hasError(), Matchers.is(true), "Step has no error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' step has error", isAssert = true)
    public StepAssert noError() {
        jdiAssert(element().hasError(), Matchers.is(false), "Step has an error");
        return this;
    }
}
