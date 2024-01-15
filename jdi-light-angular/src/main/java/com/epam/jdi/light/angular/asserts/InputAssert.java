package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.enums.InputsTypes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class InputAssert extends UIAssert<InputAssert, Input> {

    @JDIAction(value = "Assert that '{name}' has typed text '{0}' in input field", isAssert = true)
    public InputAssert value(String text) {
        jdiAssert(element().getValue(), Matchers.containsString(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is readonly", isAssert = true)
    public InputAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not readonly", isAssert = true)
    public InputAssert notReadonly() {
        jdiAssert(element().isReadonly(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has type '{0}'", isAssert = true)
    public InputAssert inputType(InputsTypes inputType) {
        jdiAssert(element().inputType(), Matchers.is(inputType));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder '{0}'", isAssert = true)
    public InputAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.containsString(placeholder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is focused", isAssert = true)
    public InputAssert focused() {
        jdiAssert(element().isFocused(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not focused", isAssert = true)
    public InputAssert notFocused() {
        jdiAssert(element().isFocused(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has aria-label '{0}'", isAssert = true)
    public InputAssert ariaLabel(String ariaLabel) {
        jdiAssert(element().hasAriaLabel(ariaLabel), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
