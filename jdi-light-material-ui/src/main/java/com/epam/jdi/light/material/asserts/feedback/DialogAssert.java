package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Dialog}
 */
public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    /**
     * Checks that dialog has scrollable content.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has scrollable content", isAssert = true)
    public DialogAssert scrollableContent() {
        jdiAssert(element().hasScrollableContent(), Matchers.is(true), "Dialog has no scrollable content");
        return this;
    }

    /**
     * Checks that dialog has scrollable body.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has scrollable body", isAssert = true)
    public DialogAssert scrollableBody() {
        jdiAssert(element().hasScrollableBody(), Matchers.is(true), "Dialog has no scrollable body");
        return this;
    }

    /**
     * Checks that dialog is not displayed.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is hidden", isAssert = true)
    @Override
    public DialogAssert hidden() {
        jdiAssert(element().isDisplayed(), Matchers.is(false), "Dialog is displayed");
        return this;
    }

    /**
     * Checks that dialog is displayed.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    @Override
    public DialogAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Dialog is not displayed");
        return this;
    }

    public DialogAssert title() {
        jdiAssert(element().title().isExist(), Matchers.is(true), "Dialog title is not exist");
        return this;
    }

    public DialogAssert title(Matcher<String> matcher) {
        jdiAssert(element().title().text(), matcher);
        return this;
    }

    public DialogAssert content() {
        jdiAssert(element().content().isExist(), Matchers.is(true), "Dialog content is not exist");
        return this;
    }

    public DialogAssert actions() {
        jdiAssert(element().actionButtons().isExist(), Matchers.is(true), "Dialog actions is not exist");
        return this;
    }

    public DialogAssert noActions() {
        jdiAssert(element().actionButtons().isExist(), Matchers.is(false), "Dialog actions is exist");
        return this;
    }
}
