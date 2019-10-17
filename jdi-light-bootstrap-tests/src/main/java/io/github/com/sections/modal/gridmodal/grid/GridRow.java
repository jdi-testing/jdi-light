package io.github.com.sections.modal.gridmodal.grid;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridRow extends Section {
       //FindBy(css = [class*='col']")
       @UI("[class*='col']")
       private JList<GridCell> gridCellsInRow;

       public JList<GridCell> getGridCellsFromRow() {
              return gridCellsInRow;
       }

       public GridCell getCell(int i) {
              return getGridCellsFromRow().get(i) ;
       }
}
