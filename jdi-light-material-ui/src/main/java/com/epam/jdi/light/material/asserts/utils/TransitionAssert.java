package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Transition;
import com.epam.jdi.light.material.elements.utils.enums.TransitionType;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

public class TransitionAssert extends UIAssert<TransitionAssert, Transition> {

    /**
     * There are five transition types: COLLAPSE, FADE, GROW, SLIDE, ZOOM
     */
    @JDIAction("Assert that '{name}' transition '{0}' is entered")
    public TransitionAssert transitionEntered(TransitionType type) {
        switch (type) {
        case COLLAPSE:
            jdiAssert(waitCondition(() -> element().isCollapseTransitionEntered()) ? "collapse transition entered" : "collapse transition didn't enter",
                Matchers.is("collapse transition entered"));
            break;
        case FADE:
        case GROW:
        case SLIDE:
        case ZOOM:
            jdiAssert(waitCondition(() -> element().isCommonTransitionEntered()) ? "common transition entered" : "common transition didn't enter",
                Matchers.is("common transition entered"));
            break;
        default:
            break;
        }
        return this;
    }

    /**
     * There are five transition types: COLLAPSE, FADE, GROW, SLIDE, ZOOM
     */
    @JDIAction("Assert that '{name}' transition '{0}' is exited")
    public TransitionAssert transitionExited(TransitionType type) {
        switch (type) {
        case COLLAPSE:
            jdiAssert(waitCondition(() -> element().isCollapseTransitionExited()) ? "collapse transition exited" : "collapse transition didn't exit",
                Matchers.is("collapse transition exited"));
            break;
        case FADE:
        case GROW:
        case SLIDE:
        case ZOOM:
            jdiAssert(waitCondition(() -> element().isCommonTransitionExited()) ? "common transition exited" : "common transition didn't exit",
                Matchers.is("common transition exited"));
            break;
        default:
            break;
        }
        return this;
    }

    /**
     * There are five transition types: COLLAPSE, FADE, GROW, SLIDE, ZOOM
     */
    @JDIAction("Assert that '{name}' transition '{0}' is hidden")
    public TransitionAssert collapseTransitionHidden() {
        jdiAssert(waitCondition(() -> element().isCollapseTransitionHidden()) ? "collapse transition is hidden" : "collapse transition isn't hidden",
            Matchers.is("collapse transition is hidden"));
        return this;
    }
}
