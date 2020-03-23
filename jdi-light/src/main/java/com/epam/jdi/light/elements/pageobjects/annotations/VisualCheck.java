package com.epam.jdi.light.elements.pageobjects.annotations;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 11.02.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface VisualCheck {
    boolean value() default true;
}
