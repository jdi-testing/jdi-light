package io.github.com.sections.modal.gridmodal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Modal;
//import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class GridModalWindow extends Modal {
    //@FindBy(css = ".modal-body")
    @UI(".modal-body")
    private GridModalBody gridModal;

    //@FindBy(css = ".modal-footer")
    @UI(".modal-footer")
    private ModalFooterSaveClose modalFooter;

    public GridModalBody getBody() {
        return gridModal;
    }

    public ModalFooterSaveClose getFooter() {
        return modalFooter;
    };

    public Button getBtnSave() {
        return getFooter().getBtnSave();
    }

    public void clickBtnSave() {
        getFooter().clickBtnSave();
    }

    public Button getBtnClose() {
        return getFooter().getBtnClose();
    }

    public void clickBtnClose() {
        getFooter().clickBtnClose();
    }

    public Button getBtnCloseX() {
        return super.closeX;
    }

    public Text getTitle() {
        return super.title;
    }

    public void clickBtnCloseX() {
      super.closeX.click();
    }
}
