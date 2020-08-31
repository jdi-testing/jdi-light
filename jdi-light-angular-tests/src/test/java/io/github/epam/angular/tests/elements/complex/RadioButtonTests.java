package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.RadioButtonSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class RadioButtonTests extends TestsInit {

    private final String SPRING = "Spring";
    private final String SUMMER = "Summer";
    private final String AUTUMN = "Autumn";
    private final String WINTER = "Winter";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicRadioButtonsTest() {
        basicRadioButtons.is().displayed();
        basicRadioButtons.clickRadioButtonByValue("2");
        basicRadioButtons.clickRadioButtonByValue("1");
        basicRadioButtons.clickRadioButtonByValue("2");

        basicRadioButtons.is().assertRadioButtonIsChecked("2");
        basicRadioButtons.is().assertRadioButtonIsNotChecked("1");
    }

    @Test
    public void seasonsRadioButtonsTest() {
        seasonRadioButtons.is().displayed();
        seasonRadioButtons.clickRadioButtonByValue(SUMMER);
        seasonRadioButtons.clickRadioButtonByValue(WINTER);
        seasonRadioButtons.clickRadioButtonByValue(AUTUMN);

        seasonRadioButtons.clickRadioButtonByValue(SPRING);
        seasonRadioButtons.is().assertRadioButtonIsChecked(SPRING);
        favoriteSeasonField.has().text(String.format("Your favorite season is: %s", SPRING));


        seasonRadioButtons.is().assertRadioButtonIsNotChecked(WINTER);
        seasonRadioButtons.is().assertRadioButtonIsNotChecked(SUMMER);
        seasonRadioButtons.is().assertRadioButtonIsNotChecked(AUTUMN);
    }
}
