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

    // @todo #5048 Check this class and annotation, locators are bad (we can not work without annotation), methods are not good enough
    private String itemCheckbox;
    private String leftListItems;
    private String rightListItems;
    private String moveAllRightButton;
    private String moveAllLeftButton;

    /**
     * Locator for button which moves selected items to the right list.
     */
    protected String moveRightButton;

    /**
     * Locator for button which moves selected items to the left list.
     */
    protected String moveLeftButton;

    /**
     * Locator for Enhanced Transfer List left card header checkbox which selects all items.
     */
    protected String allItemsLeftCheckbox;

    /**
     * Locator for Enhanced Transfer List right card header checkbox which selects all items.
     */
    protected String allItemsRightCheckbox;

    private CacheAll<List<String>> leftItems = new CacheAll<>(ArrayList::new);
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
     * Checks checkbox of the item with given text (full equality is used by searching).
     * If it's already checked, does nothing.
     *
     * @param itemText expected item text
     */
    @JDIAction("Check '{name}' item '{0}'")
    public void check(String itemText) {
        if (isUnchecked(itemText)) {
            getItemCheckbox(itemText).click();
        }
    }

    /**
     * Unchecks checkbox of the item with given text  (full equality is used by searching).
     * If it's already unchecked, does nothing.
     *
     * @param itemText expected item text
     */
    @JDIAction("Uncheck '{name}' item '{0}'")
    public void uncheck(String itemText) {
        if (isChecked(itemText)) {
            getItemCheckbox(itemText).click();
        }
    }

    /**
     * Moves all items to the left list by clicking 'Move all left' button.
     */
    @JDIAction("Move all '{name}' elements to the left list")
    public void moveAllElementsLeft() {
        core().find(moveAllLeftButton).click();
    }

    /**
     * Moves all items to the right list by clicking 'Move all right' button.
     */
    @JDIAction("Move all '{name}' elements to the right list")
    public void moveAllElementsRight() {
        core().find(moveAllRightButton).click();
    }

    /**
     * Checks that 'Move selected right' button is enabled.
     *
     * @return {@code true} if 'Move selected right' button is enabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move selected right' button is enabled")
    public boolean isMoveRightButtonEnabled() {
        return !isMoveRightButtonDisabled();
    }

    /**
     * Checks that 'Move selected right' button is disabled.
     *
     * @return {@code true} if 'Move selected right' button is disabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move selected right' button is disabled")
    public boolean isMoveRightButtonDisabled() {
        return core().find(moveRightButton).hasClass("Mui-disabled");
    }

    /**
     * Checks that 'Move selected left' button is enabled.
     *
     * @return {@code true} if 'Move selected left' button is enabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move selected left' button is enabled")
    public boolean isMoveLeftButtonEnabled() {
        return !isMoveLeftButtonDisabled();
    }

    /**
     * Checks that 'Move selected left' button is disabled.
     *
     * @return {@code true} if 'Move selected left' button is disabled, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' 'Move selected left' button is disabled")
    public boolean isMoveLeftButtonDisabled() {
        return core().find(moveLeftButton).hasClass("Mui-disabled");
    }

    /**
     * Checks that item with given text is checked or not.
     *
     * @param itemText expected item text
     * @return {@code true} if item with given text is checked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' is selected")
    public boolean isChecked(String itemText) {
        return getItemCheckbox(itemText).hasClass("Mui-checked");
    }

    /**
     * Checks that item with given text is unchecked or not.
     *
     * @param itemText expected item text
     * @return {@code true} if item with given text is unchecked, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' is not selected")
    public boolean isUnchecked(String itemText) {
        return !isChecked(itemText);
    }

    /**
     * Gets the checkbox of item with given text (full equality is used by searching).
     *
     * @param itemText expected item text
     * @return checkbox of item with given text as {@link UIElement}
     */
    public UIElement getItemCheckbox(String itemText) {
        return core().find(String.format(itemCheckbox, itemText));
    }

    /**
     * Moves selected items to the left list by clicking 'Move selected left' button.
     */
    @JDIAction("Move selected '{name}' items to the left list")
    public void moveItemsLeft() {
        core().find(moveLeftButton).click();
    }

    /**
     * Moves selected items to the right list by clicking 'Move selected right' button.
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
