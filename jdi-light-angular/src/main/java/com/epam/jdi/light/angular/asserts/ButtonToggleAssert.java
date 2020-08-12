package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonToggleAssert extends UIAssert<ButtonToggleAssert, ButtonToggle> {

    @JDIAction("Assert that '{name}' has '{0}' class")
    public ButtonToggleAssert assertButtonToggleIsSelected(String value) {
        jdiAssert(element.isButtonToggleSelected(value), Matchers.is(true));
        return this;
    }

}
