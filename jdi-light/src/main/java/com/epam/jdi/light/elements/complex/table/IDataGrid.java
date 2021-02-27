package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;

/**
 * Created by Roman Iovlev on 24.09.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IDataGrid<L extends PageObject, D> extends HasGrid, ICoreElement, IList<D> {
    D rowAsData(WebList row);
    L rowAsLine(WebList row);

    default boolean isEmpty() { return grid().isEmpty(); }
    default int count() { return grid().count(); }
    default List<String> header() {
        return grid().header();
    }
    default int size() {
        return grid().size();
    }

    default UIElement webCell(int colNum, int rowNum) {
        return grid().webCell(colNum, rowNum);
    }
    default WebList webRow(int rowNum) {
        return grid().webRow(rowNum);
    }
    default WebList footerUI() {
        return grid().footerUI();
    }
    default WebList webColumn(int colNum) {
        return grid().webColumn(colNum);
    }
    // region Rows
    default D data(int rowNum) {
        return rowAsData(grid().webRow(rowNum));
    }
    default D data(String rowName) {
        return rowAsData(grid().webRow(rowName));
    }
    default D data(Enum rowName) {
        return rowAsData(grid().webRow(rowName));
    }
    default List<D> allData() {
        return LinqUtils.map(grid().rows(), row -> rowAsData(row.uiElements()));
    }
    default WebList webColumn(String colName) {
        return grid().webColumn(colName);
    }
    // endregion

    // region Lines
    default L line(int rowNum) {
        return rowAsLine(grid().webRow(rowNum));
    }
    default L line(String rowName) {
        return rowAsLine(grid().webRow(rowName));
    }
    default L line(Enum rowName) {
        return rowAsLine(grid().webRow(rowName));
    }
    default List<L> lines() {
        return LinqUtils.map(grid().rows(), row -> rowAsLine(row.uiElements()));
    }
    // endregion

    // region Matchers
    default D data(Matcher<D> matcher) {
        return first(matcher::matches);
    }
    default D data(JFunc1<D, Boolean> matcher) { return first(matcher); }
    default List<D> dataList(Matcher<D> matcher) { return filter(matcher::matches); }
    default List<D> dataList(JFunc1<D, Boolean> matcher) { return filter(matcher); }
    default L line(Matcher<L> matcher) {
        return LinqUtils.first(lines(), matcher::matches);
    }
    default List<L> lines(Matcher<L> matcher) {
        return LinqUtils.filter(lines(), matcher::matches);
    }
    // endregion
}
