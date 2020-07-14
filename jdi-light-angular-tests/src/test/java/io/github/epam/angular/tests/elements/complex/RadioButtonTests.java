package io.github.epam.angular.tests.elements.complex;

import io.github.com.pages.sections.RadioButtonSection;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.apache.tika.mime.MediaType.text;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesRegex;
import static org.testng.Assert.assertEquals;

public class RadioButtonTests extends TestsInit {

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
        radioButtonSection.firstBasicRadioButton.has().attr("class", matchesRegex(radioButtonSection.enableBasicButton));
        radioButtonSection.secondBasicRadioButton.has().attr("class", radioButtonSection.disableBasicButton);
    }

    @Test
    public void onlyOneOptionTwoButtonEnabledTest() {
        radioButtonSection.secondBasicRadioButton.click();
        radioButtonSection.firstBasicRadioButton.has().attr("class", radioButtonSection.disableBasicButton);
        radioButtonSection.secondBasicRadioButton.has().attr("class", matchesRegex(radioButtonSection.enableBasicButton));
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
        radioButtonSection.winterNGModelRadioButton.has().attr("class", matchesRegex(radioButtonSection.enableSeasonButton));
        radioButtonSection.springNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
    }

    @Test
    public void onlyOneSpringButtonEnabledTest() {
        radioButtonSection.springNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr("class",radioButtonSection.disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", matchesRegex(radioButtonSection.enableSeasonButton));
        radioButtonSection.summerNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
    }

    @Test
    public void onlyOneSummerButtonEnabledTest() {
        radioButtonSection.summerNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr("class",radioButtonSection.disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", matchesRegex(radioButtonSection.enableSeasonButton));
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
    }

    @Test
    public void onlyOneAutumnButtonEnabledTest() {
        radioButtonSection.autumnNGModelRadioButton.click();
        radioButtonSection.winterNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.springNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.summerNGModelRadioButton.has().attr("class", radioButtonSection.disableSeasonButton);
        radioButtonSection.autumnNGModelRadioButton.has().attr("class", matchesRegex(radioButtonSection.enableSeasonButton));
    }

}
