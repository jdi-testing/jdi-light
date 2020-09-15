package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.asserts.generic.UIAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {
    public DialogAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true));
        return this;
    }

    public DialogAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    public DialogAssert nameText(String name) {
        jdiAssert(element().nameText(name), Matchers.is(true));
        return this;
    }

    public DialogAssert answerText(String answer) {
        jdiAssert(element().answerText(answer), Matchers.is(true));
        return this;
    }
}
