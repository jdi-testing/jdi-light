package com.epam.jdi.light.material.asserts.feedback;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import org.hamcrest.Matchers;

public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    @JDIAction("Assert that dialog is displayed")
    public DialogAssert dialogDisplayed() {
        jdiAssert(element().isDialogDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that dialog title text is correct")
    public DialogAssert titleDisplayed(String title) {
        jdiAssert(element().isTitleCorrect(title), Matchers.is(true));
        return this;
    }

}
