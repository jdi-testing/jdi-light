package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.transferlist.EnhancedTransferList;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;

import com.jdiai.tools.Timer;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;

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
    @JDIAction("Assert that '{name}' item '{0}' is checked")
    public TransferListAssert checked(String itemText) {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked(itemText));
        jdiAssert(isChecked, Matchers.is(true), String.format("Element %s in Transferlist is not checked", itemText));
        return this;
    }

    /**
     * Checks that item with given text is unchecked.
     *
     * @param itemText text of the item that is expected to be unchecked
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' item '{0}' is unchecked")
    public TransferListAssert unchecked(String itemText) {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked(itemText));
        jdiAssert(isUnchecked, Matchers.is(true),
                String.format("Element %s in Transferlist is not unchecked", itemText));
        return this;
    }

    /**
     * Checks that items with given texts are moved to the right list.
     *
     * @param items expected text of items that moved to the right list
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' items {0} were moved to the right list")
    public TransferListAssert itemsMovedRight(String... items) {
        List<String> rightList = element().updateRightItems();
        jdiAssert(rightList.containsAll(Arrays.asList(items)), Matchers.is(true),
                String.format("Not all items are on right list, actual list is %s", StringUtils.join(rightList, ","))
        );
        return this;
    }

    /**
     * Checks that items with given texts are moved to the left list.
     *
     * @param items expected text of items that moved to the left list
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' items {0} were moved to the left list")
    public TransferListAssert itemsMovedLeft(String... items) {
        List<String> leftList = element().updateLeftItems();
        jdiAssert(leftList.containsAll(Arrays.asList(items)), Matchers.is(true),
                String.format("Not all items are on left list, actual list is %s", StringUtils.join(leftList, ","))
        );
        return this;
    }

    /**
     * Checks that 'Move selected right' button is enabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' 'Move selected right' button is enabled")
    public TransferListAssert isMoveRightButtonEnable() {
        jdiAssert(element().isMoveRightButtonEnabled() ? "Move right button is enabled" : "Move right button is disabled",
                Matchers.is("Move right button is enabled"));
        return this;
    }

    /**
     * Checks that 'Move selected right' button is disabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' 'Move selected right' button is disabled")
    public TransferListAssert isMoveRightDisabled() {
        jdiAssert(element().isMoveRightButtonDisabled(), Matchers.is(true),
                "Move to right is not disabled");
        return this;
    }

    /**
     * Checks that 'Move selected left' button is enabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' 'Move selected left' button is enabled")
    public TransferListAssert isMoveLeftEnabled() {
        jdiAssert(element().isMoveLeftButtonEnabled(), Matchers.is(true),
                "Move to left is not enabled");
        return this;
    }

    /**
     * Checks that 'Move selected left' button is disabled.
     *
     * @return this {@link TransferListAssert} instance
     */
    @JDIAction("Assert that '{name}' 'Move selected left' button is disabled")
    public TransferListAssert isMoveLeftDisabled() {
        jdiAssert(element().isMoveLeftButtonDisabled(), Matchers.is(true),
                "Move to left is not disabled");
        return this;
    }
}
