package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.elements.surfaces.Accordion;

public class MaterialPage extends Section {

    // inputs
    @UI(".MuiSwitch-root")
    public Switch aSwitch;

    // surfaces
    @UI(".MuiAccordion-root")
    public Accordion accordion;
}
