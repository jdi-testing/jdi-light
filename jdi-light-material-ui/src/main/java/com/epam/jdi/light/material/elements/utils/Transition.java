package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.TransitionAssert;

/**
 * To see an example of Transitions web element please visit
 * https://mui.com/components/transitions/
 */

public class Transition extends UIBaseElement<TransitionAssert> {

    @JDIAction("Is '{0}' transition entered")
    public boolean isCollapseTransitionEntered(String type) {
        return core().hasClass("MuiCollapse-entered");
    }

    @JDIAction("Is '{0}' transition hidden")
    public boolean isCollapseTransitionHidden(String type) {
        return core().hasClass("MuiCollapse-hidden");
    }

    @JDIAction("Is '{0}' transition entered")
    public boolean isCommonTransitionEntered(String type) {
        return core().isDisplayed();
    }

    @JDIAction("Is '{0}' transition exited")
    public boolean isCommonTransitionExited(String type) {
        return core().isHidden();
    }

    @Override
    public TransitionAssert is() {
        return new TransitionAssert().set(this);
    }
}
