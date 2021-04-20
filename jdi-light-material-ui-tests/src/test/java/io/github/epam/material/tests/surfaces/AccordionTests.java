package io.github.epam.material.tests.surfaces;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.surfaces.AccordionPage.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * https://material-ui.com/components/accordion/#accordion
 */

public class AccordionTests extends TestsInit {

    private static Timer timer = new Timer(1000L);

    @BeforeMethod
    public void before(){
        openSection("Accordion");
    }

    @Test
    public void disableAccordionTest(){
        assertTrue(disabledAccordion.isDisabled());
    }

    @Test
    public void defaultAccordionTest() {
        assertTrue(enabledAccordion.isEnabled());
        enabledAccordion.expand();
        assertTrue(enabledAccordion.list().isDisplayed());
        enabledAccordion.close();
        timer.wait(() -> enabledAccordion.is().collapsed());
        timer.wait(() -> assertFalse(enabledAccordion.list().isDisplayed()));
    }

    @Test
    public void textAccordionTest(){
        String rootContent = enabledAccordion.getText();
        assertTrue(rootContent.contains("General settings"));
        enabledAccordion.expand();
        String listContent = enabledAccordion.list().get(1).getText();
        assertTrue(listContent.contains("Nulla facilisi."));
    }

}
