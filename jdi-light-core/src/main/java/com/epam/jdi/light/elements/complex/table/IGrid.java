package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.jdiai.tools.LinqUtils;
import com.jdiai.tools.PrintUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.EnumUtils.getEnumValue;
import static com.jdiai.tools.LinqUtils.firstIndex;
import static com.jdiai.tools.StringUtils.LINE_BREAK;
import static com.jdiai.tools.StringUtils.format;

/**
 * Created by Roman Iovlev on 24.09.2020
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IGrid<T> extends HasValue, IsText, IList<T> {
    WebList webCells();

    default boolean isEmpty() { return count() == 0; }
    default boolean isNotEmpty() { return count() > 0; }
    default String getValue() { return getText(); }
    default String print() {
        String output = "||X||" + PrintUtils.print(header(), "|") + "||" + LINE_BREAK;
        List<Line> rows = rows();
        for (int i = 0; i < rows.size(); i++) {
            output += "||" + rowHeader().get(i) + "||" + PrintUtils.print(rows.get(i), "|") + "||" + LINE_BREAK;
        }
        return output;
    }

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
        if (rowNum < 0) {
            throw runtimeException("Failed to find webRow. Index should be >= 0");
        }
        List<WebElement> row = new ArrayList<>();
        if (size() != 0) {
            int startIndex = (rowNum - 1) * size();
            for (int i = 0; i < size(); i++) {
                row.add(webCells().get(startIndex + i));
            }
        }
        return $$(row, format("%s row:%s", getName(), rowNum));
    }
    default int getRowIndexByName(String rowName) {
        List<String> rowsHeader = rowHeader();
        if (rowsHeader.isEmpty()) {
            throw runtimeException("Failed to getRowIndexByName. rowsHeader is empty");
        }
        int index = firstIndex(rowsHeader, h -> ELEMENT.namesEqual.execute(h, rowName));
        if (index == -1) {
            throw runtimeException("Failed to getRowIndexByName. rowsHeader[%s] has no element '%s'", PrintUtils.print(rowsHeader), rowName);
        }
        return index + 1;
    }
    default WebList webRow(String rowName) {
        return webRow(getRowIndexByName(rowName));
    }
    default WebList webRow(Enum<?> rowName) {
        return webRow(getEnumValue(rowName));
    }

    default Line row(int rowNum) {
        return new Line(header(), webRow(rowNum), getName() + " line[" + rowNum + "]");
    }
    default Line row(String rowName) {
        return row(getRowIndexByName(rowName));
    }
    default Line row(Enum<?> rowName) {
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
        int j = 1;
        int size = size();
        List<String> header = header();
        List<WebElement> row = new ArrayList<>();
        while (k < webCells.size()) {
            row.add(webCells.get(k++));
            if (i == size - 1) {
                i = 0;
                rows.add(new Line(header, row, getName() + " line[" + j++ + "]"));
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
        return $$(column, format("%s column:%s", getName(), colIndex));
    }
    default int getColIndexByName(String colName) {
        int index = firstIndex(header(), h -> ELEMENT.namesEqual.execute(h, colName));
        if (index == -1) {
            throw runtimeException("Column '%s' was not found", colName);
        }
        return index + 1;
    }
    default WebList webColumn(String colName) {
        return webColumn(getColIndexByName(colName));
    }
    default WebList webColumn(Enum<?> colName) {
        return webColumn(getEnumValue(colName));
    }

    default Line column(int colNum) {
        return new Line(rowHeader(), webColumn(colNum), getName() + " column[" + colNum + "]");
    }
    default Line column(String colName) {
        return column(getColIndexByName(colName));
    }
    default Line column(Enum<?> colName) {
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
            columns.add(new Line(header, webColumns.get(j), getName() + " column[" + (j+1) + "]"));
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
