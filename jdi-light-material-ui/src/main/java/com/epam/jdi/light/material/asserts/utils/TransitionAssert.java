package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Transition;
import com.epam.jdi.light.material.elements.utils.enums.TransitionType;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TransitionAssert extends UIAssert<TransitionAssert, Transition> {

    /**
     * There are five transition types: COLLAPSE, FADE, GROW, SLIDE, ZOOM
     */
    @JDIAction("Assert that transition entered")
    public TransitionAssert transitionEntered(TransitionType type) {
        switch (type)
        {
            case COLLAPSE:
            case FADE:
                jdiAssert(element().isCollapseTransitionEntered(type.getType()), Matchers.is(true));
                break;
            case GROW:
            case SLIDE:
            case ZOOM:
                jdiAssert(element().isCommonTransitionEntered(type.getType()), Matchers.is(true));
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * There are five transition types: COLLAPSE, FADE, GROW, SLIDE, ZOOM
     */
    @JDIAction("Assert that transition exited")
    public TransitionAssert transitionExited(TransitionType type) {
        switch (type)
        {
            case COLLAPSE:
            case FADE:
                jdiAssert(element().isCollapseTransitionEntered(type.getType()), Matchers.is(false));
                break;
            case GROW:
            case SLIDE:
            case ZOOM:
                jdiAssert(element().isCommonTransitionExited(type.getType()), Matchers.is(true));
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * There are five transition types: COLLAPSE, FADE, GROW, SLIDE, ZOOM
     */
    @JDIAction("Assert that transition hidden")
    public TransitionAssert collapseTransitionHidden(TransitionType type) {
        jdiAssert(element().isCollapseTransitionHidden(type.getType()), Matchers.is(true));
        return this;
    }
}
