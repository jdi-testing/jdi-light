package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableFooter;
import org.hamcrest.Matchers;

public class MUITableFooterAssert extends UIAssert<MUITableFooterAssert, MUITableFooter> {

    @JDIAction("Check that '{name}' is exist")
    public MUITableFooterAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' is not exist")
    public MUITableFooterAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction("Check that '{name}' shows {0} rows as selected")
    public MUITableFooterAssert selectedRows(int amount) {
        SoftAssert.jdiAssert(element().selectedRows(), Matchers.is(amount));
        return this;
    }

    @JDIAction("Check that '{name}' current min row index is {0}")
    public MUITableFooterAssert currentMinRowIndex(int index) {
        SoftAssert.jdiAssert(element().currentMinRowIndex(), Matchers.is(index));
        return this;
    }

    @JDIAction("Check that '{name}' current max row index is {0}")
    public MUITableFooterAssert currentMaxRowIndex(int index) {
        SoftAssert.jdiAssert(element().currentMaxRowIndex(), Matchers.is(index));
        return this;
    }

    @JDIAction("Check that '{name}' current max row amount is {0}")
    public MUITableFooterAssert maxRowAmount(int amount) {
        SoftAssert.jdiAssert(element().maxRowAmount(), Matchers.is(amount));
        return this;
    }

}
