package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.table.BaseTableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.JDebug;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IHasSize;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasRefresh;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.driver.WebDriverFactory.hasRunDrivers;
import static com.epam.jdi.light.elements.complex.WebList.newList;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;
import static java.util.Arrays.*;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class BaseTable<T extends BaseTable<?,?>, A extends BaseTableAssert<?,?>> extends UIBaseElement<A>
        implements ISetup, HasValue, HasAssert<A>, IHasSize, IsText, HasRefresh {
    protected By rowLocator = By.xpath("//tbody//tr[%s]/td");
    protected By columnLocator = By.xpath("//tbody//tr/td[%s]");
    protected By cellLocator = By.xpath("//tbody//tr[{1}]/td[{0}]");
    protected By allCellsLocator = By.cssSelector("tbody td");
    protected By jsRow = By.cssSelector("tbody tr");
    protected By jsColumn = By.cssSelector("td");
    protected By headerLocator = By.cssSelector("th");
    protected By footer = By.cssSelector("tfoot");
    protected By fromCellToRow = By.xpath("../td");
    protected By filterLocator = By.cssSelector("th input[type=search],th input[type=text]");
    protected int rowHeaderIndex = -1;
    protected int shiftColumnIndex = -1;
    protected int shiftRowIndex = -1;
    protected Safe<List<Integer>> columnsMapping = new Safe<>(ArrayList::new);
    protected String rowHeaderName = "";
    protected int startIndex = ELEMENT.startIndex;
    public JFunc1<String, String> SIMPLIFY = ELEMENT.simplifyString;
    protected boolean locatorsValidated = false;

    protected CacheAll<MapArray<String, WebList>> rows
            = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, WebList>> columns
            = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, MapArray<String, UIElement>>> cells
            = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, MapArray<String, String>>> cellsValues
            = new CacheAll<>(MapArray::new);
    // Amount of Rows
    protected CacheValue<Integer> count = new CacheValue<>(this::getCount);
    protected CacheValue<List<String>> header = new CacheValue<>(this::getHeader);
    protected CacheValue<List<String>> rowHeader = new CacheValue<>(this::getRowHeader);
    // Amount of Columns
    protected CacheValue<Integer> size = new CacheValue<>(this::getTableSize);

    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int index) {
        startIndex = index;
    }

    @Override
    public UIElement core() {
        UIElement core = super.core();
        if (hasRunDrivers() && !locatorsValidated && core.firstChild() != null) {
            try {
                locatorsValidated = true;
                validateLocators(core);
            } catch (Exception ex) {
                locatorsValidated = false;
            }
        }
        return core;
    }
    protected void validateLocators(UIElement core) {
        if (getByLocator(headerLocator).equals("th")) {
            if (core.finds("th").size() == 0) {
                headerLocator = core.find("thead td").isExist()
                    ? By.cssSelector("thead td") : By.xpath("//tr[1]//td");
            }
        }
    }

    protected int getRowHeaderIndex() {
        if (rowHeaderIndex == -1)
            rowHeaderIndex = isNotBlank(rowHeaderName)
                ? getRowHeaderIndexFromName()
                : getStartIndex();
        return rowHeaderIndex;
    }
    protected int getShiftRowIndex() {
        if (shiftRowIndex != -1)
            return shiftRowIndex;
        shiftRowIndex = 1 - getStartIndex();
        return shiftRowIndex;
    }
    protected int getShiftColumnIndex() {
        if (shiftColumnIndex != -1)
            return shiftColumnIndex;
        return 1 - getStartIndex();
    }
    protected int getRowHeaderIndexFromName() {
        int index = firstIndex(header(),
                h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(rowHeaderName)));
        if (index == -1)
            throw exception(
                    "Can't find rowHeader '%s' in 'header' [%s]. Please correct JTable params",
                    rowHeaderName, print(header()));
        return index + getStartIndex();
    }

    public void setHeader(List<String> header) {
        this.header.setFinal(header);
    }

    public WebList headerUI() {
        WebList header = core().finds(headerLocator).setName(getName() + " header");
        if (header.size() == 0) {
            header = getRowByIndex(getRowHeaderIndex());
            if (header.size() > 0) {
                this.header.setRule(() -> getRowByIndex(getRowHeaderIndex()).values());
                this.size.setRule(() -> getRowByIndex(getRowHeaderIndex()).size());
            } else {
                throw exception("Can't find header using locator '%s'. Please specify JTable.headers locator or set JTable.header list",
                        headerLocator);
            }
        }
        return header.setName(getName() + " header");
    }
    public WebList footerUI() {
        WebList footer = core().finds(this.footer).setName(getName() + " footer");
        if (footer.size() == 0) {
            footer = getRowByIndex(getRowHeaderIndex());
            if (footer.size() == 0) {
                throw exception("Can't find footer using locator '%s'. Please specify JTable.footer locator", footer);
            }
        }
        return footer.setName(getName() + " header");
    }
    protected List<String> getHeader() {
        return headerUI().values();
    }

    /**
     * Get table header
     * @return List
     */
    @JDIAction("Get {name} header")
    public List<String> header() {
        return header.get();
    }

    protected List<String> getRowHeader() {
        int index = getRowHeaderIndex();
        index = index != -1 ? index : 1;
        return namedHeader(index);
    }
    protected List<String> namedHeader(int index) {
        return webColumn(index).values();
    }
    public List<String> rowHeader() {
        return rowHeader.get();
    }
    protected int getCount() {
        if (columns.get().any())
            return columns.get().get(0).value.size();
        int rowsCount = getColumn(getRowHeaderIndex()).size();
        return headerSameAsFirstRow() ? rowsCount - getStartIndex() : rowsCount;
    }

    /**
     * Get table rows count
     * @return int
     */
    @JDIAction("Get '{name}' rows count")
    public int count() {
        return count.get();
    }

    protected int getTableSize() {
        if (header.hasValue())
            return header.get().size();
        WebList header = headerUI().noValidation();
        return header.size();
    }
    // Amount of columns
    @JDebug
    public int size() { return size.get(); }

    @JDebug
    public WebList webRow(int rowNum) {
        validateRowIndex(rowNum);
        if (rows.get().has(rowNum+""))
            return rows.get().get(rowNum+"");
        WebList result = cells.isGotAll()
            ? new WebList(select(cells.get(), c -> c.value.get(rowNum+"")))
            : getRow(rowNum);
        rows.get().update(rowNum+"", result);
        return result;
    }
    protected void validateRowIndex(int rowNum) {
        if (rowNum < getStartIndex())
            throw exception("Rows numeration starts from %s (but requested index is %s)", getStartIndex(), rowNum);
        if (rowNum > count() - 1 + getStartIndex()) {
            boolean gotAll = cells.isGotAll();
            waitFor().size(greaterThanOrEqualTo(rowNum));
            if (rowNum > count() - 1 + getStartIndex())
                throw exception("Table has only %s rows (but requested index is %s)", count(), rowNum);
            if (gotAll)
                cells.clear();
        }
    }
    public WebList webRow(int columnIndex, String rowName) {
        return webColumn(columnIndex).get(jsRowIndexByName(rowName)).finds(fromCellToRow);
    }
    @JDebug
    public WebList webRow(String rowName) {
        return webRow(getRowHeaderIndex(), rowName);
    }
    @JDebug
    public WebList webRow(Enum rowName) {
        return webRow(getEnumValue(rowName));
    }
    @JDebug
    public WebList webColumn(int colNum) {
        validateColumnIndex(colNum) ;
        if (columns.get().has(colNum+""))
            return columns.get().get(colNum+"");
        WebList result = cells.isGotAll()
            ? newList(cells.get().get(colNum + "").values())
            : getColumn(colNum);
        columns.get().update(colNum + "", result);
        return result;
    }
    protected List<String> getJSValues(String locator) {
        List<String> values = (List<String>) core().js().executeScript("return Array.from(document.querySelectorAll(\""+locator+"\")).map(el=>el.innerText)");
        return map(values, String::trim);
    }
    public List<String> jsCells() {
        return getJSValues(format("%s %s", getByLocator(base().getLocator()), getByLocator(jsColumn)));
    }
    public List<String> jsColumn(int columnIndex) {
        return getJSValues(format("%s %s:nth-child(%s)", getByLocator(base().getLocator()), getByLocator(jsColumn), getColumnLocatorIndex(columnIndex)));
    }
    public List<String> jsColumn(String columnName) {
        return jsColumn(getColIndexByName(columnName));
    }
    public List<String> jsRow(int rowIndex) {
        return getJSValues(format("%s %s:nth-child(%s) %s", getByLocator(base().getLocator()), getByLocator(jsRow), getRowLocatorIndex(rowIndex), getByLocator(jsColumn)));
    }
    public List<String> jsRow(String rowName) {
        return jsRow(jsRowIndexByName(rowName));
    }
    public int jsRowIndexByName(String rowName) {
        int index = getRowHeaderIndex();
        if (index == -1)
            index = getStartIndex();
        List<String> rowHeader;
        try {
            rowHeader = jsColumn(index);
            if (rowHeader.size() == 0)
                throw new IllegalStateException();
        } catch (Exception ex) {
            rowHeader = webColumn(index).values();
        }
        int rowIndex = firstIndex(rowHeader, h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(rowName)));
        if (rowIndex == -1)
            throw exception("Can't find row '%s'", rowName);
        return rowIndex + getStartIndex();
    }
    protected void validateColumnIndex(int colNum) {
        if (colNum < getStartIndex())
            throw exception("Columns numeration starts from %s (but requested index is %s)", getStartIndex(), colNum);
        if (colNum > size())
            throw exception("Table has %s columns (but requested index is %s)", size(), colNum);
    }
    @JDebug
    public WebList webColumn(String colName) {
        return webColumn(getColIndexByName(colName));
    }
    public WebList webColumn(Enum colName) {
        return webRow(getEnumValue(colName));
    }
    protected int getColIndexByName(String colName) {
        int colIndex = getIndexInHeader(header.get(), colName);
        if (colIndex == -1)
            throw exception("Can't find column '%s'", colName);
        return getColumnIndex(colIndex);
    }
    public int getRowIndexByName(String rowName) {
        List<String> rowHeader = rowHeader();
        int rowIndex = getIndexInHeader(rowHeader, rowName);
        if (rowIndex == -1)
            throw exception("Can't find row '%s'", rowName);
        return getRowIndex(rowIndex);
    }
    protected int getIndexInHeader(List<String> header, String name) {
        return firstIndex(header,
            h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(name))) + getStartIndex();
    }
    @JDebug
    public UIElement webCell(int colNum, int rowNum) {
        validateColumnIndex(colNum);
        validateRowIndex(rowNum);
        if (cells.isGotAll())
            return cells.get().get(colNum+"").get(rowNum+"");
        if (rows.get().has(rowNum + ""))
            return rows.get().get(rowNum + "").get(colNum);
        if (columns.get().has(colNum + ""))
            return columns.get().get(colNum + "").get(rowNum);
        if (cells.get().has(colNum + "") && cells.get().get(colNum + "").has(rowNum + ""))
            return cells.get().get(colNum+"").get(rowNum+"");
        UIElement cell = getCell(colNum, rowNum);
        cells.get().update(colNum + "", new MapArray<>(rowNum + "", cell));
        return cell;
    }
    protected MapArray<String, WebList> getRows() {
        if (rows.isGotAll()) return rows.get();
        MapArray<String, WebList> result = new MapArray<>();
        int count = count() + getStartIndex();
        for (int i = getStartIndex(); i < count; i++)
            result.add(i+"", webRow(i));
        rows.gotAll();
        return rows.set(result);
    }
    protected WebList getRowByIndex(int rowNum) {
        WebList row = core().finds(fillByTemplate(rowLocator, rowNum + getShiftRowIndex()));
        row.searchVisible();
        return row;
    }

    @JDebug
    public WebList getRow(int rowNum) {
        WebList row = getRowByIndex(getRowIndex(rowNum));
        return shiftColumnIndex > getStartIndex() || columnsMapping.get().size() > 0
            ? getMappedRow(row)
            : row;
    }
    protected WebList getMappedRow(WebList row) {
        List<WebElement> result = new ArrayList<>();
        for (int i = getStartIndex(); i < header().size() + getStartIndex(); i++)
            result.add(row.get(getColumnIndex(i)));
        return new WebList(result);
    }
    protected MapArray<String, WebList> getColumns() {
        if (columns.isGotAll()) return columns.get();
        MapArray<String, WebList> result = new MapArray<>();
        int size = size() + getStartIndex();
        for (int i = getStartIndex(); i < size; i++)
            result.add(i +"", webColumn(i));
        columns.gotAll();
        return columns.set(result);
    }
    protected int getColumnIndex(int index) {
        return shiftColumnIndex == -1 && columnsMapping.get().size() > 0
            ? columnsMapping.get().get(index - getStartIndex())
            : index;
    }
    protected int getColumnLocatorIndex(int index) {
        return getColumnIndex(index) + getShiftColumnIndex();
    }
    @JDebug
    public WebList getColumn(int colNum) {
        int colIndex = getColumnLocatorIndex(colNum);
        return core().finds(fillByTemplate(columnLocator, colIndex)).noValidation();
    }
    @JDebug
    public UIElement getCell(int colNum, int rowNum) {
        int colIndex = getColumnLocatorIndex(colNum);
        int rowIndex = getRowLocatorIndex(rowNum);
        return core().find(fillByMsgTemplate(cellLocator, colIndex, rowIndex));
    }

    protected Boolean headerIsRow = null;
    protected int getRowIndex(int rowNum) {
        if (shiftRowIndex != -1)
            return rowNum;
        if (headerIsRow == null) {
            headerIsRow = headerIsRow();
        }
        int shift = headerIsRow ? 1 : 0;
        return rowNum + shift;
    }
    protected int getRowLocatorIndex(int rowNum) {
        return getRowIndex(rowNum) + getShiftRowIndex();
    }
    protected boolean headerIsRow() {
        List<String> firstRow = new ArrayList<>();
        try { firstRow = getRowByIndex(getRowHeaderIndex()).noWait(WebList::values, WebList.class); }
        catch (Exception ignore) { }
        return firstRow.isEmpty() || any(header(), firstRow::contains);
    }
    protected boolean headerSameAsFirstRow() {
        List<String> firstRow = new ArrayList<>();
        try { firstRow = getRowByIndex(getRowHeaderIndex()).noWait(WebList::values, WebList.class); }
        catch (Exception ignore) { }
        return !firstRow.isEmpty() && any(header(), firstRow::contains);
    }
    @JDebug
    public WebList filter() {
        return core().finds(filterLocator).setName(getName()+" filter");
    }
    public UIElement filterBy(String filterName) {
        return searchBy(filterName);
    }
    @JDIAction("Filter {name} by column {0}")
    public UIElement searchBy(String filterName) {
        int index = header().indexOf(filterName);
        return filter().get(index + getStartIndex());
    }

    /**
     * Get first table row that match criteria
     * @param matchers to compare
     * @return Line
     */
    @JDIAction("Get first '{name}' table row that match criteria")
    public Line row(TableMatcher... matchers) {
        WebList lines = TABLE_MATCHER.execute(this, matchers);
        if (lines == null || lines.size() == 0)
            return null;
        List<String> result = new ArrayList<>();
        for (int i = getStartIndex(); i < header().size() + getStartIndex(); i++)
            result.add(lines.get(i).getText());
        return new Line(result, header(), base());
    }

    /**
     * Get all table rows that match criteria
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<Line> rows(TableMatcher... matchers) {
        List<String> lines = TABLE_MATCHER.execute(this, matchers).values();
        if (lines == null || lines.size() > 0 && lines.size() < header().size())
            return null;
        List<Line> listOfLines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(line);
            if (result.size() == header().size()) {
                listOfLines.add(new Line(result, header(), base()));
                result.clear();
            }
        }
        return listOfLines;
    }

    /**
     * Check the table is empty
     * @return boolean
     */
    @JDIAction("Is '{name}' table empty")
    public boolean isEmpty() {
        try {
            return count() == 0;
        } catch (Exception ex) {
            return true;
        }
    }

    /**
     * Check the table isn't empty
     * @return boolean
     */
    @JDIAction("Is '{name}' table not empty")
    public boolean isNotEmpty() {
        try {
            return count() != 0;
        } catch (Exception ex) {
            return false;
        }
    }

    // Rows
    /**
     * Get table row by the number
     * @param rowNum
     * @return Line
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(int rowNum) {
        return new Line(header(), webRow(rowNum));
    }

    /**
     * Get table row by the name
     * @param rowName
     * @return Line
     */
    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(String rowName) {
        return new Line(header(), webRow(rowName));
    }
    public Line row(Enum rowName) {
        return row(getEnumValue(rowName));
    }

    /**
     * Get all table rows
     * @return List
     */
    @JDIAction("Get all '{name}' rows")
    public List<Line> rows() {
        return map(getRows(), row -> new Line(header(), row.value));
    }
    /**
     * Get all table rows
     * @return List
     */
    @JDIAction("Get all '{name}' rows")
    public List<Line> rowsImages() {
        MapArray<String, WebList> rows = getRows();
        return map(rows, this::toLineSaveImages);
    }
    private Line toLineSaveImages(Pair<String, WebList> row) {
        Line line = new Line(header(), row.value);
        line.saveCellsImages();
        return line;
    }

    /**
     * Get all table rows that match criteria in column
     * @param matcher to compare
     * @param column
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<Line> filterRows(Matcher<String> matcher, Column column) {
        return LinqUtils.filter(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }

    /**
     * Get all table rows that match criteria
     * @param matchers to compare
     * @return List
     */
    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<Line> filterRows(Pair<Matcher<String>, Column>... matchers) {
        return LinqUtils.filter(rows(), line ->
                all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }

    /**
     * Get table row that match criteria in column
     * @param matcher to compare
     * @param column
     * @return Line
     */
    @JDIAction("Get '{name}' table row that match criteria in column '{1}'")
    public Line row(Matcher<String> matcher, Column column) {
        return first(rows(),
            line -> matcher.matches(line.get(column.getIndex(header()))));
    }

    /**
     * Get table row that match criteria
     * @param matchers to compare
     * @return Line
     */
    @JDIAction("Get '{name}' table row that match criteria")
    public Line row(Pair<Matcher<String>, Column>... matchers) {
        return first(rows(), line ->
            all(matchers, m -> m.key.matches(line.get(m.value.getIndex(header())))));
    }
    // Columns
    /**
     * Get table column by the number
     * @param colNum
     * @return Line
     */
    @JDIAction("Get column '{0}' of '{name}' table")
    public Line column(int colNum) {
        return new Line(rowHeader(), webColumn(colNum));
    }
    /**
     * Get table column by the name
     * @param colName
     * @return Line
     */
    @JDIAction("Get column '{0}' of '{name}' table")
    public Line column(String colName) {
        return new Line(rowHeader(), webColumn(colName));
    }
    public Line column(Enum colName) {
        return column(getEnumValue(colName));
    }

    /**
     * Get all table columns
     * @return List
     */
    @JDIAction("Get all '{name}' columns")
    public List<Line> columns() {
        return map(getColumns(), row -> new Line(rowHeader(), row.value));
    }
    // Cells
    /**
     * Get table cell by column and row numbers
     * @param colNum
     * @param rowNum
     * @return String
     */
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(int colNum, int rowNum) {
        return webCell(colNum, rowNum).getText();
    }

    /**
     * Get table cell by column name and row number
     * @param colName
     * @param rowNum
     * @return String
     */
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(String colName, int rowNum) {
        return cell(getColIndexByName(colName), rowNum);
    }

    /**
     * Get table cell by column number and row name
     * @param colNum
     * @param rowName
     * @return String
     */
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(int colNum, String rowName) {
        validateColumnIndex(colNum);
        return webRow(rowName).get(colNum).getText();
    }

    /**
     * Get table cell by column and row names
     * @param colName
     * @param rowName
     * @return String
     */
    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(String colName, String rowName) {
        return cell(getColIndexByName(colName), rowName);
    }
    public static JFunc1<String, String> TRIM_VALUE =
            el -> el.trim().replaceAll("\n", "\\\\n").replaceAll(" +", " ");
    public static JFunc1<String, String> TRIM_PREVIEW =
            el -> el.trim().replaceAll("\n", " ").replaceAll(" +", " ");

    /**
     * Get table preview
     * @return String
     */
    @JDIAction("Preview '{name}' table")
    public String preview() {
        return TRIM_PREVIEW.execute(core().getText());
    }

    /**
     * Get table value
     * @return String
     */
    @JDIAction("Get '{name}' table value")
    public String getValue() {
        getTableJs();
        String value = "||X||" + print(header.get(), "|") + "||" + LINE_BREAK;
        int count = count();
        for (int i = getStartIndex(); i < count + getStartIndex(); i++) {
            List<String> row = cellsValues.get().get(i+"").values();
            value += "||" + i + "||" + print(map(row, TRIM_VALUE::execute), "|") + "||" + LINE_BREAK;
        }
        return value;
    }
    protected MapArray<String, String> getLineMap(Line row) {
        return new MapArray<>(header(), row);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTable.class, BaseTable.class))
            return;
        JTable j = field.getAnnotation(JTable.class);
        String rowHeader = j.rowHeader();
        List<String> header = asList(j.header());

        if (isNotBlank(j.root()))
            core().setLocator(NAME_TO_LOCATOR.execute(j.root()));
        if (!j.row().equals("//tr[%s]/td") || !getByLocator(this.rowLocator).equals("//tr[%s]/td"))
            this.rowLocator = NAME_TO_LOCATOR.execute(j.row());
        if (!j.column().equals("//tr/td[%s]") || !getByLocator(this.columnLocator).equals("//tr/td[%s]"))
            this.columnLocator = NAME_TO_LOCATOR.execute(j.column());
        if (!j.cell().equals("//tr[{1}]/td[{0}]") || !getByLocator(this.cellLocator).equals("//tr[{1}]/td[{0}]"))
            this.cellLocator = NAME_TO_LOCATOR.execute(j.cell());
        if (!j.allCells().equals("td") || !getByLocator(this.allCellsLocator).equals("td"))
            this.allCellsLocator = NAME_TO_LOCATOR.execute(j.allCells());
        if (!j.headers().equals("th") || !getByLocator(this.headerLocator).equals("th"))
            this.headerLocator = NAME_TO_LOCATOR.execute(j.headers());
        if (!j.filter().equals("th input[type=search],th input[type=text]") || !getByLocator(this.filterLocator).equals("th input[type=search],th input[type=text]"))
            this.filterLocator = NAME_TO_LOCATOR.execute(j.filter());
        if (!j.fromCellToRow().equals("../td") || !getByLocator(this.fromCellToRow).equals("../td"))
            this.fromCellToRow = NAME_TO_LOCATOR.execute(j.fromCellToRow());
        if (!j.footer().equals("tfoot") || !getByLocator(this.fromCellToRow).equals("tfoot"))
            this.footer = NAME_TO_LOCATOR.execute(j.footer());
        if (!j.jsRow().equals("tr") || !getByLocator(this.jsRow).equals("tr"))
            this.jsRow = NAME_TO_LOCATOR.execute(j.jsRow());
        if (!j.jsColumn().equals("td") || !getByLocator(this.jsColumn).equals("td"))
            this.jsColumn = NAME_TO_LOCATOR.execute(j.jsColumn());
        if (header.size() > 0)
            this.header.setFinal(header);
        if (j.columnsMapping().length > 0) {
            this.columnsMapping.set(stream(j.columnsMapping()).boxed().collect(Collectors.toList()));
        }
        if (j.size() != -1)
            this.size.setFinal(j.size());
        if (j.count() != -1)
            this.count.setFinal(j.count());
        if (j.shiftColumnIndex() != -1)
            this.shiftColumnIndex = j.shiftColumnIndex();
        if (j.shiftRowIndex() != -1)
            this.shiftRowIndex = j.shiftRowIndex();
        if (isNotBlank(rowHeader))
            rowHeaderName = rowHeader;
    }

    public T getTableJs() {
        try {
            List<String> listOfCells = jsCells();
            cellsValues.set(new MapArray<>());
            int k = 0;
            int j = getStartIndex();
            int size = size() + getStartIndex();
            while (k < listOfCells.size()) {
                MapArray<String, String> newRow = new MapArray<>();
                for (int i = getStartIndex(); i < size; i++)
                    newRow.add(i+"", listOfCells.get(k++));
                cellsValues.get().update(j+"", newRow);
                j++;
            }
            cellsValues.gotAll();
        } catch (Exception ex) {throw exception(ex, "Can't get all cells"); }
        return (T) this;
    }
    protected T getTable() {
        if (!cells.isGotAll()) {
            try {
                List<WebElement> listOfCells = core().finds(allCellsLocator).getWebElements();
                cells.set(new MapArray<>());
                int k = 0;
                int j = getStartIndex();
                int size = size() + getStartIndex();
                for (int i = getStartIndex(); i < size; i++)
                    cells.get().update(i+"", new MapArray<>());
                while (k < listOfCells.size()) {
                    for (int i = getStartIndex(); i < size; i++)
                        cells.get().get(i+"").update(j+"", new UIElement(listOfCells.get(k++)));
                    j++;
                }
                cells.gotAll();
            } catch (Exception ex) {throw exception(ex, "Can't get all cells"); }
        }
        return (T) this;
    }
    public void clear() {
        refresh();
    }
    public void refresh() {
        rows.clear();
        columns.clear();
        cells.clear();
        count.clear();
        size.clear();
        header.clear();
        rowHeader.clear();
    }

    public void offCache() {
        rows.useCache(false);
        columns.useCache(false);
        cells.useCache(false);
        count.useCache(false);
        size.useCache(false);
        header.useCache(false);
        rowHeader.useCache(false);
    }
}
