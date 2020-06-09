package com.epam.jdi.light.elements.pageobjects.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Roman Iovlev on 11.02.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface VisualCheck {
    boolean value() default true;
}
