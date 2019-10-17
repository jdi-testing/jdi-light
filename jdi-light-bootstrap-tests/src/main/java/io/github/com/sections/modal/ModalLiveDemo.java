package io.github.com.sections.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalLiveDemo extends Section {

    @UI("button[data-toggle='modal']")
    public Button launchModal;
    @UI(".modal-body")
    public Text body;
    @UI("//div[@class='modal-footer']//button[1]")
    public Button closeButton;
    @UI("//div[@class='modal-footer']//button[2]")
    public Button saveButton;
    @UI(".modal-header .close")
    public Button closeX;
    @UI("#exampleModalLive")
    public Modal modalContent;
}
