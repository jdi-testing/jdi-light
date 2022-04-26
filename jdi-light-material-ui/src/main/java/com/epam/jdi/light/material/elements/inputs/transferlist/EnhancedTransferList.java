package com.epam.jdi.light.material.elements.inputs.transferlist;

import com.epam.jdi.light.common.JDIAction;

/**
 * Represents Enhanced Transfer List MUI component on GUI.
 * The difference between an Enhanced Transfer List and a Transfer List
 * is that it has a checkbox which can select all items in the list.
 * Enhanced Transfer List has only two buttons for moving items to the
 * left/right, when Transfer List has four buttons.
 *
 * @see <a href="https://mui.com/components/transfer-list/#enhanced-transfer-list">Enhanced Transfer List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class EnhancedTransferList extends TransferList {

    /**
     * Checks Card Header checkbox and moves all items to the left list by clicking 'Move selected left' button.
     */
    @Override
    @JDIAction("Move all '{name}' elements to the left list")
    public void moveAllElementsLeft() {
        core().find(allItemsRightCheckbox).click();
        core().find(moveLeftButton).click();
    }

    /**
     * Checks Card Header checkbox and moves all items to the right list by clicking 'Move selected right' button.
     */
    @Override
    @JDIAction("Move all '{name}' elements to the right list")
    public void moveAllElementsRight() {
        core().find(allItemsLeftCheckbox).click();
        core().find(moveRightButton).click();
    }
}
