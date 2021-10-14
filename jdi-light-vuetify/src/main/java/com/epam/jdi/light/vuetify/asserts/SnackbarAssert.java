package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Snackbar;
import org.hamcrest.Matchers;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar> {

    @Override
    public SnackbarAssert and() {
        return super.and();
    }

    @JDIAction("Assert that {name} is visible")
    public SnackbarAssert visible() {
        jdiAssert(element().isOpen(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public SnackbarAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public SnackbarAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} on the left position")
    public SnackbarAssert left() {
        jdiAssert(element().isLeft(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} on the right position")
    public SnackbarAssert right() {
        jdiAssert(element().isRight(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is centered")
    public SnackbarAssert centered() {
        jdiAssert(element().isCentered(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is vertical")
    public SnackbarAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }
}
