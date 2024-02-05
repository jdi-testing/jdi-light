package com.epam.jdi.light.material.asserts.displaydata.table;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableCell;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableRow;

public class MUITableRowAssert extends MUITableCellContainerAssert<MUITableRowAssert, MUITableRow> {

    @JDIAction(value = "Check that '{name}' has cell of type '{1}' in row {0}", isAssert = true)
    public <T extends MUITableCell<?>> MUITableRowAssert cell(int columnIndex, Class<T> cellType) {
        SoftAssert.jdiAssert(element().cell(columnIndex, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has cell of type '{1}' with text '{0}'", isAssert = true)
    public <T extends MUITableCell<?>> MUITableRowAssert cell(String text, Class<T> cellType) {
        SoftAssert.jdiAssert(element().cell(text, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has default type cell in row {0}", isAssert = true)
    public MUITableRowAssert cell(int columnIndex) {
        SoftAssert.jdiAssert(element().cell(columnIndex).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has default type cell with text '{0}'", isAssert = true)
    public MUITableRowAssert cell(String text) {
        SoftAssert.jdiAssert(element().cell(text).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has cells of type '{0}' {1}", isAssert = true)
    public <T extends MUITableCell<?>> MUITableRowAssert cells(Class<T> cellType, Matcher<List<? extends MUITableCell<?>>> condition) {
        SoftAssert.jdiAssert(element().cells(cellType), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' has default type cells {0}", isAssert = true)
    public MUITableRowAssert cells(Matcher<List<? extends MUITableCell<?>>> condition) {
        SoftAssert.jdiAssert(element().cells(), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' row cells text matches {0}", isAssert = true)
    public MUITableRowAssert cellsMatch(List<String> cellsValueExpected) {
        SoftAssert.jdiAssert(element().cellsText(), Matchers.contains(cellsValueExpected.toArray(new String[0])));
        return this;
    }

    @JDIAction(value = "Check that '{name}' row cells text does not match {0}", isAssert = true)
    public MUITableRowAssert cellsDontMatch(List<String> cellsValueExpected) {
        SoftAssert.jdiAssert(element().cellsText(),
                Matchers.not(Matchers.contains(cellsValueExpected.toArray(new String[0]))));
        return this;
    }
}
