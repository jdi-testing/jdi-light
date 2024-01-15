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

    @JDIAction(value = "Check that '{name}' is exist", isAssert = true)
    public MUITableColumnConfigAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is not exist", isAssert = true)
    public MUITableColumnConfigAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has switch with text '{0}'", isAssert = true)
    public MUITableColumnConfigAssert switchElement(String labelText) {
        SoftAssert.jdiAssert(element().getSwitch(labelText).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has {0} switches", isAssert = true)
    public MUITableColumnConfigAssert switchElements(int amount) {
        SoftAssert.jdiAssert(element().getSwitches().size(), Matchers.is(amount));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has switches with texts '{0}'", isAssert = true)
    public MUITableColumnConfigAssert switchElements(List<String> texts) {
        List<String> switchTexts = element().getSwitches().stream()
                        .map(Switch::labelText)
                                .collect(Collectors.toList());
        SoftAssert.jdiAssert(switchTexts.containsAll(texts) ? "contains texts" : "don't contain texts", Matchers.is("contains texts"));
        return this;
    }

}
