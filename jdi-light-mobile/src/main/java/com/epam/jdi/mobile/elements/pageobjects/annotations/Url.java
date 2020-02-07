package com.epam.jdi.mobile.elements.pageobjects.annotations;

import com.epam.jdi.mobile.common.CheckTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.epam.jdi.mobile.common.CheckTypes.CONTAINS;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Url {
    String value() default "";
    String template() default "";
    CheckTypes validate() default CONTAINS;
}