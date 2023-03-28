package com.epam.jdi.light.mobile.elements.pageobjects.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JApp {
    String app() default "";
    String appPackage() default "";
    String appActivity() default "";
}
