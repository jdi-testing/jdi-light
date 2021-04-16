package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    // This method used by other tests. Can be deleted in future
    @JDIAction("Assert that '{name}' is visible")
    public SnackbarAssert visible() {
        jdiAssert(element().isVisible(), Matchers.is(true));
        return this;
    }
}
