package com.epam.jdi.light.elements.pageobjects.annotations.locators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTable {
    @MarkupLocator String root() default "";
    String[] header() default {};

    @MarkupLocator String headers() default "th";
    @MarkupLocator String filter() default "th input[type=search],th input[type=text]";
    @MarkupLocator String row() default "//tr[%s]/td";
    @MarkupLocator String jsRow() default "tr";
    @MarkupLocator String column() default "//tr/td[%s]";
    @MarkupLocator String jsColumn() default "td";
    @MarkupLocator String cell() default "//tr[{1}]/td[{0}]";
    @MarkupLocator String allCells() default "td";
    @MarkupLocator String rowHeader() default "";
    @MarkupLocator String fromCellToRow() default "../td";
    @MarkupLocator String footer() default "tfoot";
    int size() default -1;
    int count() default -1;
    int shiftColumnIndex() default -1;
    int shiftRowIndex() default -1;
    int[] columnsMapping() default {};
}