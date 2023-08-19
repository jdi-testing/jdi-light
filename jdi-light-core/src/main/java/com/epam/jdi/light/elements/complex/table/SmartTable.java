package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.table.BaseTableAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public abstract class SmartTable<T extends SmartTable<?,?>, A extends BaseTableAssert<?,?>> extends UIBaseElement<A>
        implements IGrid, HasAssert<A> {
    /*
    protected CacheAll<MapArray<String, MapArray<String, UIElement>>> rows
        = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, MapArray<String, UIElement>>> columns
        = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, MapArray<String, UIElement>>> cells
        = new CacheAll<>(MapArray::new);
    protected CacheAll<MapArray<String, MapArray<String, String>>> cellsValues
        = new CacheAll<>(MapArray::new);

    // Amount of Rows
    protected CacheValue<Integer> count = new CacheValue<>(this::getRowsCount);
    protected CacheValue<List<String>> rowHeader = new CacheValue<>(this::getRowHeader);
    // Amount of Columns
    protected CacheValue<Integer> size = new CacheValue<>(this::getTableSize);
    protected CacheValue<List<String>> header = new CacheValue<>(this::getHeader);
    protected CacheValue<List<String>> footer = new CacheValue<>(this::getFooter);

    protected CacheValue<Integer> startIndex = new CacheValue<>(() -> ELEMENT.startIndex);

    protected int rowHeaderIndex = -1;
    protected int firstColumnIndex = -1;
    protected int firstRowIndex = -1;
    protected int[] columnsMapping = new int[]{};
    protected boolean useVisibleColumns = true;
    private boolean gotTableValues = false;

    protected By rowLocator = By.xpath("//tr[%s]/td");
    protected By columnLocator = By.xpath("//tr/td[%s]");
    protected By cellLocator = By.xpath("//tr[{1}]/td[{0}]");
    protected By allCellsLocator = By.cssSelector("td");
    protected By jsRow = By.cssSelector("tr");
    protected By jsColumn = By.cssSelector("td");
    protected By headerLocator = By.cssSelector("th");
    protected By footerLocator = By.cssSelector("tfoot");
    protected By fromCellToRow = By.xpath("../td");
    protected By filterLocator = By.cssSelector("th input[type=search],th input[type=text]");
    protected String rowHeaderName = "";

    protected int getRowsCount() {
        if (rowHeader.hasValue())
            return rowHeader.get().size();
        if (gotTableValues)
            return rows.get().size();
        if (columns.get().any())
            return columns.get().get(0).value.size();
        // TODO
        return column(startIndex.get()).size();
    }
    protected int getTableSize() {
        if (header.hasValue())
            return header.get().size();
        if (gotTableValues)
            return columns.get().size();
        if (rows.get().any())
            return rows.get().get(0).value.size();
        WebList header = headerUI();
        return header.size();
    }

    public WebList headerUI() {
        String headerName = getName() + " header";
        List<WebElement> header = $$(headerLocator, this)
            .noValidation().setName(headerName).getAllElements();
        int size = header.size();
        if (size > 0) {
            if (columnsMapping.length > 0 && columnsMapping.length < size) {
                return filterWebList(header);
            }
            if (useVisibleColumns) {
                return $$(LinqUtils.filter(header, WebElement::isDisplayed), headerName);
            }
            return $$(header, headerName);
        }
        // TODO
        WebList firstRow = getRowByIndex(startIndex.get());
        if (firstRow.size() > 0) {
            this.header.setRule(() -> getRowByIndex(1).values());
            this.size.setRule(() -> getRowByIndex(1).size());
        } else {
            throw exception("Can't find header using locator '%s'. Please specify JTable.headers locator or set JTable.header list");
        }
        return firstRow.setName(headerName);
    }

    @JDIAction("Get '{name}' rows count")
    public int count() {
        return count.get();
    }

    // Amount of columns
    public int size() { return size.get(); }

    protected T getTable() {
        if (gotTableValues)
            return (T) this;
        try {
            refresh();
            WebList allCells = $$(allCellsLocator, this).setName("All cells");
            if (useVisibleColumns) {
                allCells.searchVisible();
            } else {
                allCells.noValidation();
            }
            List<WebElement> listOfCells = allCells.core().getAllElements();
            cells.set(new MapArray<>());
            rows.set(new MapArray<>());
            columns.set(new MapArray<>());
            int k = 0;
            int j = 1;
            for (int i = 1; i <= size(); i++)
                columns.get().update(header().get(i), new MapArray<>());
            while (k < listOfCells.size()) {
                MapArray<String, UIElement> row = new MapArray<>();
                for (int i = 1; i <= size(); i++) {
                    String columnHeader = header().get(i);
                    UIElement element = new UIElement(listOfCells.get(k++));
                    row.add(columnHeader, element);
                    columns.get().get(i-1).value.update(columnHeader, element);
                }
                String rowHeader = rowHeader().get(j);
                rows.get().add(rowHeader, row);
                cells.get().add(rowHeader, row);
                j++;
            }
            count.set(j-1);
            gotTableValues = true;
        } catch (Exception ex) { throw exception(ex, "Can't get all cells"); }
        return (T) this;
    }

    public T getTableJs() {
        try {
            List<String> listOfCells = jsCells();
            cellsValues.set(new MapArray<>());
            int k = 0;
            int j = 1;
            while (k < listOfCells.size()) {
                MapArray<String, String> newRow = new MapArray<>();
                for (int i = 1; i <= size(); i++)
                    newRow.add(i+"", listOfCells.get(k++));
                cellsValues.get().update(j+"", newRow);
                j++;
            }
            cellsValues.gotAll();
        } catch (Exception ex) {throw exception(ex, "Can't get all cells"); }
        return (T) this;
    }

    // region Utility
    protected WebList filterWebList(List<WebElement> webList) {
        List<WebElement> result = new ArrayList<>();
        for (int i = 0; i < columnsMapping.length; i++)
            result.add(webList.get(columnsMapping[i] - startIndex.get()));
        return new WebList(result);
    }
    protected WebList getRowByIndex(int rowNum) {
        WebList row = $$(fillByTemplate(rowLocator, rowNum), this);
        row.searchVisible();
        return row;
    }
    // endregion

    protected int getRowHeaderIndex() {
        if (rowHeaderIndex == -1 && isNotBlank(rowHeaderName)) {
            int index = firstIndex(header(),
                h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(rowHeaderName)));
            if (index > -1)
                rowHeaderIndex = index + 1;
            else throw exception(
            "Can't find rowHeader '%s' in 'header' [%s]. Please correct JTable params",
                rowHeaderName, print(header()));
        }
        return rowHeaderIndex;
    }

    public void setHeader(List<String> header) {
        this.header.setFinal(header);
    }

    public JFunc1<String, String> SIMPLIFY = STRING_SIMPLIFY;
    public WebList footerUI() {
        WebList footer = $$(this.footer, this).setName(getName() + " footer");
        if (footer.size() == 0) {
            footer = getRowByIndex(1);
            if (footer.size() == 0) {
                throw exception("Can't find footer using locator '%s'. Please specify JTable.footer locator");
            }
        }
        return footer.setName(getName() + " header");
    }
    protected List<String> getFooter() {
        return footerUI().values();
    }
    protected List<String> getHeader() {
        return headerUI().values();
    }

    @JDIAction("Get {name} header")
    public List<String> header() {
        return header.get();
    }

    protected List<String> getRowHeader() {
        int index = getRowHeaderIndex();
        return index != -1
            ? namedHeader(index)
            : namedHeader(1);
    }
    protected List<String> namedHeader(int index) {
        return webColumn(index).values();
    }
    public List<String> rowHeader() {
        return rowHeader.get();
    }

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
        if (rowNum < 1)
            throw exception("Rows numeration starts from 1 (but requested index is %s)", rowNum);
        if (rowNum > count()) {
            boolean gotAll = cells.isGotAll();
            waitFor().size(greaterThanOrEqualTo(rowNum));
            if (rowNum > count())
                throw exception("Table has %s rows (but requested index is %s)", count(), rowNum);
            if (gotAll)
                cells.clear();
        }
    }
    public WebList webRow(int columnIndex, String rowName) {
        //return webColumn(columnIndex).get(getRowIndexByName(rowName)).finds(fromCellToRow);
        return webColumn(columnIndex).get(jsRowIndexByName(rowName)).finds(fromCellToRow);
    }
    public WebList webRow(String rowName) {
        return webRow(getRowIndex(), rowName);
    }
    protected int getRowIndex() {
        int headerIndex = getRowHeaderIndex();
        return headerIndex == -1 ? 1 : headerIndex;
    }
    public WebList webRow(Enum<?> rowName) {
        return webRow(getEnumValue(rowName));
    }
    public WebList webColumn(int colNum) {
        validateColumnIndex(colNum) ;
        if (columns.get().has(colNum+""))
            return columns.get().get(colNum).value;
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
        return getJSValues(format("%s %s:nth-child(%s)", getByLocator(base().getLocator()), getByLocator(jsColumn), getColumnIndex(columnIndex)));
    }
    public List<String> jsColumn(String columnName) {
        return jsColumn(getColIndexByName(columnName));
    }
    public List<String> jsRow(int rowIndex) {
        return getJSValues(format("%s %s:nth-child(%s) %s", getByLocator(base().getLocator()), getByLocator(jsRow), getRowIndex(rowIndex), getByLocator(jsColumn)));
    }
    public List<String> jsRow(String rowName) {
        return jsRow(jsRowIndexByName(rowName));
    }
    public int jsRowIndexByName(String rowName) {
        int index = getRowHeaderIndex();
        if (index == -1)
            index = 1;
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
        return rowIndex + 1;
    }
    protected void validateColumnIndex(int colNum) {
        if (colNum < 1)
            throw exception("Columns numeration starts from 1 (but requested index is %s)", colNum);
        if (colNum > size())
            throw exception("Table has %s columns (but requested index is %s)", size(), colNum);
    }
    public WebList webColumn(String colName) {
        return webColumn(getColIndexByName(colName));
    }
    public WebList webColumn(Enum<?> colName) {
        return webRow(getEnumValue(colName));
    }
    protected int getColIndexByName(String colName) {
        int colIndex = firstIndex(header.get(), h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(colName)));
        if (colIndex == -1)
            throw exception("Can't find column '%s'", colName);
        return colIndex + 1;
    }
    public int getRowIndexByName(String rowName) {
        List<String> rowHeader = rowHeader();
        int rowIndex = firstIndex(rowHeader, h -> SIMPLIFY.execute(h).equals(SIMPLIFY.execute(rowName)));
        if (rowIndex == -1)
            throw exception("Can't find row '%s'", rowName);
        return rowIndex + 1;
    }
    public UIElement webCell(int colNum, int rowNum) {
        validateColumnIndex(colNum);
        validateRowIndex(rowNum);
        if (cells.isGotAll())
            return cells.get().get(rowNum+"").get(colNum+"");
        if (rows.get().has(rowNum + ""))
            return rows.get().get(rowNum + "").get(colNum).value;
        if (columns.get().has(colNum + ""))
            return columns.get().get(colNum + "").get(rowNum).value;
        if (cells.get().has(colNum + "") && cells.get().get(colNum + "").has(rowNum + ""))
            return cells.get().get(colNum+"").get(rowNum+"");
        UIElement cell = getCell(colNum, rowNum);
        cells.get().update(colNum + "", new MapArray<>(rowNum + "", cell));
        return cell;
    }
    protected MapArray<String, WebList> getRows() {
        if (!rows.isGotAll())
            getTable();
        return convertMap(rows.get());
    }
    protected MapArray<String, WebList> convertMap(MapArray<String, MapArray<String, UIElement>> map) {
        MapArray<String, WebList> result = new MapArray<>();
        for (Pair<String, MapArray<String, UIElement>> pair : map) {
            result.add(pair.key, new WebList(pair.value));
        }
        return result;
    }

    public WebList getRow(int rowNum) {
        WebList row = getRowByIndex(getRowIndex(rowNum));
        return firstColumnIndex > 1 || columnsMapping.length > 0
            ? getMappedRow(row)
            : row;
    }
    protected WebList getMappedRow(WebList row) {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= header().size(); i++)
            result.add(row.get(getColumnIndex(i)-1));
        return new WebList(result);
    }
    protected MapArray<String, WebList> getColumns() {
        if (!columns.isGotAll())
            getTable();
        return convertMap(columns.get());
    }
    protected int getColumnIndex(int index) {
        if (firstColumnIndex > 1)
            return index + firstColumnIndex - 1;
        if (columnsMapping.length > 0)
            return columnsMapping[index-1];
        return index;
    }
    public WebList getColumn(int colNum) {
        return $$(fillByTemplate(columnLocator, getColumnIndex(colNum)), this).noValidation();
    }
    public UIElement getCell(int colNum, int rowNum) {
        return $(fillByMsgTemplate(cellLocator, getColumnIndex(colNum), getRowIndex(rowNum)), this);
    }

    protected Boolean headerIsRow = null;
    protected int getRowIndex(int rowNum) {
        if (firstRowIndex > 1)
            return rowNum + firstRowIndex - 1;
        if (headerIsRow == null) {
            headerIsRow = headerIsRow();
        }
        return headerIsRow ? rowNum + 1 : rowNum;
    }
    protected boolean headerIsRow() {
        List<String> firstRow = new ArrayList<>();
        try { firstRow = getRowByIndex(1).noWait(WebList::values, WebList.class); }
        catch (Exception ignore) { }
        return firstRow.isEmpty() || any(header(), firstRow::contains);
    }
    protected boolean headerSameAsFirstRow() {
        List<String> firstRow = new ArrayList<>();
        try { firstRow = getRowByIndex(1).noWait(WebList::values, WebList.class); }
        catch (Exception ignore) { }
        return !firstRow.isEmpty() && any(header(), firstRow::contains);
    }
    public WebList filter() {
        return $$(filterLocator).setup(b-> {
            b.setParent(this);
            b.setName(getName()+" filter");}
        );
    }
    public UIElement filterBy(String filterName) {
        return searchBy(filterName);
    }
    @JDIAction("Filter {name} by column {0}")
    public UIElement searchBy(String filterName) {
        int index = header().indexOf(filterName);
        return filter().get(index + 1);
    }

    @JDIAction("Get first '{name}' table row that match criteria")
    public Line row(TableMatcher... matchers) {
        WebList lines = TABLE_MATCHER.execute(this, matchers);
        if (lines == null || lines.size() == 0)
            return null;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= header().size(); i++)
            result.add(lines.get(i).getText());
        return initLine(result, header());
    }

    @JDIAction("Get all '{name}' table rows that match criteria")
    public List<Line> rows(TableMatcher... matchers) {
        List<String> lines = TABLE_MATCHER.execute(this, matchers).values();
        if (lines == null || lines.size() < header().size())
            return null;
        List<Line> listOfLines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(line);
            if (result.size() == header().size()) {
                listOfLines.add(initLine(result, header()));
                result.clear();
            }
        }
        return listOfLines;
    }

    @JDIAction("Is '{name}' table empty")
    public boolean isEmpty() {
        try {
            return count() == 0;
        } catch (Exception ex) {
            return true;
        }
    }

    @JDIAction("Is '{name}' table not empty")
    public boolean isNotEmpty() {
        try {
            return count() != 0;
        } catch (Exception ex) {
            return false;
        }
    }

    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(int rowNum) {
        return new Line(header(), webRow(rowNum));
    }

    @JDIAction("Get row '{0}' for '{name}' table")
    public Line row(String rowName) {
        return new Line(header(), webRow(rowName));
    }
    public Line row(Enum<?> rowName) {
        return row(getEnumValue(rowName));
    }

    @JDIAction("Get all '{name}' rows")
    public List<Line> rows() {
        return map(getRows(), row -> new Line(header(), row.value));
    }
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

    @JDIAction("Filter '{name}' table rows that match criteria in column '{1}'")
    public List<Line> filterRows(Matcher<String> matcher, Column column) {
        return LinqUtils.filter(rows(),
                line -> matcher.matches(line.get(column.getIndex(header()))));
    }

    @JDIAction("Filter '{name}' table rows that match criteria")
    public List<Line> filterRows(Pair<Matcher<String>, Column>... matchers) {
        return LinqUtils.filter(rows(), line ->
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
        return new Line(rowHeader(), webColumn(colNum));
    }
    @JDIAction("Get column '{0}' of '{name}' table")
    public Line column(String colName) {
        return new Line(rowHeader(), webColumn(colName));
    }
    public Line column(Enum<?> colName) {
        return column(getEnumValue(colName));
    }
    @JDIAction("Get all '{name}' columns")
    public List<Line> columns() {
        return map(getColumns(), row -> new Line(rowHeader(), row.value));
    }
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
        validateColumnIndex(colNum);
        return webRow(rowName).get(colNum).getText();
    }

    @JDIAction("Get cell({0}, {1}) from '{name}' table")
    public String cell(String colName, String rowName) {
        return cell(getColIndexByName(colName), rowName);
    }
    public static JFunc1<String, String> TRIM_VALUE =
            el -> el.trim().replaceAll("\n", "\\\\n").replaceAll(" +", " ");
    public static JFunc1<String, String> TRIM_PREVIEW =
            el -> el.trim().replaceAll("\n", " ").replaceAll(" +", " ");

    @JDIAction("Preview '{name}' table")
    public String preview() {
        return TRIM_PREVIEW.execute(core().getText());
    }

    @JDIAction("Get '{name}' table value")
    public String getValue() {
        getTableJs();
        String value = "||X||" + print(header.get(), "|") + "||" + LINE_BREAK;
        for (int i = 1; i <= count(); i++) {
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
        if (!fieldHasAnnotation(field, JTable.class, SmartTable.class))
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
        if (j.columnsMapping().length > 0)
            this.columnsMapping = j.columnsMapping();
        if (j.size() != -1)
            this.size.setFinal(j.size());
        if (j.count() != -1)
            this.count.setFinal(j.count());
        if (j.firstColumnIndex() != -1)
            this.firstColumnIndex = j.firstColumnIndex();
        if (j.firstColumnIndex() != -1)
            this.firstRowIndex = j.firstColumnIndex();
        if (isNotBlank(rowHeader))
            rowHeaderName = rowHeader;
    }

    public void clear() {
        refresh();
    }
    public void refresh() {
        gotTableValues = false;
        rows.clear();
        columns.clear();
        cells.clear();
        count.clear();
        size.clear();
        header.clear();
        rowHeader.clear();
        footer.clear();
    }
    public void offCache() {
        rows.useCache(false);
        columns.useCache(false);
        cells.useCache(false);
        count.useCache(false);
        size.useCache(false);
        header.useCache(false);
        rowHeader.useCache(false);
        footer.useCache(false);
    }
    */
}
