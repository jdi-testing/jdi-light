package io.github.com.sections.modal.gridmodal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class GridModalWindow extends Modal {
    //@FindBy(css = ".modal-body")
    @UI(".modal-body")
    private GridModalBody gridModal;

    //@FindBy(css = ".modal-footer")
    @UI(".modal-footer")
    private ModalFooterSaveClose modalFooter;

    //@FindBy(css = "modal-header button")
    @UI(".modal-header button")
    public Button closeX;


    public GridModalBody getBody() {
        return gridModal;
    }

    public ModalFooterSaveClose getFooter() {
        return modalFooter;
    }

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
        return closeX;
    }

    public Text getTitle() {
        return super.title;
    }

    public void clickBtnCloseX() {
        getBtnCloseX().click();
    }

    public boolean isDisplayed() {
        return core().hasAttribute("style") &&
                !core().attr("style").contains("display: none");
    }
}
