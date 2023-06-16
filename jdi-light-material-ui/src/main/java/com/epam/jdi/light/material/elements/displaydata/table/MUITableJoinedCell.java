package com.epam.jdi.light.material.elements.displaydata.table;

import java.util.Map;
import java.util.Map.Entry;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableJoinedCellAssert;

public class MUITableJoinedCell extends MUITableCell<MUITableJoinedCellAssert> implements IsText, HasClick {
    
    private Map<String, MUITableDefaultCell> subColumns;
    
    protected MUITableJoinedCell(int rowIndex, Map<String, MUITableDefaultCell> subColumns) {
        super(rowIndex, -1);
        this.subColumns = subColumns;
    }
    
    @Override
    public String getText() {
        StringBuilder joinedCellsValue = new StringBuilder();
        for (Entry<String, MUITableDefaultCell> subColumn : subColumns.entrySet()) {
            String cellText = subColumn.getValue().getText();
            if (subColumns.size() > 1) {
                joinedCellsValue.append(String.format("%s: %s; ", 
                        subColumn.getKey(),
                        cellText));
            } else {
                joinedCellsValue.append(cellText);
            }
        }
        return joinedCellsValue.toString();
    }
    
    @Override
    public MUITableJoinedCellAssert has() {
        return new MUITableJoinedCellAssert().set(this);
    }
}
