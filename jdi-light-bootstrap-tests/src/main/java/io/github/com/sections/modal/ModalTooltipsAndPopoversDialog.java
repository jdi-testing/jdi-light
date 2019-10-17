package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;

public class ModalTooltipsAndPopoversDialog extends Modal {
    @UI(".modal-body > p:nth-child(2) > a") public Button buttonTriggers;
    @UI(".modal-body > p:nth-child(5) > a:nth-child(1)") public Link thisLink;
    @UI(".modal-body > p:nth-child(5) > a:nth-child(2)") public Link thatLink;
}
