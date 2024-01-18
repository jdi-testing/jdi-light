package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Transition;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Transition}
 */
public class TransitionAssert extends UIAssert<TransitionAssert, Transition> {

    /**
     * Checks that transition is entered.
     *
     * @return this {@link TransitionAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is entered", isAssert = true)
    public TransitionAssert entered() {
        jdiAssert(element().isEntered(), Matchers.is(true),
                "Transition is not entered");
        return this;
    }

    /**
     * Checks that transition is exited.
     *
     * @return this {@link TransitionAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is exited", isAssert = true)
    public TransitionAssert exited() {
        jdiAssert(element().isExited(), Matchers.is(true),
                "Transition is not exited");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is hidden", isAssert = true)
    public TransitionAssert hidden() {
        jdiAssert(element().isHidden(), Matchers.is(true),
                "Transition is visible");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public TransitionAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true),
                "Transition is hidden");
        return this;
    }
}
