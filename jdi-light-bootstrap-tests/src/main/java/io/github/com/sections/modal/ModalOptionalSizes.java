package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ModalOptionalSizes extends Modal {

    // Buttons
    @UI("//button[contains(text(), 'Extra large')]")
    public Button xlButton;

    @UI("//*[@id='modal-optional-sizes']//button[contains(text(), 'Large')]")
    public Button lgButton;

    @UI("//*[@id='modal-optional-sizes']//button[contains(text(), 'Small')]")
    public Button smButton;

    // Modals
    @WaitTimeout(2)
    @UI("//*[@id='modal-optional-sizes']//*[@class='modal-dialog modal-xl']")
    public Modal xlModal;

    @UI("//*[@id='modal-optional-sizes']//*[@class='modal-dialog modal-lg']")
    public Modal lgModal;

    @UI("//*[@id='modal-optional-sizes']//*[@class='modal-dialog modal-sm']")
    public Modal smModal;

}
