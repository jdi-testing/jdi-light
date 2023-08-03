package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes;
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

    @JDIAction("Assert that '{name}' of type '{0}' label has text '{1}'")
    public ButtonAssert buttonLabelText(ButtonsTypes buttonType, String expectedText) {
        jdiAssert(element().buttonLabelText(buttonType), Matchers.containsString(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public ButtonAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' has default color")
    public ButtonAssert defaultColor() {
        jdiAssert(element().defaultColor(), Matchers.is(true));
        return this;
    }
}
