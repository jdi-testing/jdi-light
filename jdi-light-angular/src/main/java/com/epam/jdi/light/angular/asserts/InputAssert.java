package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.enums.InputsTypes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class InputAssert extends UIAssert<InputAssert, Input> {

    @JDIAction("Assert that '{name}' has typed text '{0}' in input field")
    public InputAssert typedText(String text) {
        jdiAssert(element().typedText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("")
    public InputAssert readonly() {
        jdiAssert(element().readonly(), Matchers.is(true));
        return this;
    }

    @JDIAction("")
    public InputAssert inputType(InputsTypes inputType) {
        jdiAssert(element().inputType(), Matchers.is(inputType));
        return this;
    }

    @JDIAction("")
    public InputAssert placeholder(String placeholder) {
        jdiAssert(element().placeholder(), Matchers.containsString(placeholder));
        return this;
    }

    @JDIAction("")
    public InputAssert value(String value) {
        jdiAssert(element().getValue(), Matchers.containsString(value));
        return this;
    }

    @JDIAction("")
    public InputAssert label(String labelText) {
        jdiAssert(element().labelText(), Matchers.containsString(labelText));
        return this;
    }

    @JDIAction("")
    public InputAssert autoSize(){
        jdiAssert(element().hasAutoSize(), Matchers.is(true));
        return this;
    }
}
