package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Paper;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaperAssert extends UIAssert<PaperAssert, Paper> {

    @JDIAction("Assert that '{name}' text equals '{0}'")
    public PaperAssert textEquals(final String expectedText) {
        jdiAssert(element().getText().equals(expectedText), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text equals '{0}' (ignore case)")
    public PaperAssert textEqualsIgnoreCase(final String expectedText) {
        jdiAssert(element().getText().equalsIgnoreCase(expectedText), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text contains '{0}'")
    public PaperAssert textContains(final String expectedSubstring) {
        jdiAssert(element().getText().contains(expectedSubstring), Matchers.is(true));
        return this;
    }
}
