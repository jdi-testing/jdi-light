package com.epam.jdi.light.material.elements.inputs.transferlist;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.table.CacheAll;
import com.epam.jdi.light.material.annotations.JTransferList;
import com.epam.jdi.light.material.asserts.inputs.TransferListAssert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * Represents transfer list MUI component on GUI.
 * Transfer List is the lists of the items with checkboxes which can move items
 * to the left or right list. You can select some items and move them or
 * move all items at once.
 *
 * @see <a href="https://mui.com/components/transfer-list/">Transfer List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class TransferList extends UIBaseElement<TransferListAssert> implements ISetup {

    /**
     * Locator for item checkbox.
     */
    private String itemCheckbox;

    /**
     * Locator for all left list items.
     */
    private String leftListItems;

    /**
     * Locator for all right list items.
     */
    private String rightListItems;

    /**
     * Locator for button which moves selected items to the right list.
     */
    String moveRightButton;

    /**
     * Locator for button which moves selected items to the left list.
     */
    String moveLeftButton;

    /**
     * Locator for Simple Transfer List button which moves all items to the right list.
     */
    String moveAllRightButton;

    /**
     * Locator for Simple Transfer List button which moves all items to the left list.
     */
    String moveAllLeftButton;

    /**
     * Locator for Enhanced Transfer List left card header checkbox which selects all items.
     */
    String allItemsLeftCheckbox;

    /**
     * Locator for Enhanced Transfer List right card header checkbox which selects all items.
     */
    String allItemsRightCheckbox;

    /**
     * Texts of left items for update left list items method.
     */
    private CacheAll<List<String>> leftItems = new CacheAll<>(ArrayList::new);

    /**
     * Texts of right items for update right list items method.
     */
    private CacheAll<List<String>> rightItems = new CacheAll<>(ArrayList::new);

    /**
     * Updates left items list after moving and returns updated actual items list.
     *
     * @return updated items of this list as {@link List}
     */
    @JDIAction("Update '{name}' left items")
    public List<String> updateLeftItems() {
        return leftItems.set(core().finds(leftListItems).stream().map(UIElement::getText).collect(
                Collectors.toList()));
    }

    /**
     * Updates right items list after moving and returns updated actual items list.
     *
     * @return updated items of this list as {@link List}
     */
    @JDIAction("Update '{name}' right items")
    public List<String> updateRightItems() {
        return rightItems.set(core().finds(rightListItems).stream().map(UIElement::getText).collect(
                Collectors.toList()));
    }

    /**
     * Checks checkbox of the specific item using its text (full equality is used by searching).
     *
     * @param itemText full text content of item to be checked
     */
    @JDIAction("Check '{name}' item '{0}'")
    public void check(String itemText) {
        if (isUnchecked(itemText)) {
            getItemCheckbox(itemText).click();
        }
    }

    /**
     * Unchecks checkbox of the specific item using its text (full equality is used by searching).
     *
     * @param itemText full text content of item to be unchecked
     */
    @JDIAction("Uncheck '{name}' item '{0}'")
    public void uncheck(String itemText) {
        if (isChecked(itemText)) {
            getItemCheckbox(itemText).click();
        }
    }

    /**
     * Moves all items to the left list.
     */
    @JDIAction("Move all '{name}' elements to the left list")
    public void moveAllElementsLeft() {
        core().find(moveAllLeftButton).click();
    }

    /**
     * Moves all items to the right list.
     */
    @JDIAction("Move all '{name}' elements to the right list")
    public void moveAllElementsRight() {
        core().find(moveAllRightButton).click();
    }

    /**
     * Checks that 'Move right' button is enabled.
     *
     * @return {@code true} if this button is enabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move right' button is enabled")
    public boolean isMoveRightButtonEnabled() {
        return !isMoveRightButtonDisabled();
    }

    /**
     * Checks that 'Move right' button is disabled.
     *
     * @return {@code true} if this button is disabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move right' button is disabled")
    public boolean isMoveRightButtonDisabled() {
        return core().find(moveRightButton).hasClass("Mui-disabled");
    }

    /**
     * Checks that 'Move left' button is enabled.
     *
     * @return {@code true} if this button is enabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move left' button is enabled")
    public boolean isMoveLeftButtonEnabled() {
        return !isMoveLeftButtonDisabled();
    }

    /**
     * Checks that 'Move left' button is disabled.
     *
     * @return {@code true} if this button is disabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move left' button is disabled")
    public boolean isMoveLeftButtonDisabled() {
        return core().find(moveLeftButton).hasClass("Mui-disabled");
    }

    /**
     * Checks if specific item is checked or not.
     *
     * @param itemText full text content of item to be checked
     * @return {@code true} if this item is checked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' is selected")
    public Boolean isChecked(String itemText) {
        return getItemCheckbox(itemText).hasClass("Mui-checked");
    }

    /**
     * Checks if specific item is unchecked or not.
     *
     * @param itemText full text content of item to be checked
     * @return {@code true} if this item is unchecked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' is not selected")
    public Boolean isUnchecked(String itemText) {
        return !isChecked(itemText);
    }

    /**
     * Gets the checkbox of specific item using the item text (full equality is used by searching).
     *
     * @param itemText full text content of item
     * @return element with this text as {@link UIElement}
     */
    public UIElement getItemCheckbox(String itemText) {
        return core().find(String.format(itemCheckbox, itemText));
    }

    /**
     * Moves selected items to the left list.
     */
    @JDIAction("Move selected '{name}' items to the left list")
    public void moveItemsLeft() {
        core().find(moveLeftButton).click();
    }

    /**
     * Moves selected items to the right list.
     */
    @JDIAction("Move selected '{name}' items to the right list")
    public void moveItemsRight() {
        core().find(moveRightButton).click();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTransferList.class, TransferList.class)) {
            return;
        }
        JTransferList j = field.getAnnotation(JTransferList.class);
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
