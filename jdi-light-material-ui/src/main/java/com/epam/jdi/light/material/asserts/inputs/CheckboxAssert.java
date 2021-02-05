package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabledCheckbox() {
        jdiAssert(element().isDisabledCheckbox(), Matchers.is(true));
        return this;
    }
}

