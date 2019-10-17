package io.github.com.sections.modal.gridmodal;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.sections.modal.gridmodal.grid.GridCell;
import io.github.com.sections.modal.gridmodal.grid.GridRow;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridModalBody extends Section {

    //FindBy(css = ".row")
    @UI(".row")
    private JList<GridRow> allGridRows;

    //FindBy(css = '[class*='col']')
    @UI("[class*='col']")
    private JList<GridCell> allGridCells;

    public JList<GridCell> getAllCells() {
        return allGridCells;
    }

    public JList<GridRow> getAllRows() {
        return allGridRows;
    }

    public GridRow getGridRow(int rowN) {
        return allGridRows.get(rowN);
    }

    public GridCell getCellInRow(int rowN, int cellN) {
        return getGridRow(rowN).getCell(cellN);
    }

    public String getTextFromCellInRow(int rowN, int cellN) {
        return getCellInRow(rowN, cellN).getText();
    }
}
