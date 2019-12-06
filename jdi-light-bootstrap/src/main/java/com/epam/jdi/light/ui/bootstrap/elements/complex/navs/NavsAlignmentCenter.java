package com.epam.jdi.light.ui.bootstrap.elements.complex.navs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class NavsAlignmentCenter extends Section {

    @UI("li")
    public ListGroup navItem;
    @UI("li a")
    public ListGroup navItemLink;

}
