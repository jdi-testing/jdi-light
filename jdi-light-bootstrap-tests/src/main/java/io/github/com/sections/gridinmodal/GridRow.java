package io.github.com.sections.gridinmodal;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridRow extends Section {
       //FindBy(css = ".column")
       @UI("[class*='col']")
       private JList<GridCell> gridCellsInRow;

       public JList<GridCell> getGridCellsInRow() {
              return gridCellsInRow;
       }
}
