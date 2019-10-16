package io.github.com.sections.modal.gridmodal;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Modal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        return super.closeX;
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
