package io.github.epam.angular.tests.elements.complex;

import io.github.com.pages.sections.RadioButtonSection;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.apache.tika.mime.MediaType.text;
import static org.testng.Assert.assertEquals;

public class RadioButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    String enableSeasonButton = "mat-radio-button example-radio-button mat-accent cdk-focused cdk-mouse-focused mat-radio-checked";
    String disableSeasonButton = "mat-radio-button example-radio-button mat-accent";

    String enableBasicButton = "mat-radio-button mat-accent cdk-focused cdk-mouse-focused mat-radio-checked";
    String disableBasicButton = "mat-radio-button mat-accent";

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
        radioButtonSection.firstBasicRadioButton.has().attr("class", enableBasicButton);
        radioButtonSection.secondBasicRadioButton.has().attr("class", disableBasicButton);
    }

    @Test
    public void onlyOneOptionTwoButtonEnabledTest() {
        radioButtonSection.secondBasicRadioButton.click();
        radioButtonSection.firstBasicRadioButton.has().attr("class", disableBasicButton);
        radioButtonSection.secondBasicRadioButton.has().attr("class", enableBasicButton);
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
        radioButtonSection.winterNGModelRadioButton.has().attr("class",enableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", disableSeasonButton);
    }

    @Test
    public void onlyOneSpringButtonEnabledTest() {
        radioButtonSection.springNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr("class",disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", enableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", disableSeasonButton);
    }

    @Test
    public void onlyOneSummerButtonEnabledTest() {
        radioButtonSection.summerNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr("class",disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", enableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", disableSeasonButton);
    }

    @Test
    public void onlyOneAutumnButtonEnabledTest() {
        radioButtonSection.autumnNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr("class",disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", enableSeasonButton);
    }

}
