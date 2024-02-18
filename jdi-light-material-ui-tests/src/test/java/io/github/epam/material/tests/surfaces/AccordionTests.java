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
 * https://v4.mui.com/components/accordion/
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
        disabledAccordion.details.is().hidden();
    }

    @Test
    public void accordionExpandTest() {
        generalSettingsAccordion.is().enabled();
        generalSettingsAccordion.details.is().hidden();

        generalSettingsAccordion.expand();
        generalSettingsAccordion.is().expanded();
        generalSettingsAccordion.details.is().displayed()
                .and().has().text(containsString("Nulla facilisi. Phasellus sollicitudin"));

        generalSettingsAccordion.collapse();
        generalSettingsAccordion.is().collapsed();
        generalSettingsAccordion.details.is().hidden();
    }

    @Test
    public void accordionTextTest() {
        usersAccordion.is().displayed();
        usersAccordion.has().firstHeader("Users");
        usersAccordion.secondHeader.has().text("You are currently not an owner");

        usersAccordion.expand();
        usersAccordion.is().expanded();
        usersAccordion.details.has().text(containsString("Donec placerat, lectus sed mattis semper"));
    }

    @Test
    public void severalAccordionsExpandTest() {
        advancedSettingsAccordion.expand();
        advancedSettingsAccordion.is().expanded();
        advancedSettingsAccordion.details.is().displayed();

        personalDataAccordion.has().hasNoSecondHeader();
        personalDataAccordion.expand();
        personalDataAccordion.is().expanded();
        personalDataAccordion.details.is().displayed();

        advancedSettingsAccordion.details.is().hidden();
    }
}
