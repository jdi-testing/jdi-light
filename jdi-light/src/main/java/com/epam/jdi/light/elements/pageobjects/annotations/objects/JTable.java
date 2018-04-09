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

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.TableHeaderTypes.COLUMNS_HEADERS;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTable {
    FindBy root() default @FindBy();
    String[] header() default {};
    String[] rowsHeader() default {};

    FindBy headers() default @FindBy();
    FindBy rowNames() default @FindBy();
    FindBy cell() default @FindBy();
    FindBy cells() default @FindBy();
    FindBy row() default @FindBy();
    FindBy column() default @FindBy();
    FindBy footer() default @FindBy();

    int height() default -1;
    int width() default -1;
    String size() default "";

    int rowStartIndex() default -1;
    int colStartIndex() default -1;

    TableHeaderTypes headerType() default COLUMNS_HEADERS;
    boolean useCache() default false;


}