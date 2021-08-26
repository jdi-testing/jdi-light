package com.jdiai.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Roman Iovlev on 25.08.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Title {
    String value() default "";
}
