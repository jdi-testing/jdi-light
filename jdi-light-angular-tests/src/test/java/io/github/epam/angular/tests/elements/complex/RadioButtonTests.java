package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.radioButtonPage;
import static io.github.com.pages.RadioButtonPage.*;

public class RadioButtonTests extends TestsInit {
    private static final String SPRING = "Spring";
    private static final String SUMMER = "Summer";
    private static final String AUTUMN = "Autumn";
    private static final String WINTER = "Winter";

    @BeforeMethod
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

    @Test
    public void seasonsRadioButtonsTest() {
        seasonRadioGroup.show();
        seasonRadioGroup.is().displayed();
        winterRadioButton.click();
        seasonRadioGroup.click(SUMMER);
        seasonRadioGroup.click(WINTER);
        seasonRadioGroup.click(AUTUMN);

        seasonRadioGroup.click(SPRING);
        seasonRadioGroup.is().checked(SPRING);
        yourFavoriteSeasonText.has().text(format("Your favorite season is: %s", SPRING));

        seasonRadioGroup.is().notChecked(WINTER);
        seasonRadioGroup.is().notChecked(SUMMER);
        seasonRadioGroup.is().notChecked(AUTUMN);
    }

    @Test(description = "Test verifies that radio-button label in in before position")
    public void labelInBeforePosition() {
        labelPositionRadioGroup.is().isBeforePosition();
    }

    @Test(description = "Test verifies that radio-button group is disabled")
    public void radioGroupDisabled() {
        disabledRadioGroup.is().isDisabled();
    }

    @Test(description = "Test verifies that radio-button group is required")
    public void radioGroupRequired() {
        requiredRadioGroup.is().isRequired();
    }

    @Test(description = "Test verifies radio-button ripple effect")
    public void rippleEffect() {
        rippleDisabledRadioGroup.is().hasNoRippleEffect("1");
        basicRadioGroup.is().hasRippleEffect("1");
    }

    @Test(description = "Test verifies radio-button aria-label")
    public void hasAriaLabel() {
        String ARIALABEL = "Select an option";
        basicRadioGroup.is().hasAriaLabel(ARIALABEL);
    }

}
