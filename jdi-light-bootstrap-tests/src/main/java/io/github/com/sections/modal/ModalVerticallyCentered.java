package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalVerticallyCentered extends Modal {

    @UI("button:nth-of-type(1)")
    public Button modalCenterTrigger;

    @UI("button:nth-of-type(2)")
    public Button modalCenterScrollableTrigger;

    @UI("#exModalCenter")
    public Modal modal1;

    @UI("#exampleModalCenteredScrollable")
    public Modal modal2;

    @UI(".modal-footer button:nth-of-type(1)")
    public Button dismissModal1Close;

    @UI(".modal-footer button:nth-of-type(1)")
    public Button dismissModal2Close;
}
