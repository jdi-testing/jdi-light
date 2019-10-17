package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalOptionalSizes extends Modal {

    @UI(".bd-example button:nth-of-type(1)")
    public Button xlButton;

    @UI(".bd-example button:nth-of-type(2)")
    public Button lgButton;

    @UI(".bd-example button:nth-of-type(3)")
    public Button smButton;

    @UI(".bd-example-modal-xl")
    public Modal xlModal;

    @UI(".bd-example-modal-lg")
    public Modal lgModal;

    @UI(".bd-example-modal-sm")
    public Modal smModal;

}
