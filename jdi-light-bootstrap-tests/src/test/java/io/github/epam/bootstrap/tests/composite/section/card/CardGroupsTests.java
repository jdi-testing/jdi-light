package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardGroupWithFooter;
import static io.github.com.pages.BootstrapPage.cardGroupWithoutFooter;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class CardGroupsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String card1Title = "SPIDER MAN";
    private String card2Title = "HULK";
    private String card1ImageSrc = "https://jdi-testing.github.io/jdi-light/images/spider-man.jpg";
    private String card2ImageSrc = "https://jdi-testing.github.io/jdi-light/images/hulk.jpg";
    private String card1ImageAlt = "spider-man";
    private String card2ImageAlt = "hulk";
    private String card1MainText = "Spider-Man is a fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko.";
    private String card2MainText = "The Hulk is a fictional superhero appearing in publications by the American publisher Marvel Comics.";
    private String card1HeroName = "Peter Parker";
    private String card2HeroName = "Bruce Banner";

    @Test
    public void getSrcTest() {
        assertEquals(cardGroupWithoutFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardGroupWithoutFooter.card2.image.src(), card2ImageSrc);
        assertEquals(cardGroupWithFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardGroupWithFooter.card2.image.src(), card2ImageSrc);
    }

    @Test
    public void getAltTest() {
        assertEquals(cardGroupWithoutFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardGroupWithoutFooter.card2.image.alt(), card2ImageAlt);
        assertEquals(cardGroupWithFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardGroupWithFooter.card2.image.alt(), card2ImageAlt);
    }

    @Test
    public void getTitleTextTest() {
        assertEquals(cardGroupWithoutFooter.card1.title.getText(), card1Title);
        assertEquals(cardGroupWithoutFooter.card2.title.getText(), card2Title);
        assertEquals(cardGroupWithFooter.card1.title.getText(), card1Title);
        assertEquals(cardGroupWithFooter.card2.title.getText(), card2Title);
    }

    @Test
    public void getMainTextTest() {
        assertEquals(cardGroupWithoutFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardGroupWithoutFooter.card2.mainText.getText(), card2MainText);
        assertEquals(cardGroupWithFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardGroupWithFooter.card2.mainText.getText(), card2MainText);
    }

    @Test
    public void getMutedTextTest() {
        assertEquals(cardGroupWithoutFooter.card1.mutedText.getText(), card1HeroName);
        assertEquals(cardGroupWithoutFooter.card2.mutedText.getText(), card2HeroName);
    }

    @Test
    public void getFooterTextTest() {
        assertEquals(cardGroupWithFooter.card1.footerText.getText(), card1HeroName);
        assertEquals(cardGroupWithFooter.card2.footerText.getText(), card2HeroName);
    }

    @Test
    public void getTitleIsValidationTest() {
        cardGroupWithoutFooter.card1.title.is().text(card1Title);
        cardGroupWithoutFooter.card2.title.is().text(card2Title);
        cardGroupWithoutFooter.card1.image.is().src(card1ImageSrc);
        cardGroupWithoutFooter.card2.image.is().src(card2ImageSrc);
        cardGroupWithoutFooter.card1.image.is().alt(card1ImageAlt);
        cardGroupWithoutFooter.card2.image.is().alt(card2ImageAlt);
        cardGroupWithoutFooter.card1.mainText.is().text(card1MainText);
        cardGroupWithoutFooter.card2.mainText.is().text(card2MainText);
        cardGroupWithoutFooter.card1.mutedText.is().text(card1HeroName);
        cardGroupWithoutFooter.card2.mutedText.is().text(card2HeroName);

        cardGroupWithFooter.card1.title.is().text(card1Title);
        cardGroupWithFooter.card2.title.is().text(card2Title);
        cardGroupWithFooter.card1.image.is().src(card1ImageSrc);
        cardGroupWithFooter.card2.image.is().src(card2ImageSrc);
        cardGroupWithFooter.card1.image.is().alt(card1ImageAlt);
        cardGroupWithFooter.card2.image.is().alt(card2ImageAlt);
        cardGroupWithFooter.card1.mainText.is().text(card1MainText);
        cardGroupWithFooter.card2.mainText.is().text(card2MainText);
        cardGroupWithFooter.card1.footerText.is().text(card1HeroName);
        cardGroupWithFooter.card2.footerText.is().text(card2HeroName);
    }
}