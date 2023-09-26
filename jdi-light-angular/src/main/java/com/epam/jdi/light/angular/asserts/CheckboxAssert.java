package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {
    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Checkbox is not selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert deselected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Checkbox is selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Checkbox is determinate");
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "Checkbox is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public CheckboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Checkbox is enabled");
        return this;
    }

    @JDIAction("Assert that '{name}' is aligned in before position")
    public CheckboxAssert alignedBefore() {
        jdiAssert(element().isAlignedBefore(), Matchers.is(true), "Checkbox is aligned after");
        return this;
    }

    @JDIAction("Assert that '{name}' is aligned in after position")
    public  CheckboxAssert alignedAfter() {
        jdiAssert(element().isAlignedBefore(), Matchers.is(false), "Checkbox is aligned before");
        return this;
    }

    @JDIAction("Assert that '{name}' has no ripple effect")
    public CheckboxAssert noRippleEffect() {
        jdiAssert(element().isNoRippleEffect(), Matchers.is(true), "Checkbox has ripple effect");
        return this;
    }

    @JDIAction("Assert that '{name}' has aria-label '{0}'")
    public CheckboxAssert hasAriaLabel(String ariaLabel) {
        jdiAssert(element().hasAriaLabel(ariaLabel), Matchers.is(true),
            "Checkbox aria-label is not equal " + ariaLabel);
        return this;
    }

    @JDIAction("Assert that '{name}' is required")
    public CheckboxAssert isRequired() {
        jdiAssert(element().isRequired(), Matchers.is(true), "Checkbox does not have feature: required");
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public CheckboxAssert color(String expectedColor) {
        jdiAssert(element().color().getColor(), Matchers.equalToIgnoringCase(expectedColor.toLowerCase()),
            "Checkbox color is not equal " + expectedColor);
        return this;
    }

}
