package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for setting locators for buttons in {@link ButtonGroup}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIButtonGroup {
    /**
     * Locator for buttons in {@link ButtonGroup}.
     *
     * @return locator for buttons in {@link ButtonGroup}
     */
    @MarkupLocator String list() default "";
}
