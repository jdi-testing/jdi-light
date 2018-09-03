package com.epam.jdi.light.elements.pageobjects.annotations;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Frame {
    // Selenium
    String css() default "";
    String tagName() default "";
    String linkText() default "";
    String partialLinkText() default "";
    String xpath() default "";

    // Text
    String text() default "";

    //Attributes
    String id() default "";
    String name() default "";
    String className() default "";

    // Group
    String group() default "";
    String value() default "";
}