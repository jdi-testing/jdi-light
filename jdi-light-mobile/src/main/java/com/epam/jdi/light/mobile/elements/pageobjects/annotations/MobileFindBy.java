package com.epam.jdi.light.mobile.elements.pageobjects.annotations;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Repeatable(MobileFindBys.class)
public @interface MobileFindBy {

    // Appium
    String id() default "";
    String name() default "";
    String className() default "";
    String tagName() default "";
    String linkText() default "";
    String partialLinkText() default "";
    String accessibilityId() default "";

    String css() default "";
    String xpath() default "";

    // Android
    String androidUIAutomator() default "";
    String androidDataMatcher() default "";
    String androidViewTag() default "";

    // Group
    String group() default "";
}
