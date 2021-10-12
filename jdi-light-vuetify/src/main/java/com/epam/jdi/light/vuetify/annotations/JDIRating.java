package com.epam.jdi.light.vuetify.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIRating {
    @MarkupLocator String root() default "";
    @MarkupLocator String emptyIcon() default "";
    @MarkupLocator String fullIcon() default "";
    @MarkupLocator String halfIcon() default "";
    @MarkupLocator String color() default "";
    @MarkupLocator String backgroundColor() default "";
    @MarkupLocator String backgroundDarken() default "";
}
