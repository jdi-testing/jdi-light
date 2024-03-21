package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.angular.elements.enums.ButtonsTypes;
import com.epam.jdi.light.angular.elements.interfaces.asserts.HasBadgeAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonAssert extends UIAssert<ButtonAssert, Button> implements HasBadgeAssert {

    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public ButtonAssert text(String expectedText) {
        jdiAssert(element().text(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is focused", isAssert = true)
    public ButtonAssert focused() {
        boolean actualFocused = element().focused();
        jdiAssert(actualFocused, Matchers.is(true),
                  "Element is not focused");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public ButtonAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.equalToIgnoringCase(expectedColor.toLowerCase()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public ButtonAssert color(AngularColors expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor.getType()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has default color", isAssert = true)
    public ButtonAssert defaultColor() {
        jdiAssert(element().defaultColor(), Matchers.is(true),
                  "Element doesn't have default color.");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has visual type '{0}'", isAssert = true)
    public ButtonAssert visualType(ButtonsTypes expectedType) {
        ButtonsTypes actualVisualType = element().visualType();
        jdiAssert(actualVisualType.getType(), Matchers.is(expectedType.getType()));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public ButtonAssert hasIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(true),
                  "Element doesn't have icon inside");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has link", isAssert = true)
    public ButtonAssert hasLink() {
        jdiAssert(element().hasLink(), Matchers.is(true), "Element doesn't have link inside");
        return this;
    }

    @JDIAction("Assert that '{name}' ref {0}")
    public ButtonAssert ref(Matcher<String> condition) {
        jdiAssert(element().ref(), condition);
        return this;
    }
}
