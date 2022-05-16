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
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class MUITable extends UIBaseElement<MUITableAssert> implements HasAssert<MUITableAssert>, ISetup {

    private String headerRowLocator;
    private String columnHeaderLocator;
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
            headerRowLocator = j.headerRow();
            columnHeaderLocator = j.columnHeaders();
            rowLocator = j.row();
            columnLocator = j.cell();
            columnMenuLocator = j.columnMenu();
            scrollableElementLocator = j.scrollableElementLocator();
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
        List<MUITableRow> rows = rowList.stream()
                .map(row -> new MUITableRow(rowList.indexOf(row) + 1, columnLocator).setCore(MUITableRow.class, row))
                .collect(Collectors.toList());
        rows.add(0, new MUITableRow(0, columnHeaderLocator).setCore(MUITableRow.class, core().find(headerRowLocator)));

        return rows;
    }

    @JDIAction("Get '{name}' row '{0}'")
    public MUITableRow row(int index) {
        try {
            return rows().get(index);
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
        int columnIndex = row(0).cell(columnHeader, cellType).columnIndex();
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
    public MUITableColumn<MUITableDefaultCell> column(String columnHeader) {
        return column(columnHeader, MUITableDefaultCell.class);
    }

    @JDIAction("Get '{name}' column with value '{1}' in row '{0}'")
    public MUITableColumn<MUITableDefaultCell> column(int rowIndex, String value) {
        return column(rowIndex, value, MUITableDefaultCell.class);
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
        return row(0).size();
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
    
    public List<MUITableRow> scrollDown(int rowsNumber){
        return scroll(0, rowsNumber);
    }
    
    public List<MUITableRow> scrollUp(int rowsNumber){
        return scroll(0, -rowsNumber);
    }
    
    public List<MUITableRow> scrollRight(int columnsOffsetPixel){
        return scroll(columnsOffsetPixel, 0);
    }
    
    public List<MUITableRow> scrollLeft(int columnsOffsetPixel){
        return scroll(-columnsOffsetPixel, 0);
    }
}