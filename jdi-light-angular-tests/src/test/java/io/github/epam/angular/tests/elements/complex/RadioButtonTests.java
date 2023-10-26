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
    private static final String primary = "primary";
    private static final String accent  = "accent";
    private static final String warn = "warn";

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
    public void seasonsRadioButtonsTest() {
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

    @Test(description = "Test verifies that radio-group label in in before position")
    public void labelInBeforePosition() {
        labelPositionRadioGroup.is().isGroupBeforePosition();
    }

    @Test(description = "Test verifies that radio-group label in in before position")
    public void elementLabelInBeforePosition() {
        elementPositionRadioGroup.is().isGroupElementBeforePosition("1");
    }


    @Test(description = "Test verifies that radio-button group is disabled")
    public void radioGroupDisabled() {
        disabledRadioGroup.is().isDisabled();
    }

    @Test(description = "Test verifies that radio-button group is required")
    public void radioGroupRequired() {
        requiredRadioGroup.show();
        requiredRadioGroup.is().visible();
        requiredRadioGroup.is().isRequired();
    }

    @Test(description = "Check radio buttons colors")
    public void colorButtonsTest() {
        primaryButton.click();
        colorRadioGroup.is().color(PRIMARY, primary);
        warnButton.click();
        colorRadioGroup.is().color(WARN, warn);
        accentButton.click();
        colorRadioGroup.is().color(ACCENT, accent);
    }
}
