package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.transferlist.EnhancedTransferList;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;

import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link TransferList} and {@link EnhancedTransferList}.
 */
public class TransferListAssert extends UIAssert<TransferListAssert, TransferList> {

    /**
     * Checks that item with given text is checked.
     *
     * @param itemText text of the item that is expected to be checked
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' item '{0}' is checked", isAssert = true)
    public TransferListAssert checked(String itemText) {
        jdiAssert(element().isChecked(itemText), Matchers.is(true), String.format("Element %s in Transferlist is not checked", itemText));
        return this;
    }

    /**
     * Checks that item with given text is unchecked.
     *
     * @param itemText text of the item that is expected to be unchecked
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' item '{0}' is unchecked", isAssert = true)
    public TransferListAssert unchecked(String itemText) {
        jdiAssert(element().isUnchecked(itemText), Matchers.is(true),
                String.format("Element %s in Transferlist is not unchecked", itemText));
        return this;
    }

    /**
     * Checks that items with given texts are moved to the right list.
     *
     * @param items expected text of items that moved to the right list
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' items {0} were moved to the right list", isAssert = true)
    public TransferListAssert itemsMovedRight(String... items) {
        jdiAssert(element().updateRightItems(), Matchers.hasItems(items));
        return this;
    }

    /**
     * Checks that items with given texts are moved to the left list.
     *
     * @param items expected text of items that moved to the left list
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' items {0} were moved to the left list", isAssert = true)
    public TransferListAssert itemsMovedLeft(String... items) {
        jdiAssert(element().updateLeftItems(), Matchers.hasItems(items));
        return this;
    }

    /**
     * Checks that 'Move selected right' button is enabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' 'Move selected right' button is enabled", isAssert = true)
    public TransferListAssert isMoveRightButtonEnable() {
        jdiAssert(element().isMoveRightButtonEnabled(),
                Matchers.is(true), "Move right button is disabled");
        return this;
    }

    /**
     * Checks that 'Move selected right' button is disabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' 'Move selected right' button is disabled", isAssert = true)
    public TransferListAssert isMoveRightDisabled() {
        jdiAssert(element().isMoveRightButtonDisabled(), Matchers.is(true),
                "Move to right is enabled");
        return this;
    }

    /**
     * Checks that 'Move selected left' button is enabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' 'Move selected left' button is enabled", isAssert = true)
    public TransferListAssert isMoveLeftEnabled() {
        jdiAssert(element().isMoveLeftButtonEnabled(), Matchers.is(true),
                "Move to left is disabled");
        return this;
    }

    /**
     * Checks that 'Move selected left' button is disabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' 'Move selected left' button is disabled", isAssert = true)
    public TransferListAssert isMoveLeftDisabled() {
        jdiAssert(element().isMoveLeftButtonDisabled(), Matchers.is(true),
                "Move to left is enabled");
        return this;
    }
}
