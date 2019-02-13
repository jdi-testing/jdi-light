package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.TableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

public class Table extends BaseTable<Table> implements ISetup, HasValue {

    @JDIAction("Is '{name}' table empty")
    public boolean isEmpty() { return size() == 0; }
    @JDIAction("Is '{name}' table not empty")
    public boolean isNotEmpty() { return size() != 0; }

    // Rows
    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(int rowNum) {
        return new Line(webRow(rowNum), header());
    }
    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(String rowName) {
        return new Line(webRow(rowName), header());
    }
    public Line row(Enum rowName) {
        return row(getEnumValue(rowName));
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public Line row(TableMatcher... matchers) {
        WebList lines = TABLE_MATCHER.execute(this, matchers);
        if (lines == null || lines.size() == 0)
            return null;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < header().size(); i++)
            result.add(lines.get(i).getText());
        return new Line(result);
    }
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<Line> rows(TableMatcher... matchers) {
        List<String> lines = TABLE_MATCHER.execute(this, matchers).values();
        if (lines == null || lines.size() == 0)
            return null;
        List<Line> listOfLines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i <lines.size(); i++) {
            result.add(lines.get(i));
            if (result.size() == header().size()) {
                listOfLines.add(new Line(result));
                result.clear();
            }
        }
        return listOfLines;
    }
    @JDIAction("Get all '{name}' rows")
    public List<Line> rows() {
        return map(getRows(), row -> new Line(row.value, header()));
    }

    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<Line> filterRows(Matcher<String> matcher, Column column) {
        return filter(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<Line> filterRows(Pair<Matcher<String>, Column>... matchers) {
        return filter(rows(), line ->
                all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }

    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public Line row(Matcher<String> matcher, Column column) {
        return first(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }
    @JDIAction("Get '{name}' table row that match criteria")
    public Line row(Pair<Matcher<String>, Column>... matchers) {
        return first(rows(), line ->
                all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }
    // Columns
    @JDIAction("Get column '{0}' of '{name}' table")
    public Line column(int colNum) {
        return new Line(webColumn(colNum), rowHeader());
    }
    @JDIAction("Get column '{0}' of '{name}' table")
    public Line column(String colName) {
        return new Line(webColumn(colName), rowHeader());
    }
    public Line column(Enum colName) {
        return column(getEnumValue(colName));
    }
    @JDIAction("Get all '{name}' columns")
    public List<Line> columns() {
        return map(getColumns(), row -> new Line(row.value, rowHeader()));
    }
    // Cells
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(int colNum, int rowNum) {
        return webCell(colNum, rowNum).getText();
    }
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(String colName, int rowNum) {
        return cell(getColIndexByName(colName), rowNum);
    }
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(int colNum, String rowName) {
        return cell(colNum, getRowIndexByName(rowName));
    }
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(String colName, String rowName) {
        return cell(getColIndexByName(colName), getRowIndexByName(rowName));
    }
    public static JFunc1<String, String> TRIM_VALUE =
            el -> el.trim().replaceAll(" +", " ").replaceAll("\n", "\\\\n");
    public static JFunc1<String, String> TRIM_PREVIEW =
            el -> el.trim().replaceAll(" +", " ").replaceAll("\n", "");
    @JDIAction("Preview '{name}' table")
    public String preview() {
        return TRIM_PREVIEW.execute(get().getText());
    }
    @JDIAction("Get '{name}' table value")
    public String getValue() {
        getTable();
        String value = "||X||" + print(header.get(), "|") + "||" + LINE_BREAK;
        for (int i = 1; i <= count.get(); i++)
            value += "||" + i + "||" + print(map(row(i), TRIM_VALUE::execute), "|") + "||" + LINE_BREAK;
        return value;
    }

    public TableAssert is() {
        return new TableAssert(this);
    }
    public TableAssert assertThat() {
        return is();
    }
}
