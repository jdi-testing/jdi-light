package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;

import java.lang.reflect.Field;

/**
 * Abstract stepper representation containing some typical properties and behavior patterns for all stepper types.
 *
 * @param <A> type of {@link UIAssert} to be used with concrete stepper type
 * @see <a href="https://mui.com/components/steppers/">Stepper MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public abstract class Stepper<A extends StepperAssert<?, ?>> extends UIBaseElement<A> implements ISetup {

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

    /**
     * Sets up basic components for stepper, e.g. base element, and parses given field for {@link JStepper} annotation.
     * Intended to be used by initialization for concrete stepper types.
     *
     * @param field field to be parsed for {@link JStepper} annotation
     * @return {@link JStepper} annotation instance if present, otherwise {@code null}
     */
    protected JStepper basicSetup(Field field) {
        if (FillFromAnnotationRules.fieldHasAnnotation(field, JStepper.class, Stepper.class)) {
            JStepper j = field.getAnnotation(JStepper.class);
            base().setLocator(WebDriverByUtils.NAME_TO_LOCATOR.execute(j.root()));
            return j;
        } else {
            return null;
        }
    }
}
