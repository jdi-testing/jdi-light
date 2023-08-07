package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors;
import com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonAssert extends UIAssert<ButtonAssert, Button> {

    @JDIAction("Assert that '{name}' has text '{0}'")
    public ButtonAssert text(String expectedText) {
        String actualText = element().text();
        jdiAssert(actualText, Matchers.is(expectedText),
            String.format("Actual element's text '%s'" +
                "is not equal to expected '%s'", actualText, expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public ButtonAssert focused() {
        boolean actualFocused = element().focused();
        jdiAssert(actualFocused, Matchers.is(true),
            String.format("Element is not focused. Actual result '%b' " +
                "is not equal to expected '%b'", actualFocused, true));
        return this;
    }

    @JDIAction("Assert that label of '{name}' of type '{0}' has text '{1}'")
    public ButtonAssert buttonLabelText(ButtonsTypes buttonType, String expectedText) {
        String actualText = element().buttonLabelText(buttonType);
        jdiAssert(actualText, Matchers.containsString(expectedText),
            String.format("Actual element's label text '%s'" +
                "is not equal to expected '%s'", actualText, expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public ButtonAssert color(ButtonsColors expectedColor) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.is(expectedColor.getColor()),
            String.format("Actual element's color '%s'" +
                "is not equal to expected '%s'", actualColor, expectedColor.getColor()));
        return this;
    }

    @JDIAction("Assert that '{name}' has default color")
    public ButtonAssert defaultColor() {
        boolean actualDefaultColor = element().defaultColor();
        jdiAssert(actualDefaultColor, Matchers.is(true),
            String.format("Element doesn't have default color. Actual result '%b' " +
                "is not equal to expected '%b'", actualDefaultColor, true));
        return this;
    }

    @JDIAction("Assert that '{name}' has visual type '{0}'")
    public ButtonAssert visualTypeOfButton(ButtonsTypes expectedType) {
        String actualVisualType = element().visualTypeOfButton();
        jdiAssert(actualVisualType, Matchers.is(expectedType.getType()),
            String.format("Actual element's visual type '%s'" +
                "is not equal to expected '%s'", actualVisualType, expectedType.getType()));
        return this;
    }
}
