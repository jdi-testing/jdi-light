package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Snackbar;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    @JDIAction("Assert that '{name}' has message '{0}'")
    public SnackbarAssert message(String expected) {
        jdiAssert(element().getMessageText(), Matchers.is(expected));
        return this;
    }

    @JDIAction("Assert that '{name}' has no action")
    public SnackbarAssert action() {
        jdiAssert(element().isActionDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has action {0}")
    public SnackbarAssert action(String expected) {
        jdiAssert(element().getActionText(), Matchers.is(expected));
        return this;
    }
}
