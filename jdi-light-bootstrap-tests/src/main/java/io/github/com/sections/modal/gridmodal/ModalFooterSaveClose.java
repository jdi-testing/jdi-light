package io.github.com.sections.modal.gridmodal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ModalFooterSaveClose extends Section {
    //@FindBy(css = ".modal-footer .btn-primary")
    @UI(".btn-primary")
    private Button btnSave;

    //@FindBy(css = ".modal-footer .btn-secondary")
    @UI(".btn-secondary")
    private Button btnClose;

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnClose() {
        return btnClose;
    }

    public void clickBtnClose() {
       btnClose.click();
    }

    public void clickBtnSave() {
        btnSave.click();
    }
}

