package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Paper;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Paper}.
 */
public class PaperAssert extends UIAssert<PaperAssert, Paper> {

    /**
     * Checks that paper is rounded.
     *
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' is rounded")
    public PaperAssert rounded() {
        jdiAssert(element().core().classes().toString(),
                Matchers.containsString("MuiPaper-rounded"));
        return this;
    }

    /**
     * Checks that paper is square.
     *
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' is square")
    public PaperAssert square() {
        jdiAssert(element().core().classes().toString(),
                Matchers.not(Matchers.containsString("MuiPaper-rounded")));
        return this;
    }

    /**
     * Checks that paper has the expected elevation.
     *
     * @param expectedElevation expected elevation
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' has elevation {0}")
    public PaperAssert elevation(int expectedElevation) {
        jdiAssert(element().core().classes().toString(),
                Matchers.containsString("MuiPaper-elevation" + expectedElevation));
        return this;
    }

    /**
     * Checks that paper is outlined.
     *
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' is outlined")
    public PaperAssert outlined() {
        jdiAssert(element().core().classes().toString(),
                Matchers.containsString("MuiPaper-outlined"));
        return this;
    }
}
