package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JMUITable {
    @MarkupLocator String root() default "";
    @MarkupLocator String headerRow() default ".//thead/tr";
    @MarkupLocator String columnHeaders() default ".//th";
    @MarkupLocator String row() default ".//tbody/tr";
    @MarkupLocator String cell() default ".//th | .//td";
    @MarkupLocator String columnMenu() default "//div[@role='tooltip' and @class='MuiDataGridMenu-root']//ul";
    @MarkupLocator String scrollableElementLocator() default "";
    JMUITableHeader header() default @JMUITableHeader;
    JMUITableFooter footer() default @JMUITableFooter;
    JMUITableColumnFilter columnFilter() default @JMUITableColumnFilter;
    JMUITableColumnConfig columnConfig() default @JMUITableColumnConfig;
}
