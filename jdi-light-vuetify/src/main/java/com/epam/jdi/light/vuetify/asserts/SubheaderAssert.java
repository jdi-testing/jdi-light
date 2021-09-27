package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SubheaderAssert extends UIAssert<SubheaderAssert, Subheader> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public SubheaderAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public SubheaderAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is inset")
    public SubheaderAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is light")
    public SubheaderAssert lightTheme() {
        jdiAssert(element().themeIsLight(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is dark")
    public SubheaderAssert darkTheme() {
        jdiAssert(element().themeIsDark(), Matchers.is(true));
        return this;
    }
}
