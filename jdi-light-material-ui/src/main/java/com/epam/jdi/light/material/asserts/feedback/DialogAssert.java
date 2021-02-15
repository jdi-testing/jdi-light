package com.epam.jdi.light.material.asserts.feedback;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import org.hamcrest.Matchers;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    @JDIAction("Assert that dialog title text is correct")
    public DialogAssert dialogTitleTextCorrect(String title) {
        jdiAssert(title.equals(element().getDialogTitle()), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that dialog title text is correct")
    public DialogAssert dialogTitleTextDisplayed(String title) {
        jdiAssert(element().getDialogTitle(), Matchers.is(true));
        return this;
    }

}
