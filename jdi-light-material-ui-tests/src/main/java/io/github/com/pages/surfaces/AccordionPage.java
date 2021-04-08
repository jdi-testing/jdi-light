package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.material.elements.surfaces.Accordion;

public class AccordionPage extends WebPage {

    @JDropdown(
            root = ".MuiAccordion-root[1]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            list = ".MuiAccordionDetails-root",
            expand = ".MuiIconButton-label")
    public static Accordion enabledAccordion;

    @JDropdown(
            root = ".MuiAccordion-root[5]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            expand = ".MuiIconButton-label"
            )
    public static Accordion disabledAccordion;
}