package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIModal;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.utils.Modal;

public class ModalFrame extends Section {

    @JDIModal(modalTitle = "#simple-modal-title")
    public Modal simpleModalTitle;

    @JDIModal(modalDescription = "#simple-modal-description")
    public Modal simpleModalDescription;

    @UI("body > div:nth-child(9) > div.makeStyles-paper-1 > div > button")
    public Button innerButton;

    @JDIModal(additionalModal = "body > div:nth-child(10) > div.makeStyles-paper-1")
    public Modal additionalModal;

    @JDIModal(modalTitle = "#transition-modal-title")
    public Modal transitionModalTitle;

    @JDIModal(modalDescription = "#transition-modal-description")
    public Modal transitionModalDescription;

    @JDIModal(modalTitle = "#server-modal-title")
    public Modal serverModalTitle;

    @JDIModal(modalDescription = "#server-modal-description")
    public Modal serverModalDescription;

    @UI("#root > div > button")
    public Button buttonModal;
}
