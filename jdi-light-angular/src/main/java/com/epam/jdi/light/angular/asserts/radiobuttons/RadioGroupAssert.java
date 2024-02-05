package com.epam.jdi.light.angular.asserts.radiobuttons;

import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioGroup;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioGroupAssert extends UISelectAssert<RadioGroupAssert, RadioGroup> {

    @JDIAction(value = "'{name}' is checked when '{0}' radio button value is provided", isAssert = true)
    public RadioGroupAssert checked(String value) {
        jdiAssert(element().isChecked(value), Matchers.is(true), "Radio button is not checked");
        return this;
    }

    @JDIAction(value = "'{name}' is not checked when '{0}' radio button value is provided", isAssert = true)
    public RadioGroupAssert notChecked(String value) {
        jdiAssert(element().isChecked(value), Matchers.is(false), "Radio button is checked");
        return this;
    }

    @JDIAction(value = "'{name}' label is in before position", isAssert = true)
    public RadioGroupAssert groupBeforePosition() {
        jdiAssert(element().isLabelsBeforePosition(), Matchers.is(true),
            "Radio group label is not in before position");
        return this;
    }

    @JDIAction(value = "'{name}' label is in after position", isAssert = true)
    public RadioGroupAssert groupAfterPosition() {
        jdiAssert(element().isLabelsBeforePosition(), Matchers.is(false),
            "Radio group label is not in after position");
        return this;
    }


    @JDIAction(value = "'{name}' is disabled", isAssert = true)
    public RadioGroupAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true),
            "Radio group is enabled");
        return this;
    }

    @JDIAction(value = "'{name}' is enabled", isAssert = true)
    public RadioGroupAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false),
            "Radio group is disabled");
        return this;
    }

    @JDIAction(value = "'{name}' is required", isAssert = true)
    public RadioGroupAssert required() {
        jdiAssert(element().isRequired(), Matchers.is(true),
            "Radio group is not required");
        return this;
    }

    @JDIAction(value = "'{name}' is not required", isAssert = true)
    public RadioGroupAssert notRequired() {
        jdiAssert(element().isRequired(), Matchers.is(false),
            "Radio group is required");
        return this;
    }

    @JDIAction(value = "'{name}' has checked radio button", isAssert = true)
    public RadioGroupAssert checkedRadioButton() {
        jdiAssert(element().checkedRadioButton(), Matchers.notNullValue(),
            "There is no checked radio button in the group");
        return this;
    }

    @JDIAction(value = "'{name}' has no checked radio button", isAssert = true)
    public RadioGroupAssert noCheckedRadioButton() {
        jdiAssert(element().checkedRadioButton(), Matchers.nullValue(),
            "There is checked radio button in the group");
        return this;
    }
}
