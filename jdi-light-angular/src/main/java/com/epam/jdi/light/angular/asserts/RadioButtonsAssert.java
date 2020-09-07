package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.RadioButtons;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonsAssert extends UIAssert<RadioButtonsAssert, RadioButtons> {

    @JDIAction("'{name}' is checked when '{0}' radio button value is provided")
    public RadioButtonsAssert checked(String value) {
        jdiAssert(element.isChecked(value), Matchers.is(true));
        return this;
    }

    @JDIAction("'{name}' is not checked when '{0}' radio button value is provided")
    public RadioButtonsAssert notChecked(String value) {
        jdiAssert(element.isChecked(value), Matchers.is(false));
        return this;
    }
}

