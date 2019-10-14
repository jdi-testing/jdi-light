package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ModalOptionalSizes extends Modal {

    // Buttons
    @UI("//*[@id='model-optional-sizes']//button[contains(text(), 'Large')]")
    public Button xlButton;

    @UI("//*[@id='model-optional-sizes']//button[contains(text(), 'Large')]")
    public Button lgButton;

    @UI("//*[@id='model-optional-sizes']//button[contains(text(), 'Small')]")
    public Button smButton;

    // Modals
    @UI("//*[@id='model-optional-sizes']//*[@class='modal-dialog modal-xl']")
    public Modal xlModal;

    @UI("//*[@id='model-optional-sizes']//*[@class='modal-dialog modal-lg']")
    public Modal lgModal;

    @UI("//*[@id='model-optional-sizes']//*[@class='modal-dialog modal-sm']")
    public Modal smModal;

}
