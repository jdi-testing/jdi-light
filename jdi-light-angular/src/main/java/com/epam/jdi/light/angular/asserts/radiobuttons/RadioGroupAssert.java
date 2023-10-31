package com.epam.jdi.light.angular.asserts.radiobuttons;

import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioGroup;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioGroupAssert extends UISelectAssert<RadioGroupAssert, RadioGroup> {

    @JDIAction("'{name}' is checked when '{0}' radio button value is provided")
    public RadioGroupAssert checked(String value) {
        jdiAssert(element().isChecked(value), Matchers.is(true), "Radio button is not checked");
        return this;
    }

    @JDIAction("'{name}' is not checked when '{0}' radio button value is provided")
    public RadioGroupAssert notChecked(String value) {
        jdiAssert(element().isChecked(value), Matchers.is(false), "Radio button is checked");
        return this;
    }

    @JDIAction("'{name}' label is in before position")
    public RadioGroupAssert groupBeforePosition() {
        jdiAssert(element().isGroupBeforePosition(), Matchers.is(true),
            "Radio group label is not in before position");
        return this;
    }

    @JDIAction("'{name}' label is in after position")
    public RadioGroupAssert groupAfterPosition() {
        jdiAssert(element().isGroupBeforePosition(), Matchers.is(false),
            "Radio group label is not in after position");
        return this;
    }


    @JDIAction("'{name}' is disabled")
    public RadioGroupAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true),
            "Radio group is enabled");
        return this;
    }

    @JDIAction("'{name}' is enabled")
    public RadioGroupAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false),
            "Radio group is disabled");
        return this;
    }

    @JDIAction("'{name}' is required")
    public RadioGroupAssert required() {
        jdiAssert(element().isRequired(), Matchers.is(true),
            "Radio group is not required");
        return this;
    }

    @JDIAction("'{name}' is not required")
    public RadioGroupAssert notRequired() {
        jdiAssert(element().isRequired(), Matchers.is(false),
            "Radio group is required");
        return this;
    }
}
