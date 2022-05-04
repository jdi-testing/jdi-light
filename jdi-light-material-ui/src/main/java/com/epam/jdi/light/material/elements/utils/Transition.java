package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.TransitionAssert;

/**
 * Represent transition MUI component on GUI. Transitions can be used to introduce some basic motion to applications.
 * There are different types of transitions. Transition 'Collapse' is different from other transitions because there is
 * a separate class "MuiCollapse" for it.
 *
 * @see <a href="https://mui.com/components/transitions/">Transition MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Transition extends UIBaseElement<TransitionAssert> {

    /**
     * Checks if the transition is entered or not.
     *
     * @return {@code true} if the transition is entered, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is entered")
    public boolean isEntered() {
        return core().isDisplayed() || core().hasClass("MuiCollapse-entered");
    }

    /**
     * Checks if the transition is exited or not.
     *
     * @return {@code true} if the transition is exited, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is exited")
    public boolean isExited() {
        return core().isHidden() || !core().hasClass("MuiCollapse-entered");
    }

    @Override
    @JDIAction("Check that '{name}' is hidden")
    public boolean isHidden() {
        return core().isHidden() || core().hasClass("MuiCollapse-hidden");
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return !isHidden();
    }

    @Override
    public TransitionAssert is() {
        return new TransitionAssert().set(this);
    }
}
