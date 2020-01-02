package io.github.com.sections.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ModalOptionalSizes extends Section {

    @UI("button:nth-of-type(1)")
    public Button xlButton;

    @UI("button:nth-of-type(2)")
    public Button lgButton;

    @UI("button:nth-of-type(3)")
    public Button smButton;

    @UI(".bd-example-modal-xl")
    public Modal xlModal;

    @UI(".bd-example-modal-lg")
    public Modal lgModal;

    @UI(".bd-example-modal-sm")
    public Modal smModal;

}
