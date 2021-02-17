package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.firstIndex;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman Iovlev on 24.09.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IGrid<T> extends HasValue, IsText, IList<T> {
    WebList webCells();

    default boolean isEmpty() { return count() == 0; }
    default boolean isNotEmpty() { return count() > 0; }
    default String getValue() { return getText(); }

    default WebList headerUI() { return webRow(1); }
    default WebList footerUI() { return null; }

    default List<String> header() {
        return headerUI().values();
    }
    default int size() { return header().size(); }
    default List<String> rowHeader() {
        List<String> header = new ArrayList<>();
        for (int i = 1; i <= count(); i++) {
            header.add(i+"");
        }
        return header;
    }
    default int count() { return rows().size(); }

    // region Rows
    default WebList webRow(int rowNum) {
        List<WebElement> row = new ArrayList<>();
        int startIndex = (rowNum-1)*size();
        for (int i = 0; i < size(); i++) {
             row.add(webCells().get(startIndex + i));
        }
        String cacheName = getName() + "  webRow" + rowNum;
        logger.debug("Row will be caches as %s", cacheName);
        return $$(row, getName() + " webRow");
    }
    default int getRowIndexByName(String rowName) {
        return firstIndex(rowHeader(), h -> ELEMENT.namesEqual.execute(h, rowName)) + 1;
    }
    default WebList webRow(String rowName) {
        return webRow(getRowIndexByName(rowName));
    }
    default WebList webRow(Enum rowName) {
        return webRow(getEnumValue(rowName));
    }

    default Line row(int rowNum) {
        return new Line(header(), webRow(rowNum));
    }
    default Line row(String rowName) {
        return row(getRowIndexByName(rowName));
    }
    default Line row(Enum rowName) {
        return row(getEnumValue(rowName));
    }
    default <D> List<D> rowsAs(Class<D> cl) {
        return LinqUtils.map(rows(), r -> r.asData(cl));
    }
    default <L> List<L> rowsLines(Class<L> cl) {
        return LinqUtils.map(rows(), r -> r.asLine(cl));
    }
    default List<Line> rows() {
        List<WebElement> webCells = webCells().getAll();
        List<Line> rows = new ArrayList<>();
        int k = 0;
        int i = 0;
        int size = size();
        List<String> header = header();
        List<WebElement> row = new ArrayList<>();
        while (k < webCells.size()) {
            row.add(webCells.get(k++));
            if (i == size - 1) {
                i = 0;
                rows.add(new Line(header, row));
                row = new ArrayList<>();
            } else {
                i++;
            }
        }
        return rows;
    }
    // endregion

    // region Columns
    default WebList webColumn(int colNum) {
        List<WebElement> column = new ArrayList<>();
        int size = size();
        int colIndex = colNum - 1;
        for (int i = 0; i < count(); i++) {
            column.add(webCells().get(colIndex + i*size));
        }
        String cacheName = getName() + "  webColumn" + colIndex;
        logger.debug("Row will be caches as %s", cacheName);
        return $$(column, cacheName);
    }
    default int getColIndexByName(String colName) {
        return firstIndex(header(), h -> ELEMENT.namesEqual.execute(h, colName)) + 1;
    }
    default WebList webColumn(String colName) {
        return webColumn(getColIndexByName(colName));
    }
    default WebList webColumn(Enum colName) {
        return webColumn(getEnumValue(colName));
    }

    default Line column(int colNum) {
        return new Line(rowHeader(), webColumn(colNum));
    }
    default Line column(String colName) {
        return column(getColIndexByName(colName));
    }
    default Line column(Enum colName) {
        return column(getEnumValue(colName));
    }
    default List<Line> columns() {
        List<WebElement> webCells = webCells().getAll();
        List<Line> columns = new ArrayList<>();
        int size = size();
        List<List<WebElement>> webColumns = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            webColumns.add(new ArrayList<>());
        }
        int k = 0;
        int i = 0;
        while (k < webCells.size()) {
            webColumns.get(i).add(webCells.get(k++));
            i = i == size - 1 ? 0 : i+1;
        }
        List<String> header = rowHeader();
        for (int j = 0; j < size; j++) {
            columns.add(new Line(header, webColumns.get(j)));
        }
        return columns;
    }
    // endregion

    // region Cells
    default UIElement webCell(int colNum, int rowNum) {
        return $(webCells().get((rowNum-1)*size() + colNum + 1));
    }
    default String cell(int colNum, int rowNum) {
        return webCell(colNum, rowNum).getText();
    }
    default String cell(String colName, int rowNum) {
        return cell(getColIndexByName(colName), rowNum);
    }
    default String cell(int colNum, String rowName) {
        return cell(colNum, getRowIndexByName(rowName));
    }
    default String cell(String colName, String rowName) {
        return cell(getColIndexByName(colName), getRowIndexByName(rowName));
    }
    // endregion

    // region Matchers
    //default Line row(Matcher<String> matcher) {
    //    return LinqUtils.first(rows(), matcher::matches);
    //}
    //default List<Line> rows(Matcher<? super String> matcher) {
    //    return LinqUtils.filter(rows(), matcher::matches);
    //}
    //default Line column(Matcher<String> matcher) {
    //    return LinqUtils.first(columns(), matcher::matches);
    //}
    //default List<Line> columns(Matcher<? super String> matcher) {
    //    return LinqUtils.filter(columns(), matcher::matches);
    //}
    //default UIElement cell(Matcher<String> matcher) {
    //    return LinqUtils.first(webCells(), matcher::matches);
    //}
    //default List<UIElement> cells(Matcher<? super String> matcher) {
    //    return LinqUtils.filter(webCells(), matcher::matches);
    //}
    // endregion

    // region TableMatchers
    // TODO
    // endregion

}
