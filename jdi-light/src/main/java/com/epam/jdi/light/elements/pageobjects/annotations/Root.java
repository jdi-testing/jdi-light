package com.epam.jdi.light.elements.pageobjects.annotations;

import java.lang.annotation.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface Root {
}