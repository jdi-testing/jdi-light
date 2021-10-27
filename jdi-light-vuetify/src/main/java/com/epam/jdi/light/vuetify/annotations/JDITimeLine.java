package com.epam.jdi.light.vuetify.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDITimeLine {
    @MarkupLocator String root() default "";
    @MarkupLocator String items() default "";
    @MarkupLocator String body() default "";
    @MarkupLocator String divider() default "";
    @MarkupLocator String opposite() default "";
}