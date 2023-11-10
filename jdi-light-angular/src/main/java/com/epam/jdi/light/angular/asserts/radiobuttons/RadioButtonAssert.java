package com.epam.jdi.light.angular.asserts.radiobuttons;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioButton;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class RadioButtonAssert extends UIAssert<RadioButtonAssert, RadioButton> {

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public RadioButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public RadioButtonAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public RadioButtonAssert color(AngularColors expectedColor) {
        jdiAssert(element().color().getColor(), Matchers.is(expectedColor.getColor()));
        return this;
    }

    @JDIAction("'{name}' element label is in before position")
    public RadioButtonAssert radioButtonBeforePosition() {
        jdiAssert(element().hasBeforePosition(), Matchers.is(true),
            "Radio button label is not in before position");
        return this;
    }

    @JDIAction("'{name}' element label is in before position")
    public RadioButtonAssert radioButtonAfterPosition() {
        jdiAssert(element().hasBeforePosition(), Matchers.is(false),
            "Radio button label is not in after position");
        return this;
    }

    @JDIAction("'{name}' is checked")
    public RadioButtonAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Radio button is not checked");
        return this;
    }

    @JDIAction("'{name}' is not checked")
    public RadioButtonAssert notChecked() {
        jdiAssert(element().isChecked(), Matchers.is(false), "Radio button is checked");
        return this;
    }

    @JDIAction("'{name}' has label with value '{0}'")
    public RadioButtonAssert label(String value) {
        jdiAssert(element().label().getValue(), Matchers.is(value));
        return this;
    }



}
