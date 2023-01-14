package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JMUITableColumnConfig {
    @MarkupLocator String root() default "./ancestor::html//div[@role='tooltip' and @class='MuiDataGridPanel-root']";
    @MarkupLocator String searchField() default ".//input[@type='text']";
    @MarkupLocator String listItem() default ".//label[@class='MuiFormControlLabel-root']";
    @MarkupLocator String hideAllButton() default ".//span[text()='Hide all' or text()='hide all']/parent::button";
    @MarkupLocator String showAllButton() default ".//span[text()='Show all' or text()='show all']/parent::button";
}
