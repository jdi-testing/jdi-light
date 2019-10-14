package io.github.com.sections.gridinmodal;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridModal extends Section {
    //FindBy(css = ".row")
    @UI(".row")
    private JList<GridRow> allGridRows;

    //FindBy(css = ".col")
    @UI("[class*='col']")
    private JList<GridCell> allGridCells;

    public JList<GridRow> getAllGridRows() {
        return allGridRows;
    }

    public JList<GridCell> getAllGridCells() {
        return allGridCells;
    }
}
