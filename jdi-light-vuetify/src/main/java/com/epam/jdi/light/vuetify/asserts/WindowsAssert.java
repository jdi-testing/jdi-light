package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Windows;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class WindowsAssert extends UIAssert<WindowsAssert, Windows> implements ThemeAssert<WindowsAssert, Windows> {
    @JDIAction(value = "Assert that '{name}' shows arrows on hover", isAssert = true)
    public WindowsAssert showArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(true), "Element doesn't show arrows on hover");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' doesn't show arrows on hover", isAssert = true)
    public WindowsAssert notShowArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(false), "Element shows arrows on hover");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no next actions button", isAssert = true)
    public WindowsAssert noNextActionsButton() {
        jdiAssert(element().nextButton().isNotExist(), Matchers.is(false), "Element's next actions " +
                "button exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has previous button", isAssert = true)
    public WindowsAssert previousButton() {
        jdiAssert(element().previousButton().isExist(), Matchers.is(true), "Element's previous " +
                "button doesn't exist");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no previous button", isAssert = true)
    public WindowsAssert noPreviousButton() {
        jdiAssert(element().previousButton().isExist(), Matchers.is(false), "Element's previous " +
                "button exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has next button", isAssert = true)
    public WindowsAssert nextButton() {
        jdiAssert(element().nextButton().isExist(), Matchers.is(true), "Element's next " +
                "button doesn't exist");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no next button", isAssert = true)
    public WindowsAssert noNextButton() {
        jdiAssert(element().nextButton().isExist(), Matchers.is(false), "Element's next " +
                "button exists");
        return this;
    }
}
