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
    @MarkupLocator String stepperTitle() default ".MuiTypography-root.MuiTypography-body1";
    @MarkupLocator String stepperNextButton() default "//*[text()='Next']/..";
    @MarkupLocator String stepperBackButton() default "//*[text()='Back']/..";
    @MarkupLocator String stepperFinishButton() default "//*[text()='Finish']/..";
    @MarkupLocator String stepperResetButton() default "//*[text()='Reset']/..";
    @MarkupLocator String stepperSkipButton() default "//*[text()='Skip']/..";
    @MarkupLocator String stepperCompleteStepButton() default "//*[text()='Complete Step']/..";
}
