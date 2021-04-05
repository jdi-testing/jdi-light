package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIPicker {
    @MarkupLocator String pickerInput() default "//input[@class]";

    @MarkupLocator String pickerLabel() default "//label[@class]";

    @MarkupLocator String pickerButton() default "//button[@class]";
}
