package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {
    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public CheckboxAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Checkbox is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public CheckboxAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Checkbox is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is indeterminate", isAssert = true)
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Checkbox is determinate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not indeterminate", isAssert = true)
    public CheckboxAssert notIndeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(false), "Checkbox is indeterminate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    @Override
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "Checkbox is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    @Override
    public CheckboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Checkbox is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is aligned in before position", isAssert = true)
    public CheckboxAssert alignedBefore() {
        jdiAssert(element().isAlignedBefore(), Matchers.is(true), "Checkbox is aligned after");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is aligned in after position", isAssert = true)
    public CheckboxAssert alignedAfter() {
        jdiAssert(element().isAlignedBefore(), Matchers.is(false), "Checkbox is aligned before");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is required", isAssert = true)
    public CheckboxAssert required() {
        jdiAssert(element().isRequired(), Matchers.is(true), "Checkbox does not have feature: required");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not required", isAssert = true)
    public CheckboxAssert notRequired() {
        jdiAssert(element().isRequired(), Matchers.is(false), "Checkbox has feature: required");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public CheckboxAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor));
        return this;
    }

}
