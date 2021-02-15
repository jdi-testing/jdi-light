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
  @MarkupLocator String button() default ".MuiButton-label";
  @MarkupLocator String dialogTitle() default "h2";
  @MarkupLocator String dialogContent() default ".MuiDialogContentText-root";
  @MarkupLocator String dialogInputField() default ".MuiInput-input";
  @MarkupLocator String dialogCloseButton() default "//*[text()='Close']";
  @MarkupLocator String dialogOkButton() default "//*[text()='Ok']";
  @MarkupLocator String dialogOptions() default ".MuiListItemText-primary";

}
