package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDITransferList {
    // Common
    @MarkupLocator String root() default "";
    @MarkupLocator String leftList() default "";
    @MarkupLocator String rightList() default "";
    @MarkupLocator String moveCheckedItemsRightButton() default "";
    @MarkupLocator String moveCheckedItemsLeftButton() default "";

    // Simple Transfer List
    @MarkupLocator String moveAllItemsRightButton() default "";
    @MarkupLocator String moveAllItemsLeftButton() default "";

    // Enhanced Transfer List
    @MarkupLocator String leftSelectAllCheckbox() default "";
    @MarkupLocator String rightSelectAllCheckbox() default "";
    @MarkupLocator String leftListHeader() default "";
    @MarkupLocator String rightListHeader() default "";
    @MarkupLocator String leftListSubheader() default "";
    @MarkupLocator String rightListSubheader() default "";
}

