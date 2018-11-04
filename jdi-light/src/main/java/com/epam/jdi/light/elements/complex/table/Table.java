package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.TableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.uiSearch;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.findByToBy;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.util.Arrays.asList;

public class Table extends JDIBase implements ISetup, HasValue {
    protected By rowsLocator = By.cssSelector("tr");
    protected By columnsLocator = By.cssSelector("td");
    protected By headerLocator = By.cssSelector("th");
    public CacheValue<List<String>> header = new CacheValue<>(() -> select($$(headerLocator, this), WebElement::getText));
    public CacheValue<Integer> size = new CacheValue<>(() -> header.get().size());
    public CacheValue<List<WebElement> > rows = new CacheValue<>(() -> {
        List<WebElement> value = uiSearch(get(),rowsLocator);
        if (uiSearch(value.get(0),columnsLocator).size() == 0 && uiSearch(value.get(1),columnsLocator).size() != 0)
            value.remove(0);
        return value;
    });

    public CacheValue<Integer> count = new CacheValue<>(() -> rows.get().size());

    public int size() {return rows.get().size(); }
    @JDIAction
    public boolean isEmpty() { return size() == 0; }
    @JDIAction
    public boolean isNotEmpty() { return size() != 0; }
    @JDIAction
    public List<String> header() {
        return header.getForce();
    }

    public List<WebElement> webRow(int rowNum) {
        return uiSearch(rows.get().get(rowNum-1), columnsLocator);
    }
    @JDIAction
    public Line row(int rowNum) {
        return new Line(webRow(rowNum));
    }
    public List<WebElement> webColumn(int colNum) {
        return select(rows.get(), r -> uiSearch(r,columnsLocator).get(colNum-1));
    }
    @JDIAction
    public Line column(int colNum) {
        return new Line(webColumn(colNum));
    }
    public List<WebElement> webColumn(String colName) {
        return webColumn(getColIndexByName(colName));
    }
    @JDIAction
    public Line column(String colName) {
        return new Line(webColumn(colName));
    }

    @JDIAction
    public List<Line> rows() {
        return map(rows.get(), r -> new Line(uiSearch(r,columnsLocator)));
    }
    @JDIAction
    public List<Line> filterRows(Matcher<String> matcher, Column column) {
        return filter(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }
    @JDIAction
    public List<Line> filterRows(Pair<Matcher<String>, Column>... matchers) {
        return filter(rows(), line ->
            all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }
    @JDIAction
    public Line row(Matcher<String> matcher, Column column) {
        return first(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }
    @JDIAction
    public Line row(Pair<Matcher<String>, Column>... matchers) {
        return first(rows(), line ->
                all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }

    private int getColIndexByName(String colName) {
        int colNum = firstIndex(header.get(), h -> simplify.execute(h).equals(simplify.execute(colName)));
        if (colNum == -1)
            throw exception("Can't find column '%s'", colName);
        return colNum + 1;
    }
    public JFunc1<String, String> simplify = STRING_SIMPLIFY;

    public WebElement webCell(int colNum, int rowNum) {
        return webRow(rowNum).get(colNum-1);
    }
    @JDIAction
    public String cell(int colNum, int rowNum) {
        return webCell(colNum, rowNum).getText();
    }
    public WebElement webCell(String colName, int rowNum) {
        return webCell(getColIndexByName(colName), rowNum);
    }
    @JDIAction
    public String cell(String colName, int rowNum) {
        return webCell(colName, rowNum).getText();
    }

    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTable.class, Table.class))
            return;
        JTable j = field.getAnnotation(JTable.class);
        By root = findByToBy(j.root());
        By row = findByToBy(j.row());
        By column = findByToBy(j.column());
        By headers = findByToBy(j.headers());
        List<String> header = asList(j.header());
        int size = j.size();
        int count = j.count();

        if (root != null)
            setLocator(root);
        if (row != null)
            this.rowsLocator = row;
        if (column != null)
            this.columnsLocator = column;
        if (headers != null)
            this.headerLocator = headers;
        if (header.size() > 0)
            this.header.set(header);
        if (size != -1)
            this.size.set(size);
        if (count != -1)
            this.count.set(count);
    }

    @JDIAction
    public String preview() {
        return get().getText();
    }
    @JDIAction
    public String getValue() {
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
