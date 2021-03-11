package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIModal;
import com.epam.jdi.light.material.elements.utils.Modal;

public class ModalFrame extends Section {

    @JDIModal(modalRoot = "makeStyles-paper-1")
    public Modal modal;

    @JDIModal(buttonModalRoot = "#root > div > button")
    public Modal buttonModal;
}
