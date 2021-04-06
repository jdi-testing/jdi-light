package io.github.epam.material.tests.surfaces;

import com.epam.jdi.light.material.elements.surfaces.Accordion;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.accordionFrame;
import static io.github.com.StaticSite.surfaceAccordionDisabledPage;
import static io.github.com.StaticSite.surfaceAccordionPage;

public class AccordionTests extends TestsInit {

    @Test
    public void defaultAccordionTest() {

        openSection("Accordion");

        List<Accordion> accordionList = accordionFrame.accordion;

        for (Accordion accordionItem : accordionList
        ) {

            if (accordionItem.summary().text().contains("Disabled Accordion")) {
                accordionItem.click();
                accordionItem.is().collapsed();

            } else {
                accordionItem.is().collapsed();
                accordionItem.click();
                accordionItem.is().contentVisible();
                accordionItem.click();
                accordionItem.is().collapsed();
                accordionItem.is().contentInvisible();
            }
        }
    }


}
