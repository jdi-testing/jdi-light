package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JMUITable {
    @MarkupLocator String root() default ".MuiTable-root";
    @MarkupLocator String row() default ".MuiTableBody-root>.MuiTableRow-root";
    @MarkupLocator String cell() default ".MuiTableBody-root .MuiTableCell-root";
    @MarkupLocator String columnMenu() default "//div[@role='tooltip' and @class='MuiDataGridMenu-root']//ul";
    @MarkupLocator String scroll() default "";
    JMUITableHeader header() default @JMUITableHeader;
    JMUITableFooter footer() default @JMUITableFooter;
    JMUITableColumnFilter columnFilter() default @JMUITableColumnFilter;
    JMUITableColumnConfig columnConfig() default @JMUITableColumnConfig;
}
