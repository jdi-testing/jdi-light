package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.enums.InputsTypes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class InputAssert extends UIAssert<InputAssert, Input> {

    @JDIAction("Assert that '{name}' has typed text '{0}' in input field")
    public InputAssert value(String text) {
        jdiAssert(element().getValue(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is readonly")
    public InputAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' is not readonly")
    public InputAssert notReadonly() {
        jdiAssert(element().isReadonly(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has type '{0}'")
    public InputAssert inputType(InputsTypes inputType) {
        jdiAssert(element().inputType(), Matchers.is(inputType));
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder '{0}'")
    public InputAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.containsString(placeholder));
        return this;
    }

    @JDIAction("Assert that '{name}' is focused")
    public InputAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' is not focused")
    public InputAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert that '{name}' has aria-label '{0}'")
    public InputAssert ariaLabel(String ariaLabel) {
        jdiAssert(element().hasAriaLabel(ariaLabel), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
