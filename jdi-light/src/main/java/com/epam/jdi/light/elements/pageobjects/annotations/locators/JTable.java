package com.epam.jdi.light.elements.pageobjects.annotations.locators;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTable {
    String root() default "";
    String[] header() default {};

    String headers() default "";
    String filter() default "";
    String row() default "";
    String column() default "";
    String cell() default "";
    String allCells() default "";
    String rowHeader() default "";
    String fromCellToRow() default "";
    int size() default -1;
    int count() default -1;
    int firstColumnIndex() default -1;
    int[] columnsMapping() default {};
}