package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.RadioButtonSection.seasonRadioGroup;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.assertTrue;

public class RadioButtonsUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        skipForFirefox();
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void clickRadioButtonByValue() {
        seasonRadioGroup.click("Spring");
        assertTrue(seasonRadioGroup.isChecked("Spring"));
    }
}
