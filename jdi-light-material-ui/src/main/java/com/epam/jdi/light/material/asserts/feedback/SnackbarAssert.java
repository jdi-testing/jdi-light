package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.material.elements.utils.enums.MessageType;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> implements ITextAssert<SnackbarAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public SnackbarAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @JDIAction("Assert that the '{name}' message type is '{0}'")
    public SnackbarAssert messageType(MessageType type) {
        jdiAssert(element().messageType(), Matchers.is(type));
        return this;
    }

    @JDIAction("Assert that '{name}' position is '{0}'")
    public SnackbarAssert position(Position position) {
        jdiAssert(element().position(), Matchers.is(position));
        return this;
    }
}
