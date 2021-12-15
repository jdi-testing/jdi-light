package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    @JDIAction("Assert that '{name}' has value '{0}'")
    public DialogAssert itemText(int index, String text) {
        jdiAssert(element().getItemText(index), Matchers.is(text));
        return this;
    }
}
