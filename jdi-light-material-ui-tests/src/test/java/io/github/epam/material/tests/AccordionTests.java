package io.github.epam.material.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class AccordionTests extends TestsInit {

    @Test
    public void defaultAccordionTest() {
        surfaceAccordionPage.shouldBeOpened();

        materialPageFrame.accordion.is().collapsed();
        materialPageFrame.accordion.is().enabled();
        materialPageFrame.accordion.click();
        materialPageFrame.accordion.is().expanded();
        materialPageFrame.accordion.is().contentVisible();

        materialPageFrame.accordion.click();
        materialPageFrame.accordion.is().collapsed();
        materialPageFrame.accordion.is().contentInvisible();
    }

    @Test
    public void disabledAccordionTest() {
        surfaceAccordionDisabledPage.shouldBeOpened();

        materialPageFrame.accordion.is().collapsed();
        materialPageFrame.accordion.is().disabled();
        materialPageFrame.accordion.click();
        materialPageFrame.accordion.is().collapsed();
        materialPageFrame.accordion.is().contentInvisible();
    }
}
