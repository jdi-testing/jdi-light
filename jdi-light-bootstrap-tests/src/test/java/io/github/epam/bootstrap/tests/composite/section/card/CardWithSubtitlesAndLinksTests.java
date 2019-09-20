package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithSubtitlesAndLinks;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Aleksandr Khmelinin on 20.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardWithSubtitlesAndLinksTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String titleText = "CARD TITLE";
    private String subtitleText = "CARD SUBTITLE";
    private String mainText = "Some quick example text to build on the card title " +
            "and make up the bulk of the card's content.";
    private String link1Ref = "https://github.com/jdi-testing/jdi-light";
    private String link2Ref ="https://jdi-testing.github.io/jdi-light/index.html";
    private String link1Path = "/jdi-testing/jdi-light";
    private String link2Path ="/jdi-light/index.html";
    private String link1Text = "JDI Light Github";
    private String link2Text = "JDI Website";
    private String link1Value = "JDI Light Github";
    private String link2Value = "JDI Website";

    @Test
    public void getTitleTextTest() {
        assertEquals(cardWithSubtitlesAndLinks.title.getText(), titleText);
    }

    @Test
    public void getSubtitleTextTest() {
        assertEquals(cardWithSubtitlesAndLinks.subtitle.getText(), subtitleText);
    }

    @Test
    public void getMainTextTest() {
        assertEquals(cardWithSubtitlesAndLinks.mainText.getText(), mainText);
    }

    @Test
    public void getLink1TextTest() {
        assertEquals(cardWithSubtitlesAndLinks.link1.getText(), link1Text);
    }
    @Test
    public void getLink2TextTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.getText(), link2Text);
    }

    @Test
    public void getLink1ValueTest() {
        assertEquals(cardWithSubtitlesAndLinks.link1.getValue(), link1Value);
    }
    @Test
    public void getLink2ValueTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.getValue(), link2Value);
    }

    @Test
    public void getLink1RefTest() {
        assertEquals(cardWithSubtitlesAndLinks.link1.ref(), link1Ref);
    }
    @Test
    public void getLink2RefTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.ref(), link2Ref);
    }

    @Test
    public void getLink1UrlTest() {
        assertEquals(cardWithSubtitlesAndLinks.link1.url().getPath(), link1Path);
    }
    @Test
    public void getLink2UrlTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.url().getPath(), link2Path);
    }

    @Test
    public void clickLink1Test() {
        cardWithSubtitlesAndLinks.link1.click();
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl() , link1Ref);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    @Test
    public void clickLink2Test() {
        cardWithSubtitlesAndLinks.link2.click();
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl() , link2Ref);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValidationTest() {
        cardWithSubtitlesAndLinks.title.is().text(is(titleText));
        cardWithSubtitlesAndLinks.subtitle.is().text(is(subtitleText));
        cardWithSubtitlesAndLinks.mainText.is().text(is(mainText));
        cardWithSubtitlesAndLinks.link1.is().enabled();
        cardWithSubtitlesAndLinks.link2.is().enabled();
        cardWithSubtitlesAndLinks.link1.is().text(is(link1Text));
        cardWithSubtitlesAndLinks.link2.is().text(is(link2Text));
        cardWithSubtitlesAndLinks.link1.is().ref(link1Ref);
        cardWithSubtitlesAndLinks.link2.is().ref(link2Ref);
        cardWithSubtitlesAndLinks.link1.assertThat().text(is(link1Text));
        cardWithSubtitlesAndLinks.link2.assertThat().text(is(link2Text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardWithSubtitlesAndLinks.title);
        baseValidation(cardWithSubtitlesAndLinks.subtitle);
        baseValidation(cardWithSubtitlesAndLinks.mainText);
        baseValidation(cardWithSubtitlesAndLinks.link1);
        baseValidation(cardWithSubtitlesAndLinks.link2);
    }
}
