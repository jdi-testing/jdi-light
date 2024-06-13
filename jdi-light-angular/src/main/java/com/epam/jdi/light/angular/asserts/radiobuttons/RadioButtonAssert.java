package com.epam.jdi.light.angular.asserts.radiobuttons;

import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioButton;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonAssert extends UIAssert<RadioButtonAssert, RadioButton> {

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public RadioButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public RadioButtonAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public RadioButtonAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction(value = "'{name}' element label is in before position", isAssert = true)
    public RadioButtonAssert labelBeforePosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(true), "Radio button label is not in before position");
        return this;
    }

    @JDIAction(value = "'{name}' element label is in before position", isAssert = true)
    public RadioButtonAssert labelAfterPosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(false), "Radio button label is not in after position");
        return this;
    }

    @JDIAction(value = "'{name}' is checked", isAssert = true)
    public RadioButtonAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Radio button is not checked");
        return this;
    }

    @JDIAction(value = "'{name}' is not checked", isAssert = true)
    public RadioButtonAssert notChecked() {
        jdiAssert(element().isChecked(), Matchers.is(false), "Radio button is checked");
        return this;
    }

    @JDIAction(value = "'{name}' has label with value '{0}'", isAssert = true)
    public RadioButtonAssert label(String value) {
        jdiAssert(element().label()
                          .getValue(), Matchers.is(value));
        return this;
    }
}
