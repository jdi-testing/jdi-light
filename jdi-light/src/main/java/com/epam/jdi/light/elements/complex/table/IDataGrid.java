package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;

/**
 * Created by Roman Iovlev on 24.09.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IDataGrid<L extends PageObject, D> extends IGrid {
    D rowAsData(WebList row);
    L rowAsLine(WebList row);

    // region Rows
    default D data(int rowNum) {
        return rowAsData(webRow(rowNum));
    }
    default D data(String rowName) {
        return rowAsData(webRow(rowName));
    }
    default D data(Enum rowName) {
        return rowAsData(webRow(rowName));
    }
    default List<D> allData() {
        return map(rows(), row -> rowAsData(row.uiElements()));
    }
    // endregion

    // region Lines
    default L line(int rowNum) {
        return rowAsLine(webRow(rowNum));
    }
    default L line(String rowName) {
        return rowAsLine(webRow(rowName));
    }
    default L line(Enum rowName) {
        return rowAsLine(webRow(rowName));
    }
    default List<L> lines() {
        return map(rows(), row -> rowAsLine(row.uiElements()));
    }
    // endregion

    // region Matchers
    default D data(Matcher<D> matcher) {
        return first(allData(), matcher::matches);
    }
    default List<D> datas(Matcher<D> matcher) {
        return filter(allData(), matcher::matches);
    }
    default L line(Matcher<L> matcher) {
        return first(lines(), matcher::matches);
    }
    default List<L> lines(Matcher<L> matcher) {
        return filter(lines(), matcher::matches);
    }
    // endregion
}
