package com.epam.jdi.light.ui.html.elements.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 02.05.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JMenu {
    @MarkupLocator String[] value();
    String group() default "";
}
