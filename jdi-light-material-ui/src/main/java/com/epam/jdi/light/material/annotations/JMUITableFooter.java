package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JMUITableFooter {
    @MarkupLocator String root() default "";
    @MarkupLocator String selectedRowsInfo() default ".//div[@class='MuiDataGrid-selectedRowCount']";
    @MarkupLocator String rowsPerPageDropdown() default ".//div[contains(@class,'MuiSelect-root')]/..";
    @MarkupLocator String paginationInfo() default ".//p[contains(@class,'MuiTablePagination-caption') and not(@id)]";
    @MarkupLocator String firstPageButton() default ".//button[@aria-label='First page' or @aria-label='first page']";
    @MarkupLocator String previousPageButton() default ".//button[@aria-label='Previous page' or @aria-label='previous page']";
    @MarkupLocator String nextPageButton() default ".//button[@aria-label='Next page' or @aria-label='next page']";
    @MarkupLocator String lastPageButton() default ".//button[@aria-label='Last page' or @aria-label='last page']";
}
