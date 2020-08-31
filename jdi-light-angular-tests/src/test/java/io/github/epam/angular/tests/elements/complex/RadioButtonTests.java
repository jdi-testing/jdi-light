package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.radioButtonSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.matchesRegex;

public class RadioButtonTests extends TestsInit {

    private static String enableButton = ".* cdk-focused cdk-mouse-focused mat-radio-checked";
    private static String disableSeasonButton = "mat-radio-button example-radio-button mat-accent";
    private static String disableBasicButton = "mat-radio-button mat-accent";
    private static String attrNameButton = "class";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedBasicRadioButtonTest() {
        radioButtonSection.basicRadioButtons.is().displayed();
        radioButtonSection.firstBasicRadioButton.is().displayed();
        radioButtonSection.secondBasicRadioButton.is().displayed();
    }

    @Test
    public void displayedSeasonRadioButtonTest() {
        radioButtonSection.seasonRadioButtons.is().displayed();
        radioButtonSection.winterNGModelRadioButton.is().displayed();
        radioButtonSection.springNGModelRadioButton.is().displayed();
        radioButtonSection.summerNGModelRadioButton.is().displayed();
        radioButtonSection.autumnNGModelRadioButton.is().displayed();
    }

    @Test
    public void nameBasicRadioButtonTest() {
        radioButtonSection.firstBasicRadioButton.has().text("Option 1");
        radioButtonSection.secondBasicRadioButton.has().text("Option 2");
    }

    @Test
    public void onlyOneOptionOneButtonEnabledTest() {
        radioButtonSection.firstBasicRadioButton.click();
        radioButtonSection.firstBasicRadioButton.has().attr(attrNameButton, matchesRegex(enableButton));
        radioButtonSection.secondBasicRadioButton.has().attr(attrNameButton, disableBasicButton);
    }

    @Test
    public void onlyOneOptionTwoButtonEnabledTest() {
        radioButtonSection.secondBasicRadioButton.click();
        radioButtonSection.firstBasicRadioButton.has().attr(attrNameButton, disableBasicButton);
        radioButtonSection.secondBasicRadioButton.has().attr(attrNameButton, matchesRegex(enableButton));
    }

    @Test
    public void nameSeasonRadioButtonTest() {
        radioButtonSection.winterNGModelRadioButton.has().text("Winter");
        radioButtonSection.springNGModelRadioButton.has().text("Spring");
        radioButtonSection.summerNGModelRadioButton.has().text("Summer");
        radioButtonSection.autumnNGModelRadioButton.has().text("Autumn");
    }

    @Test
    public void favoriteSeasonTest() {
        radioButtonSection.winterNGModelRadioButton.click();
        radioButtonSection.favoriteSeason.has().text("Your favorite season is: Winter");
        radioButtonSection.springNGModelRadioButton.click();
        radioButtonSection.favoriteSeason.has().text("Your favorite season is: Spring");
        radioButtonSection.summerNGModelRadioButton.click();
        radioButtonSection.favoriteSeason.has().text("Your favorite season is: Summer");
        radioButtonSection.autumnNGModelRadioButton.click();
        radioButtonSection.favoriteSeason.has().text("Your favorite season is: Autumn");

    }

    @Test
    public void onlyOneWinterButtonEnabledTest() {
        radioButtonSection.winterNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr(attrNameButton, matchesRegex(enableButton));
        radioButtonSection.springNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
    }

    @Test
    public void onlyOneSpringButtonEnabledTest() {
        radioButtonSection.springNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr(attrNameButton, matchesRegex(enableButton));
        radioButtonSection.summerNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
    }

    @Test
    public void onlyOneSummerButtonEnabledTest() {
        radioButtonSection.summerNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr(attrNameButton, matchesRegex(enableButton));
        radioButtonSection.autumnNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
    }

    @Test
    public void onlyOneAutumnButtonEnabledTest() {
        radioButtonSection.autumnNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr(attrNameButton, disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr(attrNameButton, matchesRegex(enableButton));
    }
}