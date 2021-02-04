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
}
