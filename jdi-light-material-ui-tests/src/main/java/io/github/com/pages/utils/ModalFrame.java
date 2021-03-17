package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIModal;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.utils.Modal;

public class ModalFrame extends Section {

    @JDIModal(modalTitle = "#transition-modal-title", modalDescription = "#transition-modal-description")
    public Modal transitionModal;

    @JDIModal(modalTitle = "#server-modal-title", modalDescription = "#server-modal-description")
    public Modal serverModal;

    @UI("#root > div > button")
    public Button buttonModal;
}
