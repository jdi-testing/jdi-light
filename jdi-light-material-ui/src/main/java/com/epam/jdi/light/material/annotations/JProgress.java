package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JProgress {

    @MarkupLocator String root() default "//*[contains(@class, 'Progress-root')]";

    @MarkupLocator String label() default ".MuiTypography-root";

    @MarkupLocator String bar1() default "//*[contains(@class, 'MuiLinearProgress-bar1')]";

    @MarkupLocator String bar2() default "//*[contains(@class, 'MuiLinearProgress-bar2')]";
}
