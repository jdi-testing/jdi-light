package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.HasCache;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.firstIndex;
import static com.epam.jdi.tools.LinqUtils.listEquals;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class BaseTable<T extends BaseTable> extends JDIBase
        implements ISetup, HasValue, HasCache {
    protected By rowLocator = By.xpath("//tr[%s]/td");
    protected By columnLocator = By.xpath("//tr/td[%s]");
    protected By cellLocator = By.xpath("//tr[{1}]/td[{0}]");
    protected By allCellsLocator = By.cssSelector("td");
    protected By headerLocator = By.cssSelector("th");
    protected int rowHeaderIndex = -1;
    protected String rowHeaderName = "";
    protected int getRowHeaderIndex() {
        if (rowHeaderIndex == -1 && isNotBlank(rowHeaderName)) {
            int index = firstIndex(header(), h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(rowHeaderName)));
            if (index > -1)
                rowHeaderIndex = index + 1;
            else throw exception("Can't find rowHeader '%s' in 'header' [%s]. Please correct JTable params",
                    rowHeaderName, print(header()));
        }
        return rowHeaderIndex;
    }

    protected MapArray<String, List<UIElement>> rows = new MapArray<>();
    protected MapArray<String, List<UIElement>> columns = new MapArray<>();
    protected MapArray<String, MapArray<String, UIElement>> cells = new MapArray<>();
    // Amount of Rows
    protected CacheValue<Integer> count = new CacheValue<>(this::getCount);
    protected CacheValue<List<String>> header = new CacheValue<>(this::getHeader);
    protected CacheValue<List<String>> rowHeader = new CacheValue<>(this::getRowHeader);
    // Amount of Columns
    protected CacheValue<Integer> size = new CacheValue<>(this::getTableSize);

    public void setHeader(List<String> header) {
        this.header.setForce(header);
    }

    public JFunc1<String, String> SIMPLIFY = STRING_SIMPLIFY;
    private WebList headerUI() {
        return $$(headerLocator, this);
    }
    protected List<String> getHeader() {
        return LinqUtils.select(headerUI(), UIElement::getText);
    }
    @JDIAction("Get {name} header")
    public List<String> header() {
        return header.get();
    }

    protected List<String> getRowHeader() {
        if (getRowHeaderIndex() == -1) {
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= count(); i++)
                result.add(i+"");
            return result;
        }
        return LinqUtils.select(webColumn(getRowHeaderIndex()), UIElement::getText);
    }
    public List<String> rowHeader() {
        return rowHeader.get();
    }
    protected int getCount() {
        if (columns.any())
            return columns.get(0).value.size();
        WebList firstColumn = $$(fillByTemplate(columnLocator, 1), this)
            .noValidation();
        return firstColumn.size();
    }
    @JDIAction("Get {name} rows count")
    public int count() { return count.get(); }

    protected int getTableSize() {
        if (header.hasValue())
            return header.get().size();
        WebList header = headerUI().noValidation();
        return header.size();
    }
    public int size() { return size.get(); }

    public List<UIElement> webRow(int rowNum) {
        if (rowNum < 1)
            throw exception("Rows numeration starts from 1 (but requested index is %s)", rowNum);
        if (rowNum > count.get())
            throw exception("Table has %s rows (but requested index is %s)", count.get(), rowNum);
        if (!rows.has(rowNum+"")) {
            List<UIElement> result = gotTable
                ? LinqUtils.select(cells, c -> c.value.get(rowNum+""))
                : getRow(rowNum).elements();
            rows.add(rowNum+"", result);
        }
        return rows.get(rowNum+"");
    }
    public List<UIElement> webRow(String rowName) {
        return webRow(getRowIndexByName(rowName));
    }
    public List<UIElement> webRow(Enum rowName) {
        return webRow(getEnumValue(rowName));
    }
    public List<UIElement> webColumn(int colNum) {
        if (colNum < 1)
            throw exception("Columns numeration starts from 1 (but requested index is %s)", colNum);
        if (colNum > count.get())
            throw exception("Table has %s columns (but requested index is %s)", size.get(), colNum);
        if (!columns.has(colNum+"")) {
            List<UIElement> result = gotTable
                ? cells.get(colNum + "").values()
                : getColumn(colNum);
            columns.add(colNum + "", result);
        }
        return columns.get(colNum+"");
    }
    public List<UIElement> webColumn(String colName) {
        return webColumn(getColIndexByName(colName));
    }
    public List<UIElement> webColumn(Enum colName) {
        return webRow(getEnumValue(colName));
    }
    protected int getColIndexByName(String colName) {
        int colIndex = firstIndex(header.get(), h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(colName)));
        if (colIndex == -1)
            throw exception("Can't find column '%s'", colName);
        return colIndex + 1;
    }
    protected int getRowIndexByName(String rowName) {
        List<String> rowHeader = getRowHeaderIndex() == -1
            ? LinqUtils.select(webColumn(1), UIElement::getText)
            : rowHeader();
        int rowIndex = firstIndex(rowHeader, h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(rowName)));
        if (rowIndex == -1)
            throw exception("Can't find row '%s'", rowName);
        return rowIndex + 1;
    }
    public UIElement webCell(int colNum, int rowNum) {
        if (!gotTable) {
            if (rows.has(rowNum + ""))
                return rows.get(rowNum + "").get(colNum - 1);
            if (columns.has(colNum + ""))
                return columns.get(colNum + "").get(rowNum - 1);
            if (!cells.has(colNum + ""))
                cells.add(colNum + "", new MapArray<>(rowNum + "", getCell(colNum, rowNum)));
            else if (!cells.get(colNum + "").has(rowNum + ""))
                cells.get(colNum + "").add(rowNum + "", getCell(colNum, rowNum));
        }
        return cells.get(colNum+"").get(rowNum+"");
    }

    protected boolean gotRows = false;
    protected MapArray<String, List<UIElement>> getRows() {
        if (gotRows) return rows;
        MapArray<String, List<UIElement>> result = new MapArray<>();
        for (int i = 1; i <= count.get(); i++)
            result.add(i+"", webRow(i));
        gotRows = true;
        return rows = result;
    }
    protected WebList getRowByIndex(int rowNum) {
        return $$(fillByTemplate(rowLocator, rowNum), this).noValidation();
    }

    protected WebList getRow(int rowNum) {
        return getRowByIndex(getRowIndex(rowNum));
    }
    protected boolean gotColumns = false;
    protected MapArray<String, List<UIElement>> getColumns() {
        if (gotColumns) return columns;
        MapArray<String, List<UIElement>> result = new MapArray<>();
        for (int i = 1; i <= size.get(); i++)
            result.add(i+"", webColumn(i));
        gotColumns = true;
        return columns = result;
    }

    public WebList getColumn(int colNum) {
        return $$(fillByTemplate(columnLocator, colNum), this).noValidation();
    }
    protected UIElement getCell(int colNum, int rowNum) {
        return $(fillByMsgTemplate(cellLocator, colNum, getRowIndex(rowNum), this));
    }

    protected Boolean headerIsRow = null;
    protected int getRowIndex(int rowNum) {
        if (headerIsRow == null) {
            List<String> firstRow = getRowByIndex(1).values();
            headerIsRow = firstRow.isEmpty() || listEquals(header(), firstRow);
        }
        return headerIsRow ? rowNum + 1 : rowNum;
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTable.class, BaseTable.class))
            return;
        JTable j = field.getAnnotation(JTable.class);
        String rowHeader = j.rowHeader();
        List<String> header = asList(j.header());

        int size = j.size();
        int count = j.count();

        if (isNotBlank(j.root()))
            setLocator(defineLocator(j.root()));
        if (isNotBlank(j.row()))
            this.rowLocator = defineLocator(j.row());
        if (isNotBlank(j.column()))
            this.columnLocator = defineLocator(j.column());
        if (isNotBlank(j.cell()))
            this.cellLocator = defineLocator(j.cell());
        if (isNotBlank(j.allCells()))
            this.allCellsLocator = defineLocator(j.allCells());
        if (isNotBlank(j.headers()))
            this.headerLocator = defineLocator(j.headers());
        if (header.size() > 0)
            this.header.setFinal(header);
        if (size != -1)
            this.size.setFinal(size);
        if (count != -1)
            this.count.setFinal(count);
        if (isNotBlank(rowHeader))
            rowHeaderName = rowHeader;
    }

    protected boolean gotTable = false;

    public T getTable() {
        if (!gotTable) {
            try {
                List<WebElement> listOfCells = $$(allCellsLocator, parent)
                    .noValidation().getAll();
                cells = new MapArray<>();
                int k = 0;
                int j = 1;
                for (int i = 1; i <= size.get(); i++)
                    cells.add(i+"", new MapArray<>());
                while (k < listOfCells.size()) {
                    for (int i = 1; i <= size.get(); i++)
                        cells.get(i+"").add(j+"", new UIElement(listOfCells.get(k++)));
                    j++;
                }
                gotTable = true;
            } catch (Exception ex) {throw exception("Can't get all cells. " + ex.getMessage()); }
        }
        return (T) this;
    }

    public void refresh() {
        gotTable = false;
        gotRows = false;
        gotColumns = false;
        rows = new MapArray<>();
        columns = new MapArray<>();
        cells = new MapArray<>();
        count.clear();
        size.clear();
        header.clear();
        rowHeader.clear();
    }

    public void offCache() {
        count.useCache(false);
        size.useCache(false);
        header.useCache(false);
        rowHeader.useCache(false);
    }
}
