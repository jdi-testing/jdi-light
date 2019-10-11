package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ModalVerticallyCentered extends Modal {

    @UI("button:nth-of-type(1)")
    public Button modalCenterTrigger;

    @UI("button:nth-of-type(2)")
    public Button modalCenterScrollableTrigger;

}
