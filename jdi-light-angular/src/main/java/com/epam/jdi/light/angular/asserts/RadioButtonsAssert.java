package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.RadioButtons;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonsAssert extends UIAssert<RadioButtonsAssert, RadioButtons> {

    @JDIAction("'{name}' is checked when '{0}' radio button value is provided")
    public RadioButtonsAssert checked(String value) {
        jdiAssert(element().isChecked(value), Matchers.is(true), "Radio button is not checked");
        return this;
    }

    @JDIAction("'{name}' is not checked when '{0}' radio button value is provided")
    public RadioButtonsAssert notChecked(String value) {
        jdiAssert(element().isChecked(value), Matchers.is(false), "Radio button is checked");
        return this;
    }

    @JDIAction("'{name}' label is in before position")
    public RadioButtonsAssert isBeforePosition() {
        jdiAssert(element().isBeforePosition(), Matchers.is(true),
            "Radio button label is not in before position");
        return this;
    }
    @JDIAction("'{name}' is disabled")
    public RadioButtonsAssert isDisabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true),
            "Radio button group is not disabled");
        return this;
    }

    @JDIAction("'{name}' is disabled")
    public RadioButtonsAssert isRequired() {
        jdiAssert(element().isRequired(), Matchers.is(true),
            "Radio button group is not required");
        return this;
    }

    @JDIAction("'{name}' has no ripple effect")
    public RadioButtonsAssert hasNoRippleEffect(String value) {
        jdiAssert(element().hasNoRippleEffect(value), Matchers.is(true),
            "Radio button has ripple effect");
        return this;
    }

    @JDIAction("'{name}' has ripple effect")
    public RadioButtonsAssert hasRippleEffect(String value) {
        jdiAssert(element().hasNoRippleEffect(value), Matchers.is(false),
            "Radio button has no ripple effect");
        return this;
    }

    @JDIAction("'{name}' has aria-label '{0}'")
    public RadioButtonsAssert hasAriaLabel(String ariaLabel) {
        jdiAssert(element().isAriaLabel(ariaLabel), Matchers.is(true),
            "Radio button aria-label is not equal " + ariaLabel);
        return this;
    }
}

