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
    @JDIAction(value = "Assert that '{name}' is linear buffer", isAssert = true)
    public LinearProgressAssert buffer() {
        jdiAssert(element().isBuffer(), Matchers.is(true), "Progress is not buffer");
        return this;
    }
}
