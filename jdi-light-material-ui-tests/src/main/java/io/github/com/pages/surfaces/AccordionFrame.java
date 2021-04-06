package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.surfaces.Accordion;

import java.util.List;

/**
 * To see an example of Accordion web element please visit
 * https://jdi-testing.github.io/jdi-light/material/accordion_surface
 */

public class AccordionFrame extends WebPage {

    @UI(".MuiAccordion-root[1]")
    public Accordion enableAccordion;

    @UI(".MuiAccordion-root[5]")
    public Accordion disableAccordion;

    @UI("span.MuiIconButton-label[1]")
    public Button enableButton;

    @UI("span.MuiIconButton-label[5]")
    public Button disableButton;

}
