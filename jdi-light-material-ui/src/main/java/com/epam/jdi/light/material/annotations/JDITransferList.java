package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JDITransferList {
    @MarkupLocator String root() default "";

    @MarkupLocator String itemCheckbox() default "//div[./span[text()='%s']]/preceding-sibling::div/span";

    @MarkupLocator String leftListItems() default "(//*[contains(@class,'MuiPaper-rounded')])[1]//div[contains(@class, 'MuiListItem-root')]";
    @MarkupLocator String rightListItems() default "(//*[contains(@class,'MuiPaper-rounded')])[2]//div[contains(@class, 'MuiListItem-root')]";

    @MarkupLocator String moveAllRightButton() default "";
    @MarkupLocator String moveAllLeftButton() default "";
    @MarkupLocator String moveRightButton() default "button[aria-label='move selected right']";
    @MarkupLocator String moveLeftButton() default "button[aria-label='move selected left']";

    @MarkupLocator String allItemsLeftCheckbox() default "";
    @MarkupLocator String allItemsRightCheckbox() default "";
}