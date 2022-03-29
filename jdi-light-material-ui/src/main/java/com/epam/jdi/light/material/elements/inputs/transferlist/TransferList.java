package com.epam.jdi.light.material.elements.inputs.transferlist;

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

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Represents transfer list MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/transfer-list/">Transfer List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class TransferList extends UIBaseElement<TransferListAssert> implements ISetup {

    /**
     * Locator for item checkbox
     */
    private String itemCheckbox;

    /**
     * Locator for all left list items
     */
    private String leftListItems;

    /**
     * Locator for all right list items
     */
    private String rightListItems;

    /**
     * Locator for button which moving selected items to the right list
     */
    String moveRightButton;

    /**
     * Locator for button which moving selected items to the left list
     */
    String moveLeftButton;

    /**
     * Locator for Simple Transfer List button which moving all items to the right list
     */
    String moveAllRightButton;

    /**
     * Locator for Simple Transfer List button which moving all items to the left list
     */
    String moveAllLeftButton;

    /**
     * Locator for Enhanced Transfer List left card header checkbox which selected all items
     */
    String allItemsLeftCheckbox;

    /**
     * Locator for Enhanced Transfer List right card header checkbox which selected all items
     */
    String allItemsRightCheckbox;

    /**
     * Locator for update left list items method
     */
    private CacheAll<List<String>> leftItems = new CacheAll<>(ArrayList::new);

    /**
     * Locator for update right list items method
     */
    private CacheAll<List<String>> rightItems = new CacheAll<>(ArrayList::new);


    /**
     * Updates left items list
     *
     * @return items of this list as {@link List}
     */
    public List<String> updateLeftItems() {
        return leftItems.set(this.finds(leftListItems).stream().map(UIElement::getText).collect(
                Collectors.toList()));
    }

    /**
     * Updates right items list
     *
     * @return items of this list as {@link List}
     */
    public List<String> updateRightItems() {
        return rightItems.set(this.finds(rightListItems).stream().map(UIElement::getText).collect(
                Collectors.toList()));
    }

    /**
     * Checks selected item checkbox
     *
     * @param itemText full text content of item to be checked
     */
    @JDIAction("Check '{name}' item '{0}'")
    public void check(String itemText) {
        if (isUnchecked(itemText)) {
            selector(itemText).click();
        }
    }

    /**
     * Unchecks selected item checkbox
     *
     * @param itemText full text content of item to be unchecked
     */
    @JDIAction("Uncheck '{name}' item '{0}'")
    public void uncheck(String itemText) {
        if (isChecked(itemText)) {
            selector(itemText).click();
        }
    }

    /**
     * Moves all items to the left list. This method is only for Simple Transfer List
     */
    @JDIAction("Move all {name} elements left")
    public void moveAllElementsLeft() {
        this.find(moveAllLeftButton).click();
    }

    /**
     * Moves all items to the right list. This method is only for Simple Transfer List
     */
    @JDIAction("Move all {name} elements right")
    public void moveAllElementsRight() {
        this.find(moveAllRightButton).click();
    }

    /**
     * Verifies Move Right button is enabled
     *
     * @return {@code true} if this button is enabled, otherwise {@code false}
     */
    @JDIAction("Check that {name} move right button is enabled")
    public boolean isMoveRightButtonEnabled() {
        return !isMoveRightButtonDisabled();
    }

    /**
     * Verifies Move Right button is disabled
     *
     * @return {@code true} if this button is disabled, otherwise {@code false}
     */
    @JDIAction("Check that {name} move right button is disabled")
    public boolean isMoveRightButtonDisabled() {
        return core().find(moveRightButton).hasClass("Mui-disabled");
    }

    /**
     * Verifies Move Left button is enabled
     *
     * @return {@code true} if this button is enabled, otherwise {@code false}
     */
    @JDIAction("Check that {name} move left button is enabled")
    public boolean isMoveLeftButtonEnabled() {
        return !isMoveLeftButtonDisabled();
    }

    /**
     * Verifies Move Left button is disabled
     *
     * @return {@code true} if this button is disabled, otherwise {@code false}
     */
    @JDIAction("Check that {name} move left button is disabled")
    public boolean isMoveLeftButtonDisabled() {
        return core().find(moveLeftButton).hasClass("Mui-disabled");
    }

    /**
     * Verifies selected item is checked
     *
     * @param itemText full text content of item to be verified
     * @return {@code true} if this button is checked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' is selected")
    public Boolean isChecked(String itemText) {
        return selector(itemText).hasClass("Mui-checked");
    }

    /**
     * Verifies selected item is unchecked
     *
     * @param itemText full text content of item to be verified
     * @return {@code true} if this button is unchecked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' is not selected")
    public Boolean isUnchecked(String itemText) {
        return !isChecked(itemText);
    }

    /**
     * Gets UIElement item with this text
     *
     * @param itemText full text content of item to be selected
     * @return element with this text as {@link UIElement}
     */
    public UIElement selector(String itemText) {
        return this.find(String.format(itemCheckbox, itemText));
    }

    /**
     * Moves selected items to the left list
     */
    @JDIAction("Move selected {name} items left")
    public void moveItemsLeft() {
        this.find(moveLeftButton).click();
    }

    /**
     * Moves selected items to the right list
     */
    @JDIAction("Move selected {name} items right")
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
