package io.github.com.sections.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalOptionalSizes extends Section {

    @UI(".bd-example-modal-xl")
    public Modal xlModal;

    @UI(".bd-example-modal-lg")
    public Modal lgModal;

    @UI(".bd-example-modal-sm")
    public Modal smModal;

}
