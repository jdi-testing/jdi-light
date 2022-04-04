package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.inputs.transferlist.EnhancedTransferList;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Represents transfer list MUI component annotation.
 * Annotation for setting locators for buttons and left/right items list in {@link TransferList} and {@link EnhancedTransferList}
 *
 * @see <a href="https://mui.com/components/transfer-list/">Transfer List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTransferList {

    @MarkupLocator String root() default "";

    /**
     * Locator for item checkbox.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     */
    @MarkupLocator String itemCheckbox() default "//div[./span[text()='%s']]/preceding-sibling::div/span";



    /**
     * Locator for all left list items.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     */
    @MarkupLocator String leftListItems() default "(//*[contains(@class,'MuiPaper-rounded')])[1]//div[contains(@class, 'MuiListItem-root')]";
    /**
     * Locator for all right list items.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     */
    @MarkupLocator String rightListItems() default "(//*[contains(@class,'MuiPaper-rounded')])[2]//div[contains(@class, 'MuiListItem-root')]";



    /**
     * Locator for {@link TransferList} button which moves all items to the right list.
     */
    @MarkupLocator String moveAllRightButton() default "";
    /**
     * Locator for {@link TransferList} button which moves all items to the left list.
     */
    @MarkupLocator String moveAllLeftButton() default "";
    /**
     * Locator for button which moves selected items to the right list.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     */
    @MarkupLocator String moveRightButton() default "button[aria-label='move selected right']";
    /**
     * Locator for button which moves selected items to the left list.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     */
    @MarkupLocator String moveLeftButton() default "button[aria-label='move selected left']";



    /**
     * Locator for {@link EnhancedTransferList} left card header checkbox which selects all items.
     */
    @MarkupLocator String allItemsLeftCheckbox() default "";
    /**
     * Locator for {@link EnhancedTransferList} right card header checkbox which selects all items.
     */
    @MarkupLocator String allItemsRightCheckbox() default "";
}

