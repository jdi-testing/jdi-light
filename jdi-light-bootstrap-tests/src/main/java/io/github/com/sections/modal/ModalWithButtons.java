package io.github.com.sections.modal;

import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalWithButtons extends Modal {

    public void bottomClose() {
        linked(".modal-footer .btn-secondary", "Close").click();
    }

    public void bottomSave() {
        linked(".modal-footer .btn-primary", "Save changes").click();
    }
}
