package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Transition;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Assertions for {@link Transition}
 */
public class TransitionAssert extends UIAssert<TransitionAssert, Transition> {

    /**
     * Checks that transition is entered.
     *
     * @return this {@link TransitionAssert} instance
     */
    @JDIAction("Assert that '{name}' is entered")
    public TransitionAssert entered() {
        jdiAssert(waitCondition(() -> element().isEntered()) ? "is entered" : "is not entered",
            Matchers.is("is entered"));
        return this;
    }

    /**
     * Checks that transition is exited.
     *
     * @return this {@link TransitionAssert} instance
     */
    @JDIAction("Assert that '{name}' is exited")
    public TransitionAssert exited() {
        jdiAssert(waitCondition(() -> element().isExited()) ? "is exited" : "is not exited",
            Matchers.is("is exited"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public TransitionAssert hidden() {
        jdiAssert(waitCondition(() -> element().isHidden()) ? "is hidden" : "is displayed",
            Matchers.is("is hidden"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public TransitionAssert displayed() {
        jdiAssert(waitCondition(() -> element().isDisplayed()) ? "is displayed" : "is hidden",
            Matchers.is("is displayed"));
        return this;
    }
}
