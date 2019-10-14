package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
public class GridModalWindow extends Section {
    //@FindBy(css = "#gridModalLabel")
    @UI("#gridModalLabel")
    public Label modalHeader;

    //@FindBy(css = "#close-modal-cross")
    @UI("#close-modal-cross")
    public Button btnCloseX;

    //@FindBy(css = "#save-modal")
    @UI("#save-modal")
    public Button btnSave;

    //@FindBy(css = "#close-modal")
    @UI("#close-modal")
    public Button btnClose;

    public boolean isOpen() {
        return (attr("style").contains("display"));
    }
}
