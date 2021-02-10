package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabledCheckbox() {
        jdiAssert(element().isEnabledCheckbox(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selectedCheckbox() {
        jdiAssert(element().isSelectedCheckbox(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert unSelectedCheckbox() {
        jdiAssert(element().isNotSelectedCheckbox(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabledCheckbox() {
        jdiAssert(element().isDisabledCheckbox(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public CheckboxAssert formControlDisplayed() {
        jdiAssert(element().isFormControlDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}' text")
    public CheckboxAssert assertEmailText() {
        jdiAssert(element().emailText(), Matchers.containsString("Email address"));
        return this;
    }

    @JDIAction("Assert '{name}' text")
    public CheckboxAssert assertHelperText() {
        jdiAssert(element().helperText(), Matchers.containsString("We ll never share your email."));
        return this;
    }

    @JDIAction("Assert that group '{name}' is disabled")
    public CheckboxAssert assertGroupDisabled() {
        jdiAssert(element().isGroupCheckboxDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that group '{name}' is checked")
    public CheckboxAssert assertGroupChecked() {
        jdiAssert(element().checkGroupSecondCheckbox(), Matchers.is(true));
        return this;
    }
}
