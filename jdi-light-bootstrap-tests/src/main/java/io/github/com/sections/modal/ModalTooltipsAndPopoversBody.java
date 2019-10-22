package io.github.com.sections.modal;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class ModalTooltipsAndPopoversBody extends Section {
    @UI("h5:nth-child(1)") public Text title1;
    @UI("p:nth-child(2) > a") public Button buttonTriggers;
    @UI("h5:nth-child(4)") public Text title2;
    @UI("p:nth-child(5) > a:nth-child(1)") public Link thisLink;
    @UI("p:nth-child(5) > a:nth-child(2)") public Link thatLink;
}
