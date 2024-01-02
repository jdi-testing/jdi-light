package com.epam.jdi.light.vuetify.asserts.radiobuttons;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.radiobuttons.RadioButton;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonAssert extends UIAssert<RadioButtonAssert, RadioButton> implements
        ColorAssert<RadioButtonAssert, RadioButton>, ThemeAssert<RadioButtonAssert, RadioButton> {
    @Override
    @JDIAction(value = "Assert that '{name}' is disabled")
    public RadioButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled")
    public RadioButtonAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Element is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' label has color '{0}'")
    public RadioButtonAssert labelColor(String color) {
        String actualColor = element().labelColor();
        jdiAssert(actualColor, Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success")
    public RadioButtonAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Element is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success")
    public RadioButtonAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Element is success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error")
    public RadioButtonAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Element is not error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error")
    public RadioButtonAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Element is error");
        return this;
    }
}
