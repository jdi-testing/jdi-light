package com.epam.jdi.mobile.elements.pageobjects.annotations.locators;

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
    String root() default "";
    String[] header() default {};

    String headers() default "";
    String filter() default "";
    String row() default "";
    String column() default "";
    String cell() default "";
    String allCells() default "";
    String rowHeader() default "";
    int size() default -1;
    int count() default -1;
    int firstColumnIndex() default -1;
    int[] columnsMapping() default {};
}