package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonToggleAssert extends UIAssert<ButtonToggleAssert, ButtonToggle> {

    @JDIAction(value = "Assert that '{name}' has '{0}' class", isAssert = true)
    public ButtonToggleAssert assertButtonToggleIsSelected(String value) {
        jdiAssert(element().isButtonToggleSelected(value), Matchers.is(true),
            "Button toggle element is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' class", isAssert = true)
    public ButtonToggleAssert assertButtonToggleIsNotSelected(String value) {
        jdiAssert(element().isButtonToggleSelected(value), Matchers.is(false),
            "Button toggle element is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has attr '{0}'", isAssert = true)
    public ButtonToggleAssert assertButtonToggleButtonIsPressed(String value) {
        jdiAssert(element().isButtonToggleButtonPressed(value), Matchers.is(true),
            "Button toggle element is not pressed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' with value '{0}' has text '{1}'", isAssert = true)
    public ButtonToggleAssert assertButtonToggleButtonHasText(String value, String text) {
        jdiAssert(element().buttonToggleHasText(value, text), Matchers.is(true),
            "Button toggle element text is not equal " + text);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has value '{0}'", isAssert = true)
    public ButtonToggleAssert assertButtonToggleHasValue(String value) {
        jdiAssert(element().buttonToggleHasValue(value), Matchers.is(true),
            "Button toggle element value is not equal " + value);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' with value '{0}' has aria-label '{1}'", isAssert = true)
    public ButtonToggleAssert assertButtonToggleHasAriaLabel(String value, String ariaLabel) {
        jdiAssert(element().buttonToggleHasAriaLabel(value, ariaLabel), Matchers.is(true),
            "Button toggle aria-label is not equal " + ariaLabel);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has attr legacy appearance", isAssert = true)
    public ButtonToggleAssert assertButtonToggleHasLegacyAppearance() {
        jdiAssert(element().buttonToggleHasLegacyAppearance(), Matchers.is(true),
            "Button toggle appearance is not legacy");
        return this;
    }

    @JDIAction(value = "Assert that '{name} is disabled'", isAssert = true)
    public ButtonToggleAssert assertButtonToggleIsDisabled() {
        jdiAssert(element().buttonToggleDisabled(), Matchers.is(true),
            "Button toggle is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' in button-toggle is disabled", isAssert = true)
    public ButtonToggleAssert assertButtonInButtonToggleIsDisabled(String value) {
        jdiAssert(element().isButtonToggleDisabled(value), Matchers.is(true),
            "Button toggle element is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is vertical", isAssert = true)
    public ButtonToggleAssert assertButtonToggleVertical() {
        jdiAssert(element().buttonToggleVertical(), Matchers.is(true),
            "Button toggle is horizontal");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has ripple effect", isAssert = true)
    public ButtonToggleAssert assertButtonToggleWithRipple(String value) {
        jdiAssert(element().buttonToggleHasNoRippleEffect(value), Matchers.is(false),
            "Button toggle element does not have ripple effect");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no ripple effect", isAssert = true)
    public ButtonToggleAssert assertButtonToggleNoRipple(String value) {
        jdiAssert(element().buttonToggleHasNoRippleEffect(value), Matchers.is(true),
            "Button toggle element has ripple effect");
        return this;
    }
}
