package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;
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
        boolean actualFocused = element().focused();
        jdiAssert(actualFocused, Matchers.is(true),
            "Element is not focused");
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public ButtonAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor.toLowerCase()));
        return this;
    }

    @JDIAction("Assert that '{name}' has default color")
    public ButtonAssert defaultColor() {
        jdiAssert(element().defaultColor(), Matchers.is(true),
            "Element doesn't have default color.");
        return this;
    }

    @JDIAction("Assert that '{name}' has visual type '{0}'")
    public ButtonAssert visualTypeOfButton(ButtonsTypes expectedType) {
        ButtonsTypes actualVisualType = element().visualTypeOfButton();
        jdiAssert(actualVisualType.getType(), Matchers.is(expectedType.getType()));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public ButtonAssert hasIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(true),
                "Element doesn't have icon inside");
        return this;
    }
}
