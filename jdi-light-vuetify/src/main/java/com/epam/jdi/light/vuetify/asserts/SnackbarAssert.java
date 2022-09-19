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

    @JDIAction("Assert that {name} is top")
    public SnackbarAssert top() {
        jdiAssert(element().isTop(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is bottom")
    public SnackbarAssert bottom() {
        jdiAssert(element().isBottom(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is vertical")
    public SnackbarAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is multi-line")
    public SnackbarAssert multiLine() {
        jdiAssert(element().isMultiLine(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is shaped")
    public SnackbarAssert shaped() {
        jdiAssert(element().isShaped(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is rounded")
    public SnackbarAssert rounded() {
        jdiAssert(element().isRounded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is elevated")
    public SnackbarAssert elevated() {
        jdiAssert(element().isElevated(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is tile")
    public SnackbarAssert tile() {
        jdiAssert(element().isRounded(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} is text")
    public SnackbarAssert text() {
        jdiAssert(element().isText(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is outlined")
    public SnackbarAssert outlined() {
        jdiAssert(element().isOutlined(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is light")
    public SnackbarAssert lightTheme() {
        jdiAssert(element().isLightTheme(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    public SnackbarAssert darkTheme() {
        jdiAssert(element().isDarkTheme(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public SnackbarAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' height is '{0}'")
    public SnackbarAssert height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    public SnackbarAssert width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return this;
    }
}
