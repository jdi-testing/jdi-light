package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Dialog;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    @JDIAction("Verify that dialog text opened")
    public DialogAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Verify that dialog text closed")
    public DialogAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Verify '{name}' text is exist")
    public DialogAssert nameText(String name) {
        jdiAssert(element().nameText(name), Matchers.is(true));
        return this;
    }

    @JDIAction("Verify '{name}' answer text is exist")
    public DialogAssert answerText(String answer) {
        jdiAssert(element().answerText(answer), Matchers.is(true));
        return this;
    }
}
