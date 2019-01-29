package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.fillByMsgTemplate;
import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.findByToBy;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.LinqUtils.firstIndex;
import static com.epam.jdi.tools.LinqUtils.listEquals;
import static java.util.Arrays.asList;

public abstract class BaseTable<T extends BaseTable> extends JDIBase implements ISetup, HasValue {
    protected By rowLocator = By.xpath("//tr[%s]/td");
    protected By columnLocator = By.xpath("//tr/td[%s]");
    protected By cellLocator = By.xpath("//tr[{1}]/td[{0}]");
    protected By allCellsLocator = By.cssSelector("td");
    protected By headerLocator = By.cssSelector("th");

    protected MapArray<String, List<UIElement>> rows = new MapArray<>();
    protected MapArray<String, List<UIElement>> columns = new MapArray<>();
    protected MapArray<String, MapArray<String, UIElement>> cells = new MapArray<>();
    // Amount of Columns
    protected CacheValue<Integer> count = new CacheValue<>(this::getCount);
    protected CacheValue<List<String>> header = new CacheValue<>(() -> LinqUtils.select($$(headerLocator, this), UIElement::getText));
    // Amount of Rows
    protected CacheValue<Integer> size = new CacheValue<>(() -> header.get().size());

    public void setHeader(List<String> header) {
        this.header.setForce(header);
    }

    public JFunc1<String, String> SIMPLIFY = STRING_SIMPLIFY;
    protected int getCount() {
        if (columns.any())
            return columns.get(0).value.size();
        return webColumn(1).size();
    }

    public List<UIElement> webRow(int rowNum) {
        if (!rows.has(rowNum+"")) {
            List<UIElement> result = gotTable
                ? LinqUtils.select(cells, c -> c.value.get(rowNum+""))
                : getRow(rowNum).elements();
            rows.add(rowNum+"", result);
        }
        return rows.get(rowNum+"");
    }
    public List<UIElement> webColumn(int colNum) {
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
    protected int getColIndexByName(String colName) {
        int colNum = firstIndex(header.get(), h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(colName)));
        if (colNum == -1)
            throw exception("Can't find column '%s'", colName);
        return colNum + 1;
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
        for (int i = 1; i <= size.get(); i++)
            result.add(i+"", webRow(i));
        return rows = result;
    }

    protected WebList getRow(int rowNum) {
        return $$(fillByTemplate(rowLocator, getRowIndex(rowNum)), this);
    }
    protected boolean gotColumns = false;
    protected MapArray<String, List<UIElement>> getColumns() {
        if (gotColumns) return columns;
        MapArray<String, List<UIElement>> result = new MapArray<>();
        for (int i = 1; i <= count.get(); i++)
            result.add(i+"", webColumn(i));
        return columns = result;
    }

    protected WebList getColumn(int colNum) {
        return $$(fillByTemplate(columnLocator, colNum), this);
    }
    protected UIElement getCell(int colNum, int rowNum) {
        return $(fillByMsgTemplate(cellLocator, colNum, getRowIndex(rowNum), this));
    }

    protected Boolean headerIsRow = null;
    protected int getRowIndex(int rowNum) {
        if (headerIsRow == null) {
            List<String> firstRow = $$(fillByTemplate(rowLocator, 1), this).values();
            headerIsRow = firstRow.isEmpty() || listEquals(header.get(), firstRow);
        }
        return headerIsRow ? rowNum + 1 : rowNum;
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTable.class, BaseTable.class))
            return;
        JTable j = field.getAnnotation(JTable.class);
        By root = findByToBy(j.root());
        By row = findByToBy(j.row());
        By column = findByToBy(j.column());
        By headers = findByToBy(j.headers());
        By cell = findByToBy(j.cell());
        By allCells = findByToBy(j.allCells());
        List<String> header = asList(j.header());
        int size = j.size();
        int count = j.count();

        if (root != null)
            setLocator(root);
        if (row != null)
            this.rowLocator = row;
        if (column != null)
            this.columnLocator = column;
        if (cell != null)
            this.cellLocator = cell;
        if (cell != null)
            this.allCellsLocator = allCells;
        if (headers != null)
            this.headerLocator = headers;
        if (header.size() > 0)
            this.header.setForce(header);
        if (size != -1)
            this.size.setForce(size);
        if (count != -1)
            this.count.setForce(count);
    }

    protected boolean gotTable = false;

    public T getTable() {
        if (!gotTable) {
            try {
                List<WebElement> listOfCells = $$(allCellsLocator, parent).getAll();
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
        header.clear();
        size.clear();
    }

}
