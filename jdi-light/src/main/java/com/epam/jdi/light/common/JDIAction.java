package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.logger.LogLevels;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.epam.jdi.light.logger.LogLevels.STEP;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface JDIAction {
    String value() default "";
    LogLevels level() default STEP;
    String condition() default "";
    boolean logResult() default true;
    int timeout() default -1;
}