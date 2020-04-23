package com.epam.jdi.light.elements.pageobjects.annotations.locators;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JMenu {
    @MarkupLocator String[] value();
    String group() default "";
}
