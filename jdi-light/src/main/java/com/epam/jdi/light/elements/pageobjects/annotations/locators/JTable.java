package com.epam.jdi.light.elements.pageobjects.annotations.locators;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTable {
    @MarkupLocator String root() default "";
    String[] header() default {};

    @MarkupLocator String headers() default "";
    @MarkupLocator String filter() default "";
    @MarkupLocator String row() default "";
    @MarkupLocator String column() default "";
    @MarkupLocator String cell() default "";
    @MarkupLocator String allCells() default "";
    @MarkupLocator String rowHeader() default "";
    @MarkupLocator String fromCellToRow() default "";
    int size() default -1;
    int count() default -1;
    int firstColumnIndex() default -1;
    int[] columnsMapping() default {};
}