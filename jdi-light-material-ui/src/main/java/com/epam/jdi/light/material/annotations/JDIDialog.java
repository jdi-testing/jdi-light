package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDIDialog {

  @MarkupLocator String root() default "";
  @MarkupLocator String dialogTitle() default "h2";
  @MarkupLocator String dialogCloseButton() default "";
  @MarkupLocator String dialogOkButton() default "";
  @MarkupLocator String dialogCancelButton() default "";

}
