package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.IHasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.findByToBy;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.LinqUtils.firstIndex;
import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.util.Arrays.asList;

public class Table extends JDIBase implements ISetup, IHasValue {
    protected By rowsLocator = By.cssSelector("tr");
    protected By columnsLocator = By.cssSelector("td");
    protected By headerLocator = By.cssSelector("th");
    protected List<String> headers;
    protected List<String> getHeaders() {
        if (headers == null)
            headers = select(getDriver().findElements(headerLocator), WebElement::getText);
        return headers;
    }
    protected int size = -1;
    public int getSize() {
        if (size == -1)
            size = getHeaders().size();
        return size;
    }
    protected int count = -1;
    public int getCount() {
        if (count == -1)
            count = getRows().size();
        return count;
    }

    public List<WebElement> webRow(int rowNum) {
        return getRows().get(rowNum)
                .findElements(columnsLocator);
    }
    @JDIAction
    public Line row(int rowNum) {
        return new Line(webRow(rowNum));
    }
    public List<WebElement> webColumn(int colNum) {
        return select(getRows(), r -> r.findElements(columnsLocator).get(colNum));
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
    private int getColIndexByName(String colName) {
        int colNum = firstIndex(headers, h -> h.equals(colName));
        if (colNum == -1)
            throw exception("Can't find column '%s'", colName);
        return colNum;
    }
    private List<WebElement> getRows() {
        return getDriver().findElement(getLocator()).findElements(rowsLocator);
    }

    public WebElement webCell(int colNum, int rowNum) {
        return webRow(rowNum).get(colNum);
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

        if (root != null)
            setLocator(root);
        if (row != null)
            this.rowsLocator = row;
        if (column != null)
            this.columnsLocator = column;
        if (headers != null)
            this.headerLocator = headers;
        if (header.size() > 0)
            this.headers = header;
        if (size != -1)
            this.size = size;
    }

    public String getValue() {
        int i = 1;
        String value = "||X||" + select(getHeaders(), h -> h + "|") + "|" + LINE_BREAK;
        for (WebElement row : getRows()) {
            value += "||" + i++ + "||";
            for (WebElement cell : row.findElements(columnsLocator))
                value += cell.getText() + "|";
            value += "|" + LINE_BREAK;
        }
        return value;
    }
}
