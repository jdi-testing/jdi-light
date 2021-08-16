package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JAppBar {
    @MarkupLocator String root() default "";
    @MarkupLocator String navigationButton() default "";
    @MarkupLocator String title() default "";
    @MarkupLocator String[] actionItems() default "";
    @MarkupLocator String overflowMenuButton() default "";
}
