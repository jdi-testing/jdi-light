package io.github.com.sections.modalwindow;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
public class ModalWindow extends Section {
    //@FindBy(css = ".modal-header .modal-title")
    @UI(".modal-header .modal-title")
    public Label modalTitle;

    //@FindBy(css = ".modal-header .close")
    @UI(".modal-header .close")
    public Button btnCloseX;

    //@FindBy(css = ".modal-footer .btn-primary")
    @UI(".modal-footer .btn-primary")
    public Button btnSave;

    //@FindBy(css = ".modal-footer .btn-secondary")
    @UI(".modal-footer .btn-secondary")
    public Button btnClose;

    public boolean isOpen() {
        return (attr("style").contains("display"));
    }
}
