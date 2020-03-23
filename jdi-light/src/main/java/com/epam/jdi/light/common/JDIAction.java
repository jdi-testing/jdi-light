package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.logger.LogLevels;

import java.lang.annotation.*;

import static com.epam.jdi.light.logger.LogLevels.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface JDIAction {
    String value() default "";
    LogLevels level() default STEP;
    String condition() default "";
    boolean logResult() default true;
    int timeout() default -1;
}