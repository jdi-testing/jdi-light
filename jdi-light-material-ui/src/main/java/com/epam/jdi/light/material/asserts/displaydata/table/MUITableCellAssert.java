package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableCell;
import org.hamcrest.Matchers;

public class MUITableCellAssert<A extends UIAssert<?, ?>, E extends MUITableCell<?>> extends UIAssert<A, E> {

    @JDIAction(value = "Check that '{name}' has row index {0}", isAssert = true)
    public MUITableCellAssert<A, E> rowIndex(int index) {
        SoftAssert.jdiAssert(element().rowIndex(), Matchers.is(index));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column index {0}", isAssert = true)
    public MUITableCellAssert<A, E> columnIndex(int index) {
        SoftAssert.jdiAssert(element().columnIndex(), Matchers.is(index));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is exist", isAssert = true)
    public MUITableCellAssert<A, E> exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is not exist", isAssert = true)
    public MUITableCellAssert<A, E> notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

}
