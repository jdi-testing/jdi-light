package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;
import com.epam.jdi.light.material.elements.inputs.DateTimePickers;
import com.epam.jdi.light.material.elements.inputs.Picker;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PickersAssert extends UIAssert<PickersAssert, Picker> {

    @JDIAction("Assert that picker index {index} is displayed")
    public PickersAssert displayed(final int index) {
        jdiAssert(element().getPickerField(index).isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that of chip label {index} text is '{0}'")
    public PickersAssert text(final int index, Matcher<String> condition) {
        jdiAssert(element().getPickerField(index).getText(), condition);
        return this;
    }
}
