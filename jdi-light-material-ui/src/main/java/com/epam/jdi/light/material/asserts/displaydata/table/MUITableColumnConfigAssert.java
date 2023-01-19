package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableColumnConfig;
import com.epam.jdi.light.material.elements.inputs.Switch;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

public class MUITableColumnConfigAssert extends UIAssert<MUITableColumnConfigAssert, MUITableColumnConfig> {

    @JDIAction("Check that '{name}' is exist")
    public MUITableColumnConfigAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' is not exist")
    public MUITableColumnConfigAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has switch with text '{0}'")
    public MUITableColumnConfigAssert switchElement(String labelText) {
        SoftAssert.jdiAssert(element().getSwitch(labelText).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has {0} switches")
    public MUITableColumnConfigAssert switchElements(int amount) {
        SoftAssert.jdiAssert(element().getSwitches().size(), Matchers.is(amount));
        return this;
    }

    @JDIAction("Check that '{name}' has switches with texts '{0}'")
    public MUITableColumnConfigAssert switchElements(List<String> texts) {
        List<String> switchTexts = element().getSwitches().stream()
                        .map(Switch::labelText)
                                .collect(Collectors.toList());
        SoftAssert.jdiAssert(switchTexts.containsAll(texts) ? "contains texts" : "don't contain texts", Matchers.is("contains texts"));
        return this;
    }

}
