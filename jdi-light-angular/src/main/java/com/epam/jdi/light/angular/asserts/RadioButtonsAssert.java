package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.RadioGroup;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonsAssert extends UISelectAssert<RadioButtonsAssert, RadioGroup> {

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
    public RadioButtonsAssert isGroupBeforePosition() {
        jdiAssert(element().isGroupBeforePosition(), Matchers.is(true),
            "Radio button group label is not in before position");
        return this;
    }

    @JDIAction("'{name}' element label is in before position")
    public RadioButtonsAssert isGroupElementBeforePosition(String value) {
        jdiAssert(element().isGroupElementBeforePosition(value), Matchers.is(true),
            "Radio button group element label is not in before position");
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

    @JDIAction("Assert that '{name}' color is '{0}'")
    public RadioButtonsAssert color(AngularColors expectedColor, String value) {
        jdiAssert(element().color(value).getColor(), Matchers.is(expectedColor.getColor()));
        return this;
    }
}

