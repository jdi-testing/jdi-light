package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.ColumnSorting;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableCell;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableColumn;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

public class MUITableColumnAssert<T extends MUITableCell<?>>
        extends MUITableCellContainerAssert<MUITableColumnAssert<T>, MUITableColumn<T>> {

    @JDIAction("Check that '{name}' is sorted")
    public MUITableColumnAssert<T> sorted() {
        SoftAssert.jdiAssert(element().isSorted() ? "sorted" : "unsorted", Matchers.is("sorted"));
        return this;
    }

    @JDIAction("Check that '{name}' is unsorted")
    public MUITableColumnAssert<T> unsorted() {
        SoftAssert.jdiAssert(!element().isSorted() ? "unsorted" : "sorted", Matchers.is("unsorted"));
        return this;
    }

    @JDIAction("Check that '{name}' has sorting '{0}'")
    public MUITableColumnAssert<T> sorting(ColumnSorting columnSorting) {
        SoftAssert.jdiAssert(element().sorting(), Matchers.is(columnSorting));
        return this;
    }

    @JDIAction("Check that '{name}' has cell in row {0}")
    public MUITableColumnAssert<T> cell(int rowIndex) {
        SoftAssert.jdiAssert(element().cell(rowIndex).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has cell with text '{0}'")
    public MUITableColumnAssert<T> cell(String text) {
        SoftAssert.jdiAssert(element().cell(text).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has cells {0}")
    public MUITableColumnAssert<T> cells(Matcher<List<T>> condition) {
        SoftAssert.jdiAssert(element().cells(), condition);
        return this;
    }

}
