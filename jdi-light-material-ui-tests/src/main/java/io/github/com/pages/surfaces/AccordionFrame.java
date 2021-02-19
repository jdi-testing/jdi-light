package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Accordion;

public class AccordionFrame extends Section {

    @UI(".MuiAccordion-root")
    public Accordion accordion;
}
