package com.epam.jdi.light.material.annotations;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDICheckbox {
    @MarkupLocator String basicCheckbox() default "";
    @MarkupLocator String formControlLabelCheckbox() default "";
    @MarkupLocator String formGroupCheckbox() default "";
    @MarkupLocator String labelPlacement() default "";
    @MarkupLocator String formControlLabelText() default "";
    @MarkupLocator String formGroupText() default "";
    @MarkupLocator String labelPlacementText() default "";
    @MarkupLocator String errorMessageText() default "";
}
