package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert unSelected() {
        jdiAssert(element().isNotSelected(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled() {
        jdiAssert(element().isDisabledCheckbox(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that group '{name}' is disabled")
    public CheckboxAssert assertGroupDisabled() {
        jdiAssert(element().isDisabledCheckbox(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that group '{name}' is checked")
    public CheckboxAssert assertGroupChecked() {
        jdiAssert(element().checkGroupSecondCheckbox(), Matchers.is(true));
        return this;
    }
}
