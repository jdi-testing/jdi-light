package com.epam.jdi.light.elements.pageobjects.annotations.locators;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface MarkupLocator {
}