package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableHeader;
import org.hamcrest.Matchers;

public class MUITableHeaderAssert extends UIAssert<MUITableHeaderAssert, MUITableHeader> {

    @JDIAction("Check that '{name}' is exist")
    public MUITableHeaderAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' is not exist")
    public MUITableHeaderAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction("Check that '{name}' shows {0} rows as selected")
    public MUITableHeaderAssert selectedRows(int amount) {
        SoftAssert.jdiAssert(element().selectedRows(), Matchers.is(amount));
        return this;
    }

}
