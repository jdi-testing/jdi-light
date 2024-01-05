package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {
    @JDIAction(value = "Assert that '{name}' is opened", isAssert = true)
    public DialogAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' closed", isAssert = true)
    public DialogAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' name is {0}", isAssert = true)
    public DialogAssert nameText(String name) {
        jdiAssert(element().nameText(name), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' answer is {0}", isAssert = true)
    public DialogAssert answerText(String answer) {
        jdiAssert(element().answerText(answer), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
