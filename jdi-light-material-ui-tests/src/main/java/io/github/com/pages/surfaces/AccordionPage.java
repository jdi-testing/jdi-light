package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Accordion;

public class AccordionPage extends WebPage {

    @UI(".MuiAccordion-root[1]")
    public static Accordion generalSettingsAccordion;

    @UI(".MuiAccordion-root[2]")
    public static Accordion usersAccordion;

    @UI(".MuiAccordion-root[3]")
    public static Accordion advancedSettingsAccordion;

    @UI(".MuiAccordion-root[4]")
    public static Accordion personalDataAccordion;

    @UI(".MuiAccordion-root[5]")
    public static Accordion disabledAccordion;
}
