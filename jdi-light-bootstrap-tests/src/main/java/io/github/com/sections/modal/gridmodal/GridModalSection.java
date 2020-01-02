package io.github.com.sections.modal.gridmodal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class GridModalSection extends Section {

    //@FindBy(css = "#gridSystemModal")
    @UI("#gridSystemModal")
    private GridModalWindow gridModalWindow;

    //@FindBy(css = "#btn-modal-using-grid")
    @UI("#btn-modal-using-grid")
    private Button btnOpenGridModal;

    public void openGridModalWindow() {
        if (!gridModalWindow.isDisplayed()) {
            btnOpenGridModal.click();
        }
    }

    public GridModalWindow getGridModalWindow() {
        return gridModalWindow;
    }
}
