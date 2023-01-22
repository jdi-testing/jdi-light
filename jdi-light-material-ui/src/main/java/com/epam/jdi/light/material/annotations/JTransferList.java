package com.epam.jdi.light.material.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.elements.inputs.transferlist.EnhancedTransferList;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Annotation for setting locators for {@link TransferList} and {@link EnhancedTransferList}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JTransferList {

    /**
     * Locator for {@link TransferList} or {@link EnhancedTransferList} root
     * from which the elements within the transfer list will be searched.
     * Default is ''.
     *
     * @return root locator as {@link String}
     */
    @MarkupLocator String root() default "";

    /**
     * Locator for item checkbox.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     * Default is '//div[./span[text()='%s']]/preceding-sibling::div/span'.
     *
     * @return item checkbox locator as {@link String}
     */
    @MarkupLocator String itemCheckbox() default "//div[./span[text()='%s']]/preceding-sibling::div/span";

    /**
     * Locator for all left list items.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     * Default is '(//*[contains(@class,'MuiPaper-rounded')])[1]//div[contains(@class, 'MuiListItem-root')]'.
     *
     * @return all left list items locator as {@link String}
     */
    @MarkupLocator String leftListItems() default "(//*[contains(@class,'MuiPaper-rounded')])[1]//div[contains(@class, 'MuiListItem-root')]";

    /**
     * Locator for all right list items.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     * Default is '(//*[contains(@class,'MuiPaper-rounded')])[2]//div[contains(@class, 'MuiListItem-root')]'.
     *
     * @return all right list items locator as {@link String}
     */
    @MarkupLocator String rightListItems() default "(//*[contains(@class,'MuiPaper-rounded')])[2]//div[contains(@class, 'MuiListItem-root')]";

    /**
     * Locator for {@link TransferList} button which moves all items to the right list.
     * Default is ''.
     *
     * @return button locator as {@link String}
     */
    @MarkupLocator String moveAllRightButton() default "";

    /**
     * Locator for {@link TransferList} button which moves all items to the left list.
     * Default is ''.
     *
     * @return button locator as {@link String}
     */
    @MarkupLocator String moveAllLeftButton() default "";

    /**
     * Locator for button which moves selected items to the right list.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     * Default is 'button[aria-label='move selected right']'.
     *
     * @return  button locator as {@link String}
     */
    @MarkupLocator String moveRightButton() default "button[aria-label='move selected right']";

    /**
     * Locator for button which moves selected items to the left list.
     * This locator is for {@link TransferList} and {@link EnhancedTransferList}.
     * Default is 'button[aria-label='move selected left']'.
     *
     * @return button locator as {@link String}
     */
    @MarkupLocator String moveLeftButton() default "button[aria-label='move selected left']";

    /**
     * Locator for {@link EnhancedTransferList} left card header checkbox which selects all items.
     * Default is ''.
     *
     * @return checkbox locator as {@link String}
     */
    @MarkupLocator String allItemsLeftCheckbox() default "";

    /**
     * Locator for {@link EnhancedTransferList} right card header checkbox which selects all items.
     * Default is ''.
     *
     * @return checkbox locator as {@link String}
     */
    @MarkupLocator String allItemsRightCheckbox() default "";
}
