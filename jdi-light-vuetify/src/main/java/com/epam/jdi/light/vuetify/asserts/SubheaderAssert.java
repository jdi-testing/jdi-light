package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SubheaderAssert extends UIAssert<SubheaderAssert, Subheader>
        implements ThemeAssert<SubheaderAssert, Subheader> {

    @JDIAction(value = "Assert that '{name}' text is '{0}'")
    public SubheaderAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is displayed")
    public SubheaderAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true),
                "Subheader is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is inset")
    public SubheaderAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Subheader is not inset");
        return this;
    }
}
