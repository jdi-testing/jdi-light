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
        jdiAssert(element().isRounded(), Matchers.is(true), "Paper is not rounded");
        return this;
    }

    /**
     * Checks that paper is not rounded.
     *
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' is not rounded")
    public PaperAssert notRounded() {
        jdiAssert(element().isRounded(), Matchers.is(false), "Paper is rounded");
        return this;
    }

    /**
     * Checks that paper is outlined.
     *
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' is outlined")
    public PaperAssert outlined() {
        jdiAssert(element().isOutlined(), Matchers.is(true), "Paper is not outlined");
        return this;
    }

    /**
     * Checks that paper is not outlined.
     *
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' is not outlined")
    public PaperAssert notOutlined() {
        jdiAssert(element().isOutlined(), Matchers.is(false), "Paper is outlined");
        return this;
    }

    /**
     * Checks that paper has the given elevation.
     *
     * @param expectedElevation expected elevation
     * @return this {@link PaperAssert} instance
     */
    @JDIAction("Assert that '{name}' has elevation {0}")
    public PaperAssert elevation(int expectedElevation) {
        jdiAssert(element().elevation(), Matchers.is(expectedElevation));
        return this;
    }

}
