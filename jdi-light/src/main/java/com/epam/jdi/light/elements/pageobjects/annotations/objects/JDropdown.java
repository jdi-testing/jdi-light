package com.epam.jdi.light.elements.pageobjects.annotations.objects;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDropdown {
    FindBy root() default @FindBy();
    FindBy value() default @FindBy();
    FindBy list() default @FindBy();
    FindBy expand() default @FindBy();

}
