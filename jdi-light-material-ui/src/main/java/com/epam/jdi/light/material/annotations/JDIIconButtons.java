package com.epam.jdi.light.material.annotations;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIIconButtons {

    @MarkupLocator String deleteEnabledButton() default "";
    @MarkupLocator String deleteEnabledIcon() default "";
    @MarkupLocator String deleteDisabledButton() default "";
    @MarkupLocator String deleteDisabledIcon() default "";
    @MarkupLocator String alarmButton() default "";
    @MarkupLocator String alarmIcon() default "";
    @MarkupLocator String shoppingCardButton() default "";
    @MarkupLocator String shoppingCardIcon() default "";
}
