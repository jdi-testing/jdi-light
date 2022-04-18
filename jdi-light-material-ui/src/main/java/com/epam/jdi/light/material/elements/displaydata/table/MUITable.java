package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.Exceptions;
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

public class MUITable extends UIBaseElement<MUITableAssert> implements HasAssert<MUITableAssert>, ISetup {

    private String headerRowLocator;
    private String columnHeaderLocator;
    private String rowLocator;
    private String columnLocator;
    private String columnMenuLocator;

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
            base().setLocator(j.root());

            tableHeader = new MUITableHeader(j.header());
            tableFooter = new MUITableFooter(j.footer());
            columnFilter = new MUITableColumnFilter(j.columnFilter());
            columnConfig = new MUITableColumnConfig(j.columnConfig());
        } else {
            throw Exceptions.runtimeException(String.format("Table '%s' initialisation failed", core().getName()));
        }
    }

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

    public MUITableRow row(int index) {
        try {
            return rows().get(index);
        } catch (IndexOutOfBoundsException e) {
            return new MUITableRow(-1, "");
        }
    }

    public MUITableRow row(int columnIndex, String value) {
        return rows().stream()
                .filter(row -> row.cell(columnIndex, MUITableDefaultCell.class).isExist()
                        && row.cell(columnIndex, MUITableDefaultCell.class).getText().equals(value))
                .findFirst()
                .orElse(new MUITableRow(-1, ""));
    }

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

    public <T extends MUITableCell<?>> MUITableColumn<T> column(int index, Class<T> cellType) {
        try {
            return columns(cellType).get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            return new MUITableColumn<>(-1, Collections.emptyList(), cellType);
        }
    }

    public <T extends MUITableCell<?>> MUITableColumn<T> column(String columnHeader, Class<T> cellType) {
        int columnIndex = row(0).cell(columnHeader, cellType).columnIndex();
        return column(columnIndex, cellType);
    }

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

    public <T extends MUITableCell<?>> MUITableColumn<T> column(String columnHeader, String value, Class<T> cellType) {
        int rowIndex = row(0).cell(columnHeader, cellType).rowIndex();
        return column(rowIndex, value, cellType);
    }

    public MUITableColumn<MUITableDefaultCell> column(int index) {
        return column(index, MUITableDefaultCell.class);
    }

    public MUITableColumn<MUITableDefaultCell> column(String columnHeader) {
        return column(columnHeader, MUITableDefaultCell.class);
    }

    public MUITableColumn<MUITableDefaultCell> column(int rowIndex, String value) {
        return column(rowIndex, value, MUITableDefaultCell.class);
    }

    public MUITableColumn<MUITableDefaultCell> column(String columnHeader, String value) {
        return column(columnHeader, value, MUITableDefaultCell.class);
    }

    public Menu columnMenu() {
        return new Menu().setCore(Menu.class, UIFactory.$(columnMenuLocator));
    }

    public MUITableHeader tableHeader() {
        return tableHeader;
    }

    public MUITableFooter tableFooter() {
        return tableFooter;
    }

    public MUITableColumnFilter columnFilter() {
        return columnFilter;
    }

    public MUITableColumnConfig columnConfig() {
        return columnConfig;
    }

    public int horizontalSize() {
        return row(0).size();
    }

    public int verticalSize() {
        return rows().size();
    }

    public boolean isEmpty() {
        return horizontalSize() == 0 || verticalSize() == 0;
    }

    @Override
    public MUITableAssert is() {
        return new MUITableAssert().set(this);
    }

}
