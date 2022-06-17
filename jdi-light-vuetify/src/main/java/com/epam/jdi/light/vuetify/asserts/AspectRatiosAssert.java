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
     * Checks that AspectRatios of element equal the given ratio.
     *
     * @param width  width ratio to check (ex: 16:9 has width 16)
     * @param height height ratio to check (ex: 16:9 has height 9)
     * @return this {@link AspectRatiosAssert} instance
     */
    @JDIAction("Assert that '{name}' has ratio {0}:{1}")
    public AspectRatiosAssert ratio(double width, double height) {
        double epsilon = 0.2d;
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(epsilon, Matchers.greaterThan(Math.abs(
                element().ratioValue(element().getSize().getWidth(), element().getSize().getHeight()) -
                        element().ratioValue(width, height)
        )));
        return this;
    }

}
