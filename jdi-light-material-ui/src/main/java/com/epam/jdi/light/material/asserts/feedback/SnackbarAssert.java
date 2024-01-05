package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.PositionAssert;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.material.elements.utils.enums.MessageType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Snackbar}.
 */
public class SnackbarAssert extends PositionAssert<SnackbarAssert, Snackbar> implements ITextAssert<SnackbarAssert> {

    /**
     * Checks that snackbar current text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link SnackbarAssert} instance
     */
    @Override
    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public SnackbarAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    /**
     * Checks that snackbar message is of the given type.
     *
     * @param type expected message type
     * @return this {@link SnackbarAssert} instance
     */
    @JDIAction(value = "Assert that the '{name}' message type is '{0}'", isAssert = true)
    public SnackbarAssert messageType(MessageType type) {
        jdiAssert(element().messageType(), Matchers.is(type));
        return this;
    }
}
