package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

public abstract class MUITableCell<A extends UIAssert<?, ?>> extends UIBaseElement<A> implements HasAssert<A> {

    private final int rowIndex;
    private final int columnIndex;

    protected MUITableCell(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    @JDIAction("Check that '{name}' is exist")
    public boolean isExist() {
        if (rowIndex < 0 || columnIndex <= 0) {
            return false;
        } else {
            return core().isDisplayed();
        }
    }

    @JDIAction("Get '{name}' row index")
    public int rowIndex() {
        return rowIndex;
    }

    @JDIAction("Get '{name}' column index")
    public int columnIndex() {
        return columnIndex;
    }

}
