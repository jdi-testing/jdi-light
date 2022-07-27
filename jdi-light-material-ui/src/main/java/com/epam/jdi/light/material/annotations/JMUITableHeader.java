package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JMUITableHeader {
    @MarkupLocator String root() default ".MuiTableHead-root";
    @MarkupLocator String button() default ".//button";
    @MarkupLocator String headerRow() default ".MuiTableRow-head";
    @MarkupLocator String columnHeaders() default ".MuiTableCell-head";
    @MarkupLocator String selectedRows() default ".//ancestor::div[@class = 'MuiTableContainer-root']/../div";
}
