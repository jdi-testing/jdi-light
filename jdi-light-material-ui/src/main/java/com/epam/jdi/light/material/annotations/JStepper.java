package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JStepper {

    @MarkupLocator String root() default ".MuiStepper-root";

    @MarkupLocator String backButton() default "//*[contains(text(), 'Back')]";

    @MarkupLocator String nextButton() default "//*[contains(text(), 'Next')]";

    @MarkupLocator String finishButton() default "//*[contains(text(), 'Finish')]";

    @MarkupLocator String steps() default ".MuiStep-root";

}
