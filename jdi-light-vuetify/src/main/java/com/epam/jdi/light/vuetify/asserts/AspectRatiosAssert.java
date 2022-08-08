package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.AspectRatios;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Asserts for {@link AspectRatios}
 */
public class AspectRatiosAssert extends UIAssert<AspectRatiosAssert, AspectRatios> {

    /**
     * Checks that AspectRatios of element equal 16:9 ratio.
     * <p>
     * epsilon: allowable difference between 16:9 and aspect ratio of element
     * Matchers.greaterThanOrEqualTo: compare epsilon with subtraction of element's ratio and 16:9
     *
     * @return this {@link AspectRatiosAssert} instance
     */
    @JDIAction("Assert that '{name}' has ratio 16:9")
    public AspectRatiosAssert ratio() {
        double epsilon = 0.01d;
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(epsilon, Matchers.greaterThanOrEqualTo(Math.abs(
                AspectRatios.ratioValue(element().getSize().getWidth(), element().getSize().getHeight()) -
                        AspectRatios.ratioValue(16, 9)
        )));
        return this;
    }

}