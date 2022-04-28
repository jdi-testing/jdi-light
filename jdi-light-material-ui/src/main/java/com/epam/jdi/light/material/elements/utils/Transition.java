package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.TransitionAssert;

/**
 * To see an example of Transitions web element please visit
 * https://mui.com/components/transitions/
 */
public class Transition extends UIBaseElement<TransitionAssert> {

    @JDIAction("Check that collapse transition is entered")
    public boolean isCollapseTransitionEntered() {
        return core().hasClass("MuiCollapse-entered");
    }

    @JDIAction("Check that collapse transition is exited")
    public boolean isCollapseTransitionExited() {
        return !isCollapseTransitionEntered();
    }

    @JDIAction("Check that collapse transition is hidden")
    public boolean isCollapseTransitionHidden() {
        return core().hasClass("MuiCollapse-hidden");
    }

    @JDIAction("Check that common transition is entered")
    public boolean isCommonTransitionEntered() {
        return core().isDisplayed();
    }

    @JDIAction("Check that common transition is exited")
    public boolean isCommonTransitionExited() {
        return core().isHidden();
    }

    @Override
    public TransitionAssert is() {
        return new TransitionAssert().set(this);
    }
}
