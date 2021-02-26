package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public CheckboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not checked")
    public CheckboxAssert unChecked() {
        jdiAssert(element().isNotChecked(), Matchers.is(true));
        return this;
    }
}
