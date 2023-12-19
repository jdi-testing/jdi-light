package com.epam.jdi.light.material.elements.displaydata.table;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableColumnAssert;

public class MUITableColumn<T extends MUITableCell<?>> extends MUITableCellContainer<MUITableColumnAssert<T>> {

    private final List<T> cells;
    private final Class<T> cellType;

    public MUITableColumn(int index, List<T> cells, Class<T> cellType) {
        super(index);
        this.cells = cells;
        this.cellType = cellType;
    }

    @Override
    @JDIAction("Check that '{name}' is exist")
    public boolean isExist() {
        if (index() <= 0 || cells().isEmpty()) {
            return false;
        } else {
            return cells().get(0).isExist();
        }
    }

    @Override
    @JDIAction("Get '{name}' size")
    public int size() {
        return cells().size();
    }

    @JDIAction("Check that '{name}' is sorted")
    public boolean isSorted() {
        return cells().get(0).core().hasAttribute("aria-sort");
    }

    @JDIAction("Get '{name}' sorting type")
    public ColumnSorting sorting() {
        ColumnSorting columnSorting;
        if (!isSorted()) {
            columnSorting = ColumnSorting.UNSORTED;
        } else {
            String ariaSort = cells().get(0).core().attr("aria-sort");
            switch (ariaSort) {
                case "ascending":
                    columnSorting = ColumnSorting.ASCENDING;
                    break;
                case "descending":
                    columnSorting = ColumnSorting.DESCENDING;
                    break;
                default:
                    columnSorting = ColumnSorting.UNSORTED;
                    break;
            }
        }

        return columnSorting;
    }

    @JDIAction("Get '{name}' cell '{0}'")
    public T cell(int rowNumber) {
        try {
            return cells().get(rowNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            return createCellInstance(-1, -1, cellType);
        }
    }

    @JDIAction("Get '{name}' cell '{0}'")
    public T cell(String text) {
        List<T> targetCells = cells().stream()
                .filter(cell -> cell instanceof IsText && ((IsText) cell).getText().equals(text))
                .collect(Collectors.toList());
        if (!targetCells.isEmpty()) {
            return targetCells.get(0);
        } else {
            return createCellInstance(-1, -1, cellType);
        }
    }

    @JDIAction("Get '{name}' cells list")
    public List<T> cells() {
        return cells;
    }

    @Override
    public MUITableColumnAssert<T> is() {
        return new MUITableColumnAssert<T>().set(this);
    }
}
