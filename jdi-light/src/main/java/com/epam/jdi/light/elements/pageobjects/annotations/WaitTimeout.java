package com.epam.jdi.light.elements.pageobjects.annotations;

public @interface WaitTimeout {
    int value() default 10;
}
