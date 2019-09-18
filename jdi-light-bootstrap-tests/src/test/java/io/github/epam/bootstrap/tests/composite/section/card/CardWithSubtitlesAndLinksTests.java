package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithSubtitlesAndLinks;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Aleksandr Khmelinin on 17.09.2019
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
        assertEquals(cardWithSubtitlesAndLinks.link1.getText(), "JDI Light Github");
    }
    @Test
    public void getLink2TextTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.getText(), "JDI Website");
    }

    @Test
    public void getLink1ValueTest() {
        assertEquals(cardWithSubtitlesAndLinks.link1.getValue(), "JDI Light Github");
    }
    @Test
    public void getLink2ValueTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.getValue(), "JDI Website");
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
        assertEquals(cardWithSubtitlesAndLinks.link1.url().getPath(), "/jdi-testing/jdi-light");
    }
    @Test
    public void getLink2UrlTest() {
        assertEquals(cardWithSubtitlesAndLinks.link2.url().getPath(), "/jdi-light/index.html");
    }

    @Test
    public void clickLink1Test() {
        cardWithSubtitlesAndLinks.link1.click();
        assertEquals(getUrl() , link1Ref);
    }

}
