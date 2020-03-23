package com.epam.jdi.light.elements.pageobjects.annotations;

import com.epam.jdi.light.common.CheckTypes;

import java.lang.annotation.*;

import static com.epam.jdi.light.common.CheckTypes.*;

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