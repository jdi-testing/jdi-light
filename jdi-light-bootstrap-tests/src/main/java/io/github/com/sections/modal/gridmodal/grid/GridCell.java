package io.github.com.sections.modal.gridmodal.grid;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridCell extends Section {
    //@FindBy(".row")
    @UI(".row")
    private JList<GridRow> gridRowsInCell;

    public JList<GridRow> getRows() {
        return gridRowsInCell;
    }
}
