package com.epam.jdi.light.material.annotations;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIIconLabelButtons {

    @MarkupLocator String deleteButton() default "";
    @MarkupLocator String deleteIcon() default "";
    @MarkupLocator String sendButton() default "";
    @MarkupLocator String sendIcon() default "";
    @MarkupLocator String uploadButton() default "";
    @MarkupLocator String uploadIcon() default "";
    @MarkupLocator String talkButton() default "";
    @MarkupLocator String talkIcon() default "";
    @MarkupLocator String saveButton() default "";
    @MarkupLocator String saveIcon() default "";
    @MarkupLocator String saveAllButton() default "";
    @MarkupLocator String saveAllIcon() default "";
}
