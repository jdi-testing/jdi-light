package io.github.epam.material.tests.surfaces;


import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.accordionFrame;

public class AccordionTests extends TestsInit {

    @Test
    public void defaultAccordionTest(){
        openSection("Accordion");
        accordionFrame.enableAccordion.isEnabled();
        accordionFrame.enableAccordion.is().collapsed();
        accordionFrame.enableAccordion.click();
        accordionFrame.enableAccordion.is().contentVisible();
        accordionFrame.enableAccordion.click();
        accordionFrame.enableAccordion.is().collapsed();
        accordionFrame.enableAccordion.is().contentInvisible();
    }

    @Test
    public void buttonAccordionTest(){
        openSection("Accordion");
        accordionFrame.enableAccordion.is().collapsed();
        accordionFrame.enableButton.click();
        accordionFrame.enableAccordion.is().contentVisible();
        accordionFrame.enableButton.click();
        accordionFrame.enableAccordion.is().contentInvisible();
    }

    @Test
    public void disableAccordionTest(){
        openSection("Accordion");
        accordionFrame.disableAccordion.isDisabled();
    }

    @Test
    public void disableButtonAccordionTest(){
        accordionFrame.disableButton.isDisabled();
    }
}
