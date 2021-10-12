package com.epam.jdi.light.vuetify.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDITreeView {
    @MarkupLocator String core() default "";
    @MarkupLocator String coreNodes() default "";
    @MarkupLocator String nodeNodes() default "";
    @MarkupLocator String root() default "";
    @MarkupLocator String toggle() default "";
    @MarkupLocator String checkbox() default "";
    @MarkupLocator String content() default "";
}
