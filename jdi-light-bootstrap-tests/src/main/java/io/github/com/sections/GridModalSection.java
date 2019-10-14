package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

import static io.github.com.pages.BootstrapPage.gridModalSection;

//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
public class GridModalSection extends Section {
    //@FindBy(css = "#gridSsytemModal")
    @UI("#gridSystemModal")
    public GridModalWindow gridModal;

    //@FindBy(css = "#btn-modal-using-grid")
    @UI("#btn-modal-using-grid")
    private Button btnOpenGridModal;

    public void openGridModalWindow() {
        if (!gridModalSection.gridModal.isDisplayed()) {
            gridModalSection.btnOpenGridModal.click();
        }
    }
}
