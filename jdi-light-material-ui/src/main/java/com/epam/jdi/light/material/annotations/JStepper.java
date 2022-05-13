package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.navigation.steppers.DesktopStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for setting custom locators for steppers and their components.
 *
 * @see Stepper
 * @see DesktopStepper
 * @see MobileStepper
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JStepper {

    /**
     * Root locator for this stepper, i.e. locator to start searching from for all inner components.
     * Default is '.MuiStepper-root'.
     *
     * @return root locator as {@link String}
     */
    @MarkupLocator String root() default ".MuiStepper-root";

    /**
     * Button group locator for this stepper because typically navigation buttons in this group technically
     * are not part of stepper, but logically they are. Default is 'button'.
     *
     * @return button group locator as {@link String}
     */
    @MarkupLocator String buttonGroup() default "button";
}
