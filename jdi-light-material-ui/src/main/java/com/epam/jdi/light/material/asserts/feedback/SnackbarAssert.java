package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    @JDIAction("Assert that '{name}' content is '{0}'")
    public SnackbarAssert content(String text) {
        jdiAssert(element().getMessageContent(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is visible")
    public SnackbarAssert visible() {
        jdiAssert(element().isVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not exist")
    public SnackbarAssert notExist() {
        jdiAssert(element().isExist(), Matchers.is(false));
        return this;
    }

}
