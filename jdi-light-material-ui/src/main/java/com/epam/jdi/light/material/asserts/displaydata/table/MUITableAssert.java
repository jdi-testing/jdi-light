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

    @JDIAction("Check that '{name}' is exist")
    public MUITableAssert exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' is not exist")
    public MUITableAssert notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction("Check that '{name}' is empty")
    public MUITableAssert empty() {
        SoftAssert.jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Check that '{name}' is not empty")
    public MUITableAssert notEmpty() {
        SoftAssert.jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is not empty"));
        return this;
    }

    @JDIAction("Check that '{name}' horizontal size {0}")
    public MUITableAssert horizontalSize(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().horizontalSize(), condition);
        return this;
    }

    @JDIAction("Check that '{name}' horizontal size is {0}")
    public MUITableAssert horizontalSize(int size) {
        return horizontalSize(Matchers.is(size));
    }

    @JDIAction("Check that '{name}' vertical size {0}")
    public MUITableAssert verticalSize(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().verticalSize(), condition);
        return this;
    }

    @JDIAction("Check that '{name}' vertical size is {0}")
    public MUITableAssert verticalSize(int size) {
        return verticalSize(Matchers.is(size));
    }

    @JDIAction("Check that '{name}' has row {0}")
    public MUITableAssert row(int index) {
        SoftAssert.jdiAssert(element().row(index).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has row with value '{1}' in column {0}")
    public MUITableAssert row(int columnIndex, String value) {
        SoftAssert.jdiAssert(element().row(columnIndex, value).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has row with value '{1}' in column '{0}'")
    public MUITableAssert row(String columnHeader, String value) {
        SoftAssert.jdiAssert(element().row(columnHeader, value).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has rows matching given condition")
    public MUITableAssert rows(Predicate<? super MUITableRow> predicate, Matcher<Integer> condition) {
        SoftAssert.jdiAssert((int) element().rows().stream().filter(predicate).count(), condition);
        return this;
    }

    @JDIAction("Check that '{name}' has column '{0}' with cell type '{1}'")
    public <T extends MUITableCell<?>> MUITableAssert column(String columnHeader, Class<T> cellType) {
        SoftAssert.jdiAssert(element().column(columnHeader, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has column {0} with cell type '{1}'")
    public <T extends MUITableCell<?>> MUITableAssert column(int index, Class<T> cellType) {
        SoftAssert.jdiAssert(element().column(index, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has column with value '{1}' and cell type '{2}' in row {0}")
    public <T extends MUITableCell<?>> MUITableAssert column(int rowIndex, String value, Class<T> cellType) {
        SoftAssert.jdiAssert(element().column(rowIndex, value, cellType).isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has columns with cell type '{0}' matching given condition")
    public <T extends MUITableCell<?>> MUITableAssert columns(Class<T> cellType, Predicate<? super MUITableColumn<T>> predicate, Matcher<Integer> condition) {
        SoftAssert.jdiAssert((int) element().columns(cellType).stream().filter(predicate).count(), condition);
        return this;
    }

    @JDIAction("Check that '{name}' has columns '{0}'")
    public MUITableAssert columns(List<String> columnHeaders) {
        List<String> allHeaders = element().row(0).cells().stream()
                .map(MUITableDefaultCell::getText)
                .collect(Collectors.toList());
        SoftAssert.jdiAssert(allHeaders.containsAll(columnHeaders) ? "contains headers" : "don't contain headers", Matchers.is("contains headers"));
        return this;
    }

    @JDIAction("Check that '{name}' has column menu shown")
    public MUITableAssert columnMenu() {
        SoftAssert.jdiAssert(element().columnMenu().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has table header")
    public MUITableAssert tableHeader() {
        SoftAssert.jdiAssert(element().tableHeader().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has table footer")
    public MUITableAssert tableFooter() {
        SoftAssert.jdiAssert(element().tableFooter().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has column filter shown")
    public MUITableAssert columnFilter() {
        SoftAssert.jdiAssert(element().columnFilter().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction("Check that '{name}' has column config shown")
    public MUITableAssert columnConfig() {
        SoftAssert.jdiAssert(element().columnConfig().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

}
