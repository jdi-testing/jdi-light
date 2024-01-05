package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITable;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableCell;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableColumn;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableDefaultCell;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableRow;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MUITableAssert extends UIAssert<MUITableAssert, MUITable> {

    @JDIAction(value = "Check that '{name}' is exist", isAssert = true)
    public MUITableAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is not exist", isAssert = true)
    public MUITableAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is empty", isAssert = true)
    public MUITableAssert empty() {
        SoftAssert.jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is not empty", isAssert = true)
    public MUITableAssert notEmpty() {
        SoftAssert.jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is not empty"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' horizontal size {0}", isAssert = true)
    public MUITableAssert horizontalSize(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().horizontalSize(), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' horizontal size is {0}", isAssert = true)
    public MUITableAssert horizontalSize(int size) {
        return horizontalSize(Matchers.is(size));
    }

    @JDIAction(value = "Check that '{name}' vertical size {0}", isAssert = true)
    public MUITableAssert verticalSize(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().verticalSize(), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' vertical size is {0}", isAssert = true)
    public MUITableAssert verticalSize(int size) {
        return verticalSize(Matchers.is(size));
    }

    @JDIAction(value = "Check that '{name}' has row {0}", isAssert = true)
    public MUITableAssert row(int index) {
        SoftAssert.jdiAssert(element().row(index).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has row with value '{1}' in column {0}", isAssert = true)
    public MUITableAssert row(int columnIndex, String value) {
        SoftAssert.jdiAssert(element().row(columnIndex, value).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has row with value '{1}' in column '{0}'", isAssert = true)
    public MUITableAssert row(String columnHeader, String value) {
        SoftAssert.jdiAssert(element().row(columnHeader, value).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has rows matching given condition", isAssert = true)
    public MUITableAssert rows(Predicate<? super MUITableRow> predicate, Matcher<Integer> condition) {
        SoftAssert.jdiAssert((int) element().rows().stream().filter(predicate).count(), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column '{0}' with cell type '{1}'", isAssert = true)
    public <T extends MUITableCell<?>> MUITableAssert column(String columnHeader, Class<T> cellType) {
        SoftAssert.jdiAssert(element().column(columnHeader, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column {0} with cell type '{1}'", isAssert = true)
    public <T extends MUITableCell<?>> MUITableAssert column(int index, Class<T> cellType) {
        SoftAssert.jdiAssert(element().column(index, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column with value '{1}' and cell type '{2}' in row {0}", isAssert = true)
    public <T extends MUITableCell<?>> MUITableAssert column(int rowIndex, String value, Class<T> cellType) {
        SoftAssert.jdiAssert(element().column(rowIndex, value, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has columns with cell type '{0}' matching given condition", isAssert = true)
    public <T extends MUITableCell<?>> MUITableAssert columns(Class<T> cellType, Predicate<? super MUITableColumn<T>> predicate, Matcher<Integer> condition) {
        SoftAssert.jdiAssert((int) element().columns(cellType).stream().filter(predicate).count(), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' has columns '{0}'", isAssert = true)
    public MUITableAssert columns(List<String> columnHeaders) {
        List<String> allHeaders = element().tableHeader().headerRows().get(0).cells().stream()
                .map(MUITableDefaultCell::getText)
                .collect(Collectors.toList());
        SoftAssert.jdiAssert(allHeaders.containsAll(columnHeaders) ? "contains headers" : "don't contain headers", Matchers.is("contains headers"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column menu shown", isAssert = true)
    public MUITableAssert columnMenu() {
        SoftAssert.jdiAssert(element().columnMenu().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has table header", isAssert = true)
    public MUITableAssert tableHeader() {
        SoftAssert.jdiAssert(element().tableHeader().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has table footer", isAssert = true)
    public MUITableAssert tableFooter() {
        SoftAssert.jdiAssert(element().tableFooter().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column filter shown", isAssert = true)
    public MUITableAssert columnFilter() {
        SoftAssert.jdiAssert(element().columnFilter().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has column config shown", isAssert = true)
    public MUITableAssert columnConfig() {
        SoftAssert.jdiAssert(element().columnConfig().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

}
