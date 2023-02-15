package com.epam.jdi.light.vuetify.asserts.window;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.window.Window;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

public class WindowAssert  extends UIAssert<WindowAssert, Window> implements
    ThemeAssert<WindowAssert, Window> {

    @JDIAction("Assert that '{name}' shows arrows on hover")
    public WindowAssert showArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(true), "Element doesn't show arrows on hover");
        return this;
    }

    @JDIAction("Assert that '{name}' doesn't show arrows on hover")
    public WindowAssert notShowArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(false), "Element shows arrows on hover");
        return this;
    }

    @JDIAction("Assert that '{name}' has next button")
    public WindowAssert previousButton() {
        jdiAssert(element().previousButtonExists(), Matchers.is(true), "Element's previous " +
            "button doesn't exist");
        return this;
    }

    @JDIAction("Assert that '{name}' has no previous button")
    public WindowAssert noPreviousButton() {
        jdiAssert(element().previousButtonExists(), Matchers.is(false), "Element's previous " +
            "button exists");
        return this;
    }

    @JDIAction("Assert that '{name}' has next button")
    public WindowAssert nextButton() {
        jdiAssert(element().nextButtonExists(), Matchers.is(true), "Element's next " +
            "button doesn't exist");
        return this;
    }

    @JDIAction("Assert that '{name}' has no next button")
    public WindowAssert noNextButton() {
        jdiAssert(element().nextButtonExists(), Matchers.is(false), "Element's next " +
            "button exists");
        return this;
    }

}
