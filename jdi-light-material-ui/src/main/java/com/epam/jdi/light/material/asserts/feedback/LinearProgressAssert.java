package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link LinearProgress}
 */
public class LinearProgressAssert extends ProgressAssert<LinearProgressAssert, LinearProgress> {

    /**
     * Checks that the first progress bar has given color.
     *
     * @return this {@link LinearProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' first bar has color '{0}'")
    public LinearProgressAssert firstBarColor(String firstBarColor) {
        jdiAssert(element().firstBarColor(), Matchers.is(firstBarColor));
        return this;
    }

    /**
     * Checks that the second progress bar has given color.
     *
     * @return this {@link LinearProgressAssert} instance
     */
    @JDIAction("Assert that '{name}' second bar has color '{0}'")
    public LinearProgressAssert secondBarColor(String secondBarColor) {
        jdiAssert(element().secondBarColor(), Matchers.is(secondBarColor));
        return this;
    }

    /**
     * Checks that the progress is linear buffer.
     *
     * @return this {@link LinearProgressAssert} instance
     * @see <a href='https://mui.com/components/progress/#linear-buffer'>Linear buffer MUI documentation</a>
     */
    @JDIAction("Assert that '{name}' is linear buffer")
    public LinearProgressAssert buffer() {
        jdiAssert(element().isBuffer() ? "is buffer" : "is not buffer",
            Matchers.is("is buffer"));
        return this;
    }
}
