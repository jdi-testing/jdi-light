package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIModal {

    @MarkupLocator String modalTitle() default "simple-modal-title";
    @MarkupLocator String modalDescription() default "simple-modal-description";
    @MarkupLocator String modalInnerButton() default "//button[contains('type=\"button\"')]";
    @MarkupLocator String innerModalPage() default  "body > div:nth-child(10) > div.makeStyles-paper-32";

}
