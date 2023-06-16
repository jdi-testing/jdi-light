package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JMUITableColumnFilter {
    @MarkupLocator String root() default "./ancestor::html//div[@role='tooltip' and @class='MuiDataGridPanel-root']";
    @MarkupLocator String deleteButton() default ".//button";
    @MarkupLocator String columnsSelect() default ".//label[text()='Columns']/following-sibling::div/select";
    @MarkupLocator String operatorsSelect() default ".//label[text()='Operators']/following-sibling::div/select";
    @MarkupLocator String valueField() default ".//input[@type='text']";
}
