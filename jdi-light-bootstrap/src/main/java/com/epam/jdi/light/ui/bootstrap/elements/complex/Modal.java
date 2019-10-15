package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class Modal extends Section {

    @UI("button[data-toggle='modal']") public Button launchModal;
    @Title
    @UI(".modal-title") public Text title;
    @UI(".modal-body") public Text body;
    @UI("//div[@class='modal-footer']//button[1]") public Button closeButton;
    @UI("//div[@class='modal-footer']//button[2]") public Button saveButton;
}
