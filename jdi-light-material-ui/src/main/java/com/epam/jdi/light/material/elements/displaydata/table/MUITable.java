package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules;
import com.epam.jdi.light.material.annotations.JMUITable;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableAssert;
import com.epam.jdi.light.material.elements.navigation.Menu;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class MUITable extends UIBaseElement<MUITableAssert> implements HasAssert<MUITableAssert>, ISetup {
    
    private String rowLocator;
    private String columnLocator;
    private String columnMenuLocator;
    private String scrollableElementLocator;

    private MUITableHeader tableHeader;
    private MUITableFooter tableFooter;
    private MUITableColumnFilter columnFilter;
    private MUITableColumnConfig columnConfig;

    @Override
    public void setup(Field field) {
        if (FillFromAnnotationRules.fieldHasAnnotation(field, JMUITable.class, MUITable.class)) {
            JMUITable j = field.getAnnotation(JMUITable.class);
            rowLocator = j.row();
            columnLocator = j.cell();
            columnMenuLocator = j.columnMenu();
            scrollableElementLocator = j.scroll();
            base().setLocator(j.root());

            tableHeader = new MUITableHeader(j.header());
            tableFooter = new MUITableFooter(j.footer());
            columnFilter = new MUITableColumnFilter(j.columnFilter());
            columnConfig = new MUITableColumnConfig(j.columnConfig());
        } else {
            throw Exceptions.runtimeException(String.format("Table '%s' initialisation failed", core().getName()));
        }
    }

    @JDIAction("Get '{name}' rows list")
    public List<MUITableRow> rows() {
        List<UIElement> rowList = core().finds(rowLocator).stream()
                .map(element -> new UIElement().setCore(UIElement.class, element))
                .collect(Collectors.toList());
        return rowList.stream()
                .map(row -> new MUITableRow(rowList.indexOf(row) + 1, columnLocator).setCore(MUITableRow.class, row))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' row '{0}'")
    public MUITableRow row(int rowNumber) {
        try {
            return rows().get(rowNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            return new MUITableRow(-1, "");
        }
    }

    @JDIAction("Get '{name}' row with value '{1}' in column '{0}'")
    public MUITableRow row(int columnIndex, String value) {
        return rows().stream()
                .filter(row -> row.cell(columnIndex, MUITableDefaultCell.class).isExist()
                        && row.cell(columnIndex, MUITableDefaultCell.class).getText().equals(value))
                .findFirst()
                .orElse(new MUITableRow(-1, ""));
    }

    @JDIAction("Get '{name}' row with value '{1}' in column '{0}'")
    public MUITableRow row(String columnHeader, String value) {
        List<?> columnHeaders = rows().get(0)
                .cells(MUITableDefaultCell.class).stream()
                .filter(header -> header.getText().equals(columnHeader))
                .collect(Collectors.toList());
        int columnIndex = columnHeaders.stream()
                .mapToInt(header -> columnHeaders.indexOf(header) + 1)
                .findFirst()
                .orElse(-1);
        return row(columnIndex, value);
    }

    @JDIAction("Get '{name}' columns list")
    public <T extends MUITableCell<?>> List<MUITableColumn<T>> columns(Class<T> cellType) {
        List<MUITableColumn<T>> columns = new ArrayList<>();
        List<MUITableRow> rows = rows();
        for (int i = 0; i < rows.get(0).size(); i++) {
            List<T> cells = new ArrayList<>();
            for (MUITableRow row : rows) {
                cells.add(row.cell(i + 1, cellType));
            }
            columns.add(new MUITableColumn<>(i + 1, cells, cellType));
        }
        return columns;
    }

    @JDIAction("Get '{name}' column '{0}' with cell type '{1}'")
    public <T extends MUITableCell<?>> MUITableColumn<T> column(int index, Class<T> cellType) {
        try {
            return columns(cellType).get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            return new MUITableColumn<>(-1, Collections.emptyList(), cellType);
        }
    }

    @JDIAction("Get '{name}' column '{0}' with cell type '{1}'")
    public <T extends MUITableCell<?>> MUITableColumn<T> column(String columnHeader, Class<T> cellType) {
        int columnIndex = tableHeader.cell(columnHeader, cellType).columnIndex();
        return column(columnIndex, cellType);
    }

    @JDIAction("Get '{name}' column with value '{1}' with cell type '{2}' in row '{0}' ")
    public <T extends MUITableCell<?>> MUITableColumn<T> column(int rowIndex, String value, Class<T> cellType) {
        T cell = row(rowIndex).cell(value, cellType);
        if (!cell.isExist()) {
            return new MUITableColumn<>(-1, Collections.emptyList(), cellType);
        } else {
            List<MUITableRow> rows = rows();
            List<T> cells = new ArrayList<>();
            for (MUITableRow row : rows) {
                cells.add(row.cell(cell.columnIndex(), cellType));
            }
            return new MUITableColumn<>(cell.columnIndex(), cells, cellType);
        }
    }

    @JDIAction("Get '{name}' column '{0}'")
    public MUITableColumn<MUITableDefaultCell> column(int index) {
        return column(index, MUITableDefaultCell.class);
    }

    @JDIAction("Get '{name}' column '{0}'")
    public MUITableColumn<MUITableDefaultCell> column(String columnName) {
        return column(columnName, MUITableDefaultCell.class);
    }

    @JDIAction("Get '{name}' column with value '{1}' in row '{0}'")
    public MUITableColumn<MUITableDefaultCell> column(int rowIndex, String value) {
        return column(rowIndex, value, MUITableDefaultCell.class);
    }
    
    /**
     * @implNote The method is used for a tables where a header column has sub-columns, e.x.: 
     * <p>
     * <table border="1" cellpadding="3" cellspacing="0">
     * <thead bgcolor="silver"><tr><th colspan="3">Main column</th></tr>
     * <tr><th>sub-column1</th>
     * <th>sub-column2</th>
     * <th>sub-column3</th></tr></thead>
     * <tr><td>1</td><td>2</td><td>3</td></tr>
     * </table>
     * <p>Calling joinedColumn("Main column") will return an object that contains list of rows that have list of sub-columns available to operate with.
     * */
    public MUITableJoinedColumn joinedColumn(String columnName){
        List<Integer> columnIndexes = tableHeader.subColumnsIndexes(columnName);
        MUITableDefaultCell mainHeaderCell = tableHeader.cell(columnName, MUITableDefaultCell.class);
        
        List<MUITableJoinedCell> cells = new ArrayList<>();
        List<MUITableRow> rows = rows();
        for (MUITableRow row : rows) {
            LinkedHashMap<String, MUITableDefaultCell> subColumns = new LinkedHashMap<>();
            for(int i = 0; i < columnIndexes.size(); i++) {
                Integer cIndex = columnIndexes.get(i);
                subColumns.put(tableHeader.cell(cIndex).getText(), row.cell(cIndex));
            }
            cells.add(new MUITableJoinedCell(row.index(), subColumns));
        }
        return new MUITableJoinedColumn(mainHeaderCell.columnIndex(), cells);
    }
    
    @JDIAction("Get '{name}' column menu")
    public Menu columnMenu() {
        return new Menu().setCore(Menu.class, UIFactory.$(columnMenuLocator));
    }

    @JDIAction("Get '{name}' header")
    public MUITableHeader tableHeader() {
        return tableHeader;
    }

    @JDIAction("Get '{name}' footeru")
    public MUITableFooter tableFooter() {
        return tableFooter;
    }

    @JDIAction("Get '{name}' column filter")
    public MUITableColumnFilter columnFilter() {
        return columnFilter;
    }

    @JDIAction("Get '{name}' column config")
    public MUITableColumnConfig columnConfig() {
        return columnConfig;
    }

    @JDIAction("Get '{name}' horizontal size")
    public int horizontalSize() {
        return row(1).size();
    }

    @JDIAction("Get '{name}' vertical size")
    public int verticalSize() {
        return rows().size();
    }

    @JDIAction("Check that '{name}' is empty")
    public boolean isEmpty() {
        return horizontalSize() == 0 || verticalSize() == 0;
    }

    @Override
    public MUITableAssert is() {
        return new MUITableAssert().set(this);
    }


    @JDIAction("Scroll table content and return list of rows")
    private List<MUITableRow> scroll(int columnsOffsetPixels, int rowsNumber) {
        if(!scrollableElementLocator.isEmpty()) {
            String rowHeightScript = "return document.evaluate(\"%s//div[@role = 'row']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetHeight";
            Object scriptResult = jsExecute(String.format(rowHeightScript, scrollableElementLocator));
            int rowHeight = Integer.parseInt(scriptResult.toString());        
            
            String script = "document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollBy(%d, %d)";
            jsExecute(String.format(script, scrollableElementLocator, columnsOffsetPixels, rowHeight * rowsNumber));
        }
        return rows();
    }
    
    /**
     * @implNote Scrolling by rows amount
     * */
    public List<MUITableRow> scrollDown(int rowsNumber){
        return scroll(0, rowsNumber);
    }
    
    /**
     * @implNote Scrolling by rows amount
     * */
    public List<MUITableRow> scrollUp(int rowsNumber){
        return scroll(0, -rowsNumber);
    }
    
    /**
     * @implNote Scrolling right by pixels
     * */
    public List<MUITableRow> scrollRight(int columnsOffsetPixel){
        return scroll(columnsOffsetPixel, 0);
    }
    
    /**
     * @implNote Scrolling left by pixels
     * */
    public List<MUITableRow> scrollLeft(int columnsOffsetPixel){
        return scroll(-columnsOffsetPixel, 0);
    }
}
