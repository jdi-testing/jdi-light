package com.epam.jdi.light.material.elements.inputs.transferlist;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.TransferListAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * A transfer list (or "shuttle") enables the user to move one or more list items between lists.
 * You usually select items
 *
 * To see an example of Transfer List web element please visit
 * https://mui.com/components/transfer-list/
 */

public abstract class TransferList extends UIBaseElement<TransferListAssert> {

    protected String rootLocator = ".MuiGrid-root";
    protected String moveCheckedItemsRightButtonLocator = "button[aria-label='move selected right']";
    protected String moveCheckedItemsLeftButtonLocator = "button[aria-label='move selected left']";
    protected String leftListLocator = "(//div[contains(concat(' ', @class, ' '), ' MuiList-root ')])[1]";
    protected String rightListLocator = "(//div[contains(concat(' ', @class, ' '), ' MuiList-root ')])[2]";

    @JDIAction("Returns '{name}' left list")
    public TransferInnerList leftList() {
        return new TransferInnerList().setCore(TransferInnerList.class, find(leftListLocator));
    }

    @JDIAction("Returns '{name}' right list")
    public TransferInnerList rightList() {
        return new TransferInnerList().setCore(TransferInnerList.class, find(rightListLocator));
    }

    @JDIAction("Returns button that moves all checked items to '{name}' right list")
    public Button moveCheckedItemsRightButton() {
        return new Button().setCore(Button.class, find(moveCheckedItemsRightButtonLocator));
    }

    @JDIAction("Returns button that moves all checked items to '{name}' left list")
    public Button moveCheckedItemsLeftButton() {
        return new Button().setCore(Button.class, find(moveCheckedItemsLeftButtonLocator));
    }

    @JDIAction("Clicks button that moves all checked items to '{name}' right list if it's not disabled")
    public void moveCheckedItemsRight() {
        if (!moveCheckedItemsRightButton().isDisabled()) {
            moveCheckedItemsRightButton().click();
        } else {
            throw exception("No checked items in the left list, right transfer button is disabled");
        }
    }

    @JDIAction("Clicks button that moves all checked items to '{name}' left list if it's not disabled")
    public void moveCheckedItemsLeft() {
        if (!moveCheckedItemsLeftButton().isDisabled()) {
            moveCheckedItemsLeftButton().click();
        } else {
            throw exception("No checked items in the right list, left transfer button is disabled");
        }
    }

    @Override
    public TransferListAssert is() {
        return new TransferListAssert().set(this);
    }
}