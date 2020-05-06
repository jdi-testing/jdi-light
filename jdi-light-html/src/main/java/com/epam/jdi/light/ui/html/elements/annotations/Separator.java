package com.epam.jdi.light.ui.html.elements.annotations;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 02.05.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Separator {
    String value();
}
