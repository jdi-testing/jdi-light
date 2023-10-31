package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.AngularColors.PRIMARY;
import static com.epam.jdi.light.angular.elements.enums.AngularColors.WARN;
import static com.epam.jdi.light.angular.elements.enums.AngularColors.ACCENT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.radioButtonPage;
import static io.github.com.pages.RadioButtonPage.*;
import static java.lang.String.format;

public class RadioButtonTests extends TestsInit {
    private static final String SPRING = "Spring";
    private static final String SUMMER = "Summer";
    private static final String AUTUMN = "Autumn";
    private static final String WINTER = "Winter";

    @BeforeClass
    public void before() {
        radioButtonPage.open();
        waitCondition(() -> radioButtonPage.isOpened());
        radioButtonPage.checkOpened();
    }

    @Test(description = "Test verifies value and the radio-button is checked")
    public void basicRadioButtonsTest() {
        basicRadioGroup.show();
        basicRadioGroup.is().displayed();
        basicRadioGroup.click("2");
        basicRadioGroup.click("1");
        basicRadioGroup.click("2");
        basicRadioGroup.is().checked("2");
        basicRadioGroup.is().notChecked("1");
    }

    @Test(description = "Test verifies radio group with ngModel functionality")
    public void ngModelFunctionalityTest() {
        seasonRadioGroup.show();
        seasonRadioGroup.is().displayed();
        seasonRadioGroup.click(WINTER);
        seasonRadioGroup.is().checked(WINTER);
        yourFavoriteSeasonText.has().text(format("Your favorite season is: %s", WINTER));

        seasonRadioGroup.click(SPRING);
        seasonRadioGroup.is().checked(SPRING);
        yourFavoriteSeasonText.has().text(format("Your favorite season is: %s", SPRING));

        seasonRadioGroup.is().notChecked(WINTER);
        seasonRadioGroup.is().notChecked(SUMMER);
        seasonRadioGroup.is().notChecked(AUTUMN);
    }

    @Test(description = "Test verifies that radio-group label in in before/after position")
    public void labelGroupPositionTest() {
        labelPositionRadioGroup.is().groupBeforePosition();
        basicRadioGroup.is().groupAfterPosition();
    }

    @Test(description = "Test verifies that radio-button label in in before/after position")
    public void labelRadioButtonPositionTest() {
        elementPositionRadioGroup.radioButtons().get(0).is().radioButtonBeforePosition();
        basicRadioGroup.radioButtons().get(0).is().radioButtonAfterPosition();

    }

    @Test(description = "Test verifies that radio-button group is disabled/enabled")
    public void radioGroupDisabledTest() {
        disabledRadioGroup.is().disabled();
        basicRadioGroup.is().enabled();
    }

    @Test(description = "Test verifies that radio-button in group is disabled/enabled")
    public void radioButtonDisabledTest() {
        disabledRadioGroup.radioButtons().get(0).is().disabled();
        basicRadioGroup.radioButtons().get(0).is().enabled();
    }

    @Test(description = "Test verifies that radio-button group is required/not required")
    public void radioGroupRequiredTest() {
        requiredRadioGroup.show();
        requiredRadioGroup.is().displayed();
        requiredRadioGroup.is().required();
        basicRadioGroup.is().notRequired();
    }

    @Test(description = "Check radio buttons colors")
    public void colorButtonsTest() {
        colorRadioGroup.show();
        colorRadioGroup.is().displayed();
        primaryRadioButton.click();
        primaryRadioButton.has().color(PRIMARY);
        warnRadioButton.click();
        warnRadioButton.has().color(WARN);
        accentRadioButton.click();
        accentRadioButton.has().color(ACCENT);
    }
}
