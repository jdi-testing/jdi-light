package com.epam.jdi.light.elements.pageobjects.annotations;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MobileFindBy {

    String id() default "";
    String name() default "";
    String className() default "";

    String tagName() default "";
    String linkText() default "";
    String partialLinkText() default "";


    String accessibilityId() default "";

    // Group
    String group() default "";
}
