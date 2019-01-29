package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.TableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.elements.complex.table.TableMatcher.getMatchLines;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

public class Table extends BaseTable<Table> implements ISetup, HasValue {
    public int size() {
        if (rows.any())
            return rows.get(0).value.size();
        return webRow(1).size();
    }

    @JDIAction("Is '{name}' table empty")
    public boolean isEmpty() { return size() == 0; }
    @JDIAction("Is '{name}' table not empty")
    public boolean isNotEmpty() { return size() != 0; }
    @JDIAction("Get '{name}' table header")
    public List<String> header() {
        return header.get();
    }

    // Rows
    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(int rowNum) {
        return new Line(webRow(rowNum), header());
    }
// TODO ???
    @JDIAction("Get first '{name}' table row that match criteria")
    public Line row(TableMatcher... matchers) {
        WebList lines = getMatchLines(this, matchers);
        if (lines == null || lines.size() == 0)
            return null;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < header().size(); i++)
            result.add(lines.get(i).getText());
        return new Line(result);
    }
// TODO ???
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<Line> rows(TableMatcher... matchers) {
        List<String> lines = getMatchLines(this, matchers).values();
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
        return new Line(webColumn(colNum), header());
    }
    @JDIAction("Get column '{0}' of '{name}' table")
    public Line column(String colName) {
        return new Line(webColumn(colName), header());
    }
    @JDIAction("Get all '{name}' columns")
    public List<Line> columns() {
        return map(getColumns(), row -> new Line(row.value, header()));
    }
    // Cells
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(int colNum, int rowNum) {
        return webCell(colNum, rowNum).getText();
    }
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(String colName, int rowNum) {
        return webCell(getColIndexByName(colName), rowNum).getText();
    }

    @JDIAction("Preview '{name}' table")
    public String preview() {
        return get().getText();
    }

    @JDIAction("Get '{name}' table value")
    public String getValue() {
        getTable();
        String value = "||X||" + print(header.get(), "|") + "||" + LINE_BREAK;
        for (int i = 1; i <= count.get(); i++)
            value += "||" + i + "||" + print(row(i), "|") + "||" + LINE_BREAK;
        return value;
    }

    public TableAssert is() {
        return new TableAssert(this);
    }
    public TableAssert assertThat() {
        return is();
    }
}
