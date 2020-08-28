package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.RadioButtonSection.seasonRadioButtons;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.assertTrue;

public class RadioButtonsUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void clickRadioButtonByValue(){
        seasonRadioButtons.clickRadioButtonByValue("Spring");
        assertTrue(seasonRadioButtons.isRadioButtonChecked("Spring"));
    }
}
