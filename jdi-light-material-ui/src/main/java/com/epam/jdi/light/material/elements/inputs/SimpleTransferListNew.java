package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDITransferListNew;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferListNew;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.lang.reflect.Field;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;


/**
 * A transfer list (or "shuttle") enables the user to move one or more list items between lists.
 *
 * To see an example of Transfer List web element please visit
 * https://mui.com/components/transfer-list/
 */

public class SimpleTransferListNew extends TransferListNew implements ISetup {

    protected String moveAllItemsRightButtonLocator = "button[aria-label='move all right']";
    protected String moveAllItemsLeftButtonLocator = "button[aria-label='move all left']";

    @JDIAction("Returns button that moves all items to '{name}' right list")
    public Button moveAllItemsRightButton() {
        return new Button().setCore(Button.class, find(moveAllItemsRightButtonLocator));
    }

    @JDIAction("Returns button that moves all items to '{name}' left list")
    public Button moveAllItemsLeftButton() {
        return new Button().setCore(Button.class, find(moveAllItemsLeftButtonLocator));
    }

    @JDIAction("Clicks button that moves all items to '{name}' right list if it's not disabled")
    public void moveAllItemsRight() {
        if (!moveAllItemsRightButton().isDisabled()) {
            moveAllItemsRightButton().click();
        } else {
            throw exception("No items in the left list, right transfer button is disabled");
        }
    }

    @JDIAction("Clicks button that moves all items to '{name}' left list if it's not disabled")
    public void moveAllItemsLeft() {
        if (!moveAllItemsLeftButton().isDisabled()) {
            moveAllItemsLeftButton().click();
        } else {
            throw exception("No items in the right list, left transfer button is disabled");
        }
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITransferListNew.class, List.class)) return;
        JDITransferListNew j = field.getAnnotation(JDITransferListNew.class);
        rootLocator = j.root();
        moveAllItemsRightButtonLocator = j.moveAllItemsRightButton();
        moveAllItemsLeftButtonLocator = j.moveAllItemsLeftButton();
        moveCheckedItemsRightButtonLocator = j.moveCheckedItemsRightButton();
        moveCheckedItemsLeftButtonLocator = j.moveCheckedItemsLeftButton();
        leftListLocator = j.leftList();
        rightListLocator = j.rightList();
    }
}
