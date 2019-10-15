package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Modal;

public class ModalOptionalSizes extends Modal {

    // Buttons
    @UI(".bd-example button:nth-of-type(1)")
    public Button xlButton;

    @UI(".bd-example button:nth-of-type(2)")
    public Button lgButton;

    @UI(".bd-example button:nth-of-type(3)")
    public Button smButton;

    // Modals
    @UI(".modal-xl .modal-content")
    public Modal xlModal;

    @UI(".modal-lg .modal-content")
    public Modal lgModal;

    @UI(".modal-sm .modal-content")
    public Modal smModal;

}
