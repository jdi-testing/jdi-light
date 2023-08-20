package com.epam.jdi.light.ui.html.elements.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MultiDropdown {

    /**
     * Selector to expanding element
     * @return
     */
    String expander() default ".caret";
    /**
     * Selector for items in expanded list
     * @return
     */
    String items() default ".//li";

    /**
     * Template to search element by value.
     * Must be XPath selector
     * @return Template locator
     */
    String byValueTemplate() default ".//a[label[text()='%s']]";
    /**
     * Selector for element displayed selected values while the list is closed
     * @return locator for selected elements
     */
    String selectedValues() default ".dropdown-toggle";
    /**
     * Selector for root element for items list
     * @return locator for elements
     */
    String itemsContainer() default ".//ul";

}
