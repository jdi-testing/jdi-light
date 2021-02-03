package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.materialPageFrame;
import static io.github.com.StaticSite.surfaceAccordionDisabledPage;
import static io.github.com.StaticSite.surfaceAccordionPage;

public class AccordionTests extends TestsInit {

    @Test
    public void defaultAccordionTest() {
        surfaceAccordionPage.shouldBeOpened();

        materialPageFrame.accordion.is().collapsed();
        materialPageFrame.accordion.is().enabled();
        materialPageFrame.accordion.expand();
        materialPageFrame.accordion.is().contentVisible();

        materialPageFrame.accordion.collapse();
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
