package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Dialog}
 */
public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    private final Timer timer = new Timer(5000L, 500L);

    /**
     * Checks that dialog has scrollable content.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has scrollable content", isAssert = true)
    public DialogAssert scrollableContent() {
        timer.wait(() -> element().isDisplayed());
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
        timer.wait(() -> element().isDisplayed());
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
        timer.wait(() -> element().isNotVisible());
        jdiAssert(element().isHidden(), Matchers.is(true), "Dialog is not hidden");
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
        timer.wait(() -> element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Dialog is not displayed");
        return this;
    }
}
