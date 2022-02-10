package com.epam.jdi.light.material.elements.inputs.transferlist;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.table.CacheAll;
import com.epam.jdi.light.material.annotations.JDITransferList;
import com.epam.jdi.light.material.asserts.inputs.TransferListAssert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Transfer List web element please visit
 * https://mui.com/components/transfer-list/
 */

public abstract class TransferList extends UIBaseElement<TransferListAssert> implements ISetup {

    private String itemCheckbox;
    private String leftListItems;
    private String rightListItems;

    String moveRightButton;
    String moveLeftButton;
    String moveAllRightButton;
    String moveAllLeftButton;
    String allItemsLeftCheckbox;
    String allItemsRightCheckbox;

    private CacheAll<List<String>> leftItems = new CacheAll<>(ArrayList::new);
    private CacheAll<List<String>> rightItems = new CacheAll<>(ArrayList::new);

    public List<String> updateLeftItems() {
        return leftItems.set(this.finds(leftListItems).stream().map(UIElement::getText).collect(
                Collectors.toList()));
    }

    public List<String> updateRightItems() {
        return rightItems.set(this.finds(rightListItems).stream().map(UIElement::getText).collect(
                Collectors.toList()));
    }

    @JDIAction("Checks {name}'s '{0}' item")
    public void check(String itemText) {
        if (isUnchecked(itemText)) {
            selector(itemText).click();
        }
    }

    @JDIAction("Unchecks {name}'s '{0}' item")
    public void uncheck(String itemText) {
        if (isChecked(itemText)) {
            selector(itemText).click();
        }
    }

    @JDIAction("Moves all {name}'s elements right")
    public abstract void moveAllElementsRight();

    @JDIAction("Moves all {name}'s elements left")
    public abstract void moveAllElementsLeft();

    @JDIAction("Is {name}'s move right button enable")
    public boolean isMoveRightButtonEnabled() {
        return !isMoveRightButtonDisabled();
    }

    @JDIAction("Is {name}'s move right button disable")
    public boolean isMoveRightButtonDisabled() {
        return core().find(moveRightButton).hasClass("Mui-disabled");
    }

    @JDIAction("Is {name}'s move left button enable")
    public boolean isMoveLeftButtonEnabled() {
        return !isMoveLeftButtonDisabled();
    }

    @JDIAction("Is {name}'s move left button disable")
    public boolean isMoveLeftButtonDisabled() {
        return core().find(moveLeftButton).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' checked")
    public Boolean isChecked(String itemText) {
        return selector(itemText).hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
    public Boolean isUnchecked(String itemText) {
        return !isChecked(itemText);
    }

    public UIElement selector(String itemText) {
        return this.find(String.format(itemCheckbox, itemText));
    }

    @JDIAction("Moves {name}'s elements left")
    public void moveItemsLeft() {
        this.find(moveLeftButton).click();
    }

    @JDIAction("Moves {name}'s elements right")
    public void moveItemsRight() {
        this.find(moveRightButton).click();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITransferList.class, TransferList.class)) {
            return;
        }
        JDITransferList j = field.getAnnotation(JDITransferList.class);
        itemCheckbox = j.itemCheckbox();
        moveAllLeftButton = j.moveAllLeftButton();
        moveAllRightButton = j.moveAllRightButton();
        moveLeftButton = j.moveLeftButton();
        moveRightButton = j.moveRightButton();
        leftListItems = j.leftListItems();
        rightListItems = j.rightListItems();
        allItemsLeftCheckbox = j.allItemsLeftCheckbox();
        allItemsRightCheckbox = j.allItemsRightCheckbox();
    }

    @Override
    public TransferListAssert is() {
        return new TransferListAssert().set(this);
    }
}
