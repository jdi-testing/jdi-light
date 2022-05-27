package com.epam.jdi.light.material.elements.displaydata.table;

import java.util.List;

import com.epam.jdi.light.material.asserts.displaydata.table.MUITableColumnAssert;

public class MUITableJoinedColumn extends MUITableCellContainer<MUITableColumnAssert<MUITableJoinedCell>> {

    private final String mainColumnName;
    private final List<MUITableJoinedCell> cells;
    
    public MUITableJoinedColumn(int mainColumnIndex, String mainColumnName, List<MUITableJoinedCell> rows) {
        super(mainColumnIndex);
        this.cells = rows;
        this.mainColumnName = mainColumnName;
    }
    
    public MUITableJoinedCell cell(int rowNumber) {
        return cells.get(rowNumber - 1);
    }

    @Override
    public int size() {
        return cells.size();
    }
}
