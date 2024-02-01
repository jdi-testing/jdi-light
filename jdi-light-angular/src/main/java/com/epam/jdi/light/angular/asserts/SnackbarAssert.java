package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Snackbar;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    @JDIAction(value = "Assert that '{name}' has message '{0}'", isAssert = true)
    public SnackbarAssert message(String expected) {
        jdiAssert(element().messageText(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no action", isAssert = true)
    public SnackbarAssert noAction() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "No snackbar element found");
        jdiAssert(element().isActionDisplayed(), Matchers.is(false), "Action button should be absent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has action {0}", isAssert = true)
    public SnackbarAssert action(String expected) {
        jdiAssert(element().actionText(), Matchers.is(expected));
        return this;
    }
}
