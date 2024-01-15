package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableColumnFilter;
import org.hamcrest.Matchers;

public class MUITableColumnFilterAssert extends UIAssert<MUITableColumnFilterAssert, MUITableColumnFilter> {

    @JDIAction(value = "Check that '{name}' is exist", isAssert = true)
    public MUITableColumnFilterAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is not exist", isAssert = true)
    public MUITableColumnFilterAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

}
