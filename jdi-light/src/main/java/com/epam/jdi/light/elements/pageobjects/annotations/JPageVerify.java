package com.epam.jdi.light.elements.pageobjects.annotations;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.CheckTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.epam.jdi.light.common.CheckTypes.EQUALS;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JPageVerify {
    String url() default "";
    String title() default "";
    CheckTypes urlCheckType() default EQUALS;
    CheckTypes titleCheckType() default EQUALS;
}