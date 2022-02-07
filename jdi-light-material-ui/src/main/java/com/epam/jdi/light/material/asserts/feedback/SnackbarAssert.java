package com.epam.jdi.light.material.asserts.feedback;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import org.hamcrest.Matchers;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    @JDIAction("Assert that {name} has {0}")
    public SnackbarAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that the {name} message has {0} type")
    public SnackbarAssert messageType(String type) {
        String success = "message has " + type + " type";
        jdiAssert(element().messageType(type) ? success : "incorrect type", Matchers.is(success));
        return this;
    }

    @JDIAction("Assert that {name} has {0} position")
    public SnackbarAssert position(String type) {
        String success = "has " + type + " type";
        jdiAssert(element().hasPosition(type) ? success : "incorrect type", Matchers.is(success));
        return this;
    }
}
