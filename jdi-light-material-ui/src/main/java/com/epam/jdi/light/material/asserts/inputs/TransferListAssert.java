package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.transferlist.TransferList;

import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.Arrays;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TransferListAssert extends UIAssert<TransferListAssert, TransferList> {

    @JDIAction("Assert that '{name}' is checked")
    public TransferListAssert checked(String itemText) {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked(itemText));
        jdiAssert(isChecked ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public TransferListAssert unchecked(String itemText) {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked(itemText));
        jdiAssert(isUnchecked ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction("Assert that '{name}' items were moved right")
    public TransferListAssert itemsMovedRight(String... items) {
        jdiAssert(element().updateRightItems().containsAll(Arrays.asList(items)) ? "items moved right" : "items didn't move right",
                Matchers.is("items moved right"));
        return this;
    }

    @JDIAction("Assert that '{name}' items were moved left")
    public TransferListAssert itemsMovedLeft(String... items) {
        jdiAssert(element().updateLeftItems().containsAll(Arrays.asList(items)) ? "items moved left" : "items didn't move left",
                Matchers.is("items moved left"));
        return this;
    }

    @JDIAction("Assert that '{name}' 'Move right' button is enabled")
    public TransferListAssert isMoveRightButtonEnable() {
        jdiAssert(element().isMoveRightButtonEnabled() ? "Move right button is enabled" : "Move right button is disabled",
                Matchers.is("Move right button is enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' 'Move right' button is disabled")
    public TransferListAssert isMoveRightButtonDisable() {
        jdiAssert(element().isMoveRightButtonDisabled() ? "Move right button is disabled" : "Move right button is enabled",
                Matchers.is("Move right button is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' 'Move left' button is enabled")
    public TransferListAssert isMoveLeftButtonEnable() {
        jdiAssert(element().isMoveLeftButtonEnabled() ? "Move left button is enabled" : "Move left button is disabled",
                Matchers.is("Move left button is enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' 'Move left' button is disabled")
    public TransferListAssert isMoveLeftButtonDisable() {
        jdiAssert(element().isMoveLeftButtonDisabled() ? "Move left button is disabled" : "Move left button is enabled",
                Matchers.is("Move left button is disabled"));
        return this;
    }
}


