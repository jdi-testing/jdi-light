package com.epam.jdi.light.material.elements.inputs.transferlist;

import com.epam.jdi.light.common.JDIAction;

/**
 * Represents Enhanced transfer list MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/transfer-list/#enhanced-transfer-list">Enhanced Transfer List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class EnhancedTransferList extends TransferList {

    /**
     * Selectors Card Header checkbox and moves all items to the left list. This method is only for Enhanced Transfer List
     */
    @JDIAction("Moves all {name}'s elements left")
    public void moveAllElementsLeft() {
        this.find(allItemsRightCheckbox).click();
        this.find(moveLeftButton).click();
    }

    /**
     * Selectors Card Header checkbox and moves all items to the right list. This method is only for Enhanced Transfer List
     */
    @JDIAction("Moves all {name}'s elements right")
    public void moveAllElementsRight() {
        this.find(allItemsLeftCheckbox).click();
        this.find(moveRightButton).click();
    }
}
