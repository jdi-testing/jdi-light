package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.TransferList.TransferList;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.Arrays;

public class TransferListAssert extends UIAssert<TransferListAssert, TransferList> {

    @JDIAction("Assert that '{name}' is checked")
    public TransferListAssert checked(String itemText) {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked(itemText));
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public TransferListAssert unchecked(String itemText) {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked(itemText));
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that items was moved right")
    public TransferListAssert itemsMovedRight(String... items){
        jdiAssert(element().updateRightItems().containsAll(Arrays.asList(items)), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that items was moved left")
    public TransferListAssert itemsMovedLeft(String... items){
        jdiAssert(element().updateLeftItems().containsAll(Arrays.asList(items)), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that Move right button is enabled")
    public TransferListAssert isMoveRightButtonEnable(){
      jdiAssert(element().isMoveRightButtonEnable(), Matchers.is(true));
      return this;
    }

    @JDIAction("Assert that Move right button is disabled")
    public TransferListAssert isMoveRightButtonDisable(){
      jdiAssert(element().isMoveRightButtonDisable(), Matchers.is(true));
      return this;
    }

    @JDIAction("Assert that Move left button is enabled")
    public TransferListAssert isMoveLeftButtonEnable(){
        jdiAssert(element().isMoveLeftButtonEnable(), Matchers.is(true));
        return this;
      }

    @JDIAction("Assert that Move left button is disabled")
    public TransferListAssert isMoveLeftButtonDisable(){
      jdiAssert(element().isMoveLeftButtonDisable(), Matchers.is(true));
      return this;
    }
}
