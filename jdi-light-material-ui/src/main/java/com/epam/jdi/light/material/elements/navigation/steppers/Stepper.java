package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;

/**
 * Abstract stepper representation containing some typical properties and behavior patterns for all stepper types.
 *
 * @param <A> type of {@link UIAssert} to be used with concrete stepper type
 * @see <a href="https://mui.com/components/steppers/">Stepper MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public abstract class Stepper<A extends StepperAssert<?, ?>> extends UIBaseElement<A> {

    /**
     * Gets current position index within this stepper counting from 1.
     *
     * @return current position index within this stepper as {@code int}
     */
    public abstract int currentIndex();

    /**
     * Gets maximal position index within this stepper counting from 1.
     *
     * @return maximal position index within this stepper as {@code int}
     */
    public abstract int maxIndex();
}
