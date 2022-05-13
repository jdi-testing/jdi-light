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
