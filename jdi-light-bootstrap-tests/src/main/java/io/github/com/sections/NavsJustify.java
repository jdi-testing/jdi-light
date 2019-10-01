package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class NavsJustify extends Section {

    @UI("li") public ListGroup navItem;
    @UI("li a") public ListGroup navItemLink;

}
