package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Snackbar}
 */
public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> implements ITextAssert<SnackbarAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public SnackbarAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }


    /**
     * Checks that message has given type.
     *
     * @param type expected message type
     * @return this {@link SnackbarAssert} instance
     */
    @JDIAction("Assert that the {name} message has '{0}' type")
    public SnackbarAssert messageType(String type) {
        String success = "message has " + type + " type";
        jdiAssert(element().messageType(type) ? success : "incorrect type", Matchers.is(success));
        return this;
    }

    /**
     * Checks that snackbar has given position.
     *
     * @param type expected snackbar position
     * @return this {@link SnackbarAssert} instance
     */
    @JDIAction("Assert that {name} has position '{0}'")
    public SnackbarAssert position(Position type) {
        String success = "has " + type + " type";
        jdiAssert(element().hasPosition(type) ? success : "incorrect type", Matchers.is(success));
        return this;
    }
}
