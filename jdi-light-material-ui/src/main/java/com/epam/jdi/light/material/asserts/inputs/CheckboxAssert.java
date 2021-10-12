package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled() {
        Timer.waitCondition(element()::isEnabled);
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled() {
        Timer.waitCondition(element()::isDisabled);
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        Timer.waitCondition(element()::isChecked);
        jdiAssert(element().isChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not checked")
    public CheckboxAssert unChecked() {
        Timer.waitCondition(element()::isNotChecked);
        jdiAssert(element().isNotChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{className}' class")
    public CheckboxAssert hasClass(String className) {
        Timer.waitCondition(() -> element().hasClass(className));
        jdiAssert(element().hasClass(className), Matchers.is(true));
        return this;
    }
}
