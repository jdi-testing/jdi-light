package com.epam.jdi.light.material.annotations;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDITextButtons {

    @MarkupLocator String defaultButton() default "";
    @MarkupLocator String primaryButton() default "";
    @MarkupLocator String secondaryButton() default "";
    @MarkupLocator String disabledButton() default "";
    @MarkupLocator String linkButton() default "";
}
