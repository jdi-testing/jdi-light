package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class ScrollspyInNavbar extends Section {
    @UI("h4") public ListGroup header;  //@FindBy(css = "h4")
    @UI("p") public ListGroup mainText; // @FindBy(css = "p")
}
