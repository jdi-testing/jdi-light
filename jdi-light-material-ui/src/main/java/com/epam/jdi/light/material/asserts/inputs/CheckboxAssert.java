package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled() {
        boolean isEnabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isEnabled());
        jdiAssert(isEnabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled() {
        boolean isDisabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisabled());
        jdiAssert(isDisabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked());
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not checked")
    public CheckboxAssert unChecked() {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isNotChecked());
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{className}' class")
    public CheckboxAssert hasClass(String className) {
        boolean hasClass = new Timer(1000L)
                .wait(() -> element().hasClass(className));
        jdiAssert(hasClass, Matchers.is(true));
        return this;
    }
}
