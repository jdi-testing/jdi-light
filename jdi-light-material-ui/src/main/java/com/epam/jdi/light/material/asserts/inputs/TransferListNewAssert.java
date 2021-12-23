package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.TransferListNew;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TransferListNewAssert extends UIAssert<TransferListNewAssert, TransferListNew> {

    @JDIAction("Assert that all '{name}' left list items are checked")
    public TransferListNewAssert allLeftListItemsChecked() {
        int checkedLeftItems = (int) element().leftList().items().stream()
                .filter(item -> item.checkbox().isChecked())
                .count();
        String allCheckedState = checkedLeftItems == element().leftList().size() ?
                "All left list items are checked" : "There are unchecked items in the left list";
                jdiAssert(allCheckedState, Matchers.is("All left list items are checked"));
                return this;
    }

    @JDIAction("Assert that all '{name}' right list items are checked")
    public TransferListNewAssert allRightListItemsChecked() {
        int checkedRightItems = (int) element().rightList().items().stream()
                .filter(item -> item.checkbox().isChecked())
                .count();
        String allCheckedState = checkedRightItems == element().rightList().size() ?
                "All right list items are checked" : "There are unchecked items in the right list";
        jdiAssert(allCheckedState, Matchers.is("All right list items are checked"));
        return this;
    }

    @JDIAction("Assert that all '{name}' left list items are unchecked")
    public TransferListNewAssert allLeftListItemsUnchecked() {
        int uncheckedLeftItems = (int) element().leftList().items().stream()
                .filter(item -> item.checkbox().isUnchecked())
                .count();
        String allCheckedState = uncheckedLeftItems == element().leftList().size() ?
                "All left list items are unchecked" : "There are checked items in the left list";
        jdiAssert(allCheckedState, Matchers.is("All left list items are unchecked"));
        return this;
    }

    @JDIAction("Assert that all '{name}' right list items are unchecked")
    public TransferListNewAssert allRightListItemsUnchecked() {
        int uncheckedRightItems = (int) element().rightList().items().stream()
                .filter(item -> item.checkbox().isUnchecked())
                .count();
        String allCheckedState = uncheckedRightItems == element().rightList().size() ?
                "All right list items are unchecked" : "There are checked items in the right list";
        jdiAssert(allCheckedState, Matchers.is("All right list items are unchecked"));
        return this;
    }
}
