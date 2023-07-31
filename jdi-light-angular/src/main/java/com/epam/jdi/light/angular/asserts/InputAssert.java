package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class InputAssert extends UIAssert<InputAssert, Input> {

    @JDIAction("Assert that '{name}' has typed text '{0}' in input field")
    public InputAssert typedText(String text) {
        String actualTypedText = element().getTypedText();
        jdiAssert(actualTypedText, Matchers.containsString(text), String.format("Actual typed text '%s' is not equal to " +
            "expected '%s'", actualTypedText, text));
        return this;
    }
}
