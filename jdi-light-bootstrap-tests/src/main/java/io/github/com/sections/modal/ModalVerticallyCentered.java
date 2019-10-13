package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class ModalVerticallyCentered extends Modal {

    @UI("button:nth-of-type(1)")
    public Button modalCenterTrigger;

    @UI("button:nth-of-type(2)")
    public Button modalCenterScrollableTrigger;

    @UI("#exModalCenter")
    public Modal modalCenterBg;

    @UI("#exampleModalCenteredScrollable")
    public Modal modalCenterScrollableBg;

    @UI("#modal-vertical-content-1")
    public Modal modalContent1;

    @UI("#modal-vertical-content-2")
    public Modal modalContent2;

    @UI("//*[@id='modal-vertical-content-1']//button[contains(., 'Close')]")
    public Button dismissModal1Trigger;

    @UI("//*[@id='modal-vertical-content-2']//button[contains(., 'Close')]")
    public Button dismissModal2Trigger;

}
