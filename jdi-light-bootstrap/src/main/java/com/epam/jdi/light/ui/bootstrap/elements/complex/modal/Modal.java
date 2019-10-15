package com.epam.jdi.light.ui.bootstrap.elements.complex.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class Modal extends Section {

    @UI(".modal-header .modal-title")
    public Text title;
    @UI(".modal-header button")
    public Button button;
}
