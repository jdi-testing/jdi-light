package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.ButtonsColors;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonAssert extends UIAssert<ButtonAssert, Button> {

    @JDIAction("Assert that '{name}' has text '{0}'")
    public ButtonAssert text(String expectedText) {
        jdiAssert(element().text(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public ButtonAssert focused() {
        jdiAssert(element().focused(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' label has text '{0}'")
    public ButtonAssert buttonLabelText(String expectedText) {
        jdiAssert(element().buttonLabelText(), Matchers.containsString(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public ButtonAssert color(ButtonsColors expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor.getColor()));
        return this;
    }
}
