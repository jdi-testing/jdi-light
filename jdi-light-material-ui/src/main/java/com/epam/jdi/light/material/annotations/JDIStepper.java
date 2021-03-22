package com.epam.jdi.light.material.annotations;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIStepper {

    @MarkupLocator String root() default "";
    @MarkupLocator String stepperTitle() default "";
    @MarkupLocator String stepperNextButton() default "";
    @MarkupLocator String stepperBackButton() default "";
    @MarkupLocator String stepperFinishButton() default "";
    @MarkupLocator String stepperResetButton() default "";
    @MarkupLocator String stepperSkipButton() default "";
    @MarkupLocator String stepperCompleteStepButton() default "";
}
