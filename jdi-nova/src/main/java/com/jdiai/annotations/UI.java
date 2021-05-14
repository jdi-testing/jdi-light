package com.jdiai.annotations;

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
public @interface UI {
    String value() default "";
    String css() default "";
    String tag() default "";
    String xpath() default "";
    String text() default "";
    String hasText() default "";

    String id() default "";
    String name() default "";
    String clazz() default "";
    String label() default "";
    String alt() default "";
    String hasValue() default "";
}
