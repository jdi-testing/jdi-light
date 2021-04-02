package com.epam.jdi.light.material.annotations;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIButtons {

    @MarkupLocator String containedButton() default "";
    @MarkupLocator String textButton() default "";
    @MarkupLocator String iconLabelButton() default "";
    @MarkupLocator String iconLabelIcon() default "";
    @MarkupLocator String iconLabelSpanIcon() default "";
    @MarkupLocator String iconButton() default "";
    @MarkupLocator String customizedButton() default "";
    @MarkupLocator String complexButton() default "";
}
