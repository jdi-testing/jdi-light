package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.accordionFrame;
import static io.github.com.StaticSite.surfaceAccordionDisabledPage;
import static io.github.com.StaticSite.surfaceAccordionPage;

public class AccordionTests extends TestsInit {

    @Test
    public void defaultAccordionTest() {
        surfaceAccordionPage.open();

        accordionFrame.accordion.is().collapsed();
        accordionFrame.accordion.is().enabled();
        accordionFrame.accordion.expand();
        accordionFrame.accordion.is().contentVisible();

        accordionFrame.accordion.collapse();
        accordionFrame.accordion.is().contentInvisible();
    }

    @Test
    public void disabledAccordionTest() {
        surfaceAccordionDisabledPage.open();

        accordionFrame.accordion.is().collapsed();
        accordionFrame.accordion.is().disabled();
        accordionFrame.accordion.click();
        accordionFrame.accordion.is().collapsed();
        accordionFrame.accordion.is().contentInvisible();
    }
}
