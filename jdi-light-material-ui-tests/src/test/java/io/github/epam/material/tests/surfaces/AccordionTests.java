package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.accordionPage;
import static io.github.com.pages.surfaces.AccordionPage.advancedSettingsAccordion;
import static io.github.com.pages.surfaces.AccordionPage.disabledAccordion;
import static io.github.com.pages.surfaces.AccordionPage.generalSettingsAccordion;
import static io.github.com.pages.surfaces.AccordionPage.personalDataAccordion;
import static io.github.com.pages.surfaces.AccordionPage.usersAccordion;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Accordion web element please visit
 * https://mui.com/components/accordion/
 */

public class AccordionTests extends TestsInit {

    @BeforeMethod
    public void before() {
        accordionPage.open();
        accordionPage.checkOpened();
    }

    @Test
    public void disabledAccordionTest() {
        disabledAccordion.is().displayed()
                .and().disabled();
        disabledAccordion.content.is().hidden();
    }

    @Test
    public void accordionExpandTest() {
        generalSettingsAccordion.is().enabled();
        generalSettingsAccordion.content.is().hidden();

        generalSettingsAccordion.expand();
        generalSettingsAccordion.is().expanded();
        generalSettingsAccordion.content.is().displayed()
                .and().has().text(containsString("Nulla facilisi. Phasellus sollicitudin"));

        generalSettingsAccordion.collapse();
        generalSettingsAccordion.is().collapsed();
        generalSettingsAccordion.content.is().hidden();
    }

    @Test
    public void accordionTextTest() {
        usersAccordion.is().displayed();
        usersAccordion.firstHeader.has().text("Users");
        usersAccordion.secondHeader.has().text("You are currently not an owner");

        usersAccordion.expand();
        usersAccordion.is().expanded();
        usersAccordion.content.has().text(containsString("Donec placerat, lectus sed mattis semper"));
    }

    @Test
    public void severalAccordionsExpandTest() {
        advancedSettingsAccordion.expand();
        advancedSettingsAccordion.is().expanded();
        advancedSettingsAccordion.content.is().displayed();

        personalDataAccordion.expand();
        personalDataAccordion.is().expanded();
        personalDataAccordion.content.is().displayed();

        advancedSettingsAccordion.content.is().hidden();
    }
}
