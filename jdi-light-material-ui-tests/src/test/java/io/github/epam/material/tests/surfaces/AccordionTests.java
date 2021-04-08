package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.surfaces.AccordionPage.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AccordionTests extends TestsInit {

    @Test
    public void disableAccordionTest(){
        openSection("Accordion");
        assertTrue(disabledAccordion.isDisabled());
    }

    @Test
    public void defaultAccordionTest() {
        openSection("Accordion");
        assertTrue(enabledAccordion.isEnabled());
        enabledAccordion.expand();
        assertTrue(enabledAccordion.list().isDisplayed());
        enabledAccordion.close();
        enabledAccordion.is().collapsed();
        assertFalse(enabledAccordion.list().isDisplayed());
    }

}
