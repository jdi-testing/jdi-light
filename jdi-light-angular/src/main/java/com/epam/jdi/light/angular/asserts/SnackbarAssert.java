package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Snackbar;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    @JDIAction(value = "Assert that '{name}' has message '{0}'", isAssert = true)
    public SnackbarAssert message(String expected) {
        jdiAssert(element().messageText(), Matchers.containsString(expected));
        return this;
    }
}
