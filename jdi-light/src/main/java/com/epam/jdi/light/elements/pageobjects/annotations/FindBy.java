package com.epam.jdi.light.elements.pageobjects.annotations;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Repeatable(FindBys.class)
public @interface FindBy {
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
    String accessibilityId() default "";


    // Group
    String group() default "";
}