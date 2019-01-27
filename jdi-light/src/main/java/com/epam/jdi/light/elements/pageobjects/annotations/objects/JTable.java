package com.epam.jdi.light.elements.pageobjects.annotations.objects;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTable {
    FindBy root() default @FindBy();
    String[] header() default {};

    FindBy headers() default @FindBy();
    FindBy row() default @FindBy();
    FindBy column() default @FindBy();
    FindBy cell() default @FindBy();
    FindBy allCells() default @FindBy();
    int size() default -1;
    int count() default -1;
}