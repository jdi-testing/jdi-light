package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class ScrollspyWithNestedNav extends Section {
    @UI(".//h4 | .//h5") public ListGroup header;//@FindBy(xpath = ".//h4 | .//h5")
   // @UI("h5") public ListGroup subHeader;      // @FindBy(css = "h5")
    @UI("p") public ListGroup mainText;          // @FindBy(css = "p")
}
