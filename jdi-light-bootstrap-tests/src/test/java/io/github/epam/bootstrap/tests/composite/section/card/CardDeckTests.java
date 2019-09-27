package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Zaur Bibilov on 27.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class CardDeckTests extends TestsInit {

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

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isCardDeckTest() {
        cardDeckWithoutFooter.highlight();
        cardDeckWithoutFooter.is().core().attr("class", "card-deck");

        cardDeckWithFooter.highlight();
        cardDeckWithFooter.is().core().attr("class", "card-deck");
    }

    @Test
    public void getSrcTest() {
        cardDeckWithoutFooter.highlight();
        assertEquals(cardDeckWithoutFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardDeckWithoutFooter.card2.image.src(), card2ImageSrc);

        cardDeckWithFooter.highlight();
        assertEquals(cardDeckWithFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardDeckWithFooter.card2.image.src(), card2ImageSrc);
    }

    @Test
    public void getAltTest() {
        cardDeckWithoutFooter.highlight();
        assertEquals(cardDeckWithoutFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardDeckWithoutFooter.card2.image.alt(), card2ImageAlt);

        cardDeckWithFooter.highlight();
        assertEquals(cardDeckWithFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardDeckWithFooter.card2.image.alt(), card2ImageAlt);
    }

    @Test
    public void getTitleTextTest() {
        cardDeckWithoutFooter.highlight();
        assertEquals(cardDeckWithoutFooter.card1.title.getText(), card1Title);
        assertEquals(cardDeckWithoutFooter.card2.title.getText(), card2Title);

        cardDeckWithFooter.highlight();
        assertEquals(cardDeckWithFooter.card1.title.getText(), card1Title);
        assertEquals(cardDeckWithFooter.card2.title.getText(), card2Title);
    }

    @Test
    public void getMainTextTest() {
        cardDeckWithoutFooter.highlight();
        assertEquals(cardDeckWithoutFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardDeckWithoutFooter.card2.mainText.getText(), card2MainText);

        cardDeckWithFooter.highlight();
        assertEquals(cardDeckWithFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardDeckWithFooter.card2.mainText.getText(), card2MainText);
    }

    @Test
    public void getMutedTextTest() {
        cardDeckWithoutFooter.highlight();
        assertEquals(cardDeckWithoutFooter.card1.mutedText.getText(), card1HeroName);
        assertEquals(cardDeckWithoutFooter.card2.mutedText.getText(), card2HeroName);
    }

    @Test
    public void getFooterTextTest() {
        cardDeckWithFooter.highlight();
        assertEquals(cardDeckWithFooter.card1.footerText.getText(), card1HeroName);
        assertEquals(cardDeckWithFooter.card2.footerText.getText(), card2HeroName);
    }

    @Test
    public void isValidationTest() {
        cardDeckWithoutFooter.highlight();
        cardDeckWithoutFooter.card1.title.is().text(card1Title);
        cardDeckWithoutFooter.card2.title.is().text(card2Title);
        cardDeckWithoutFooter.card1.image.is().src(card1ImageSrc);
        cardDeckWithoutFooter.card2.image.is().src(card2ImageSrc);
        cardDeckWithoutFooter.card1.image.is().alt(card1ImageAlt);
        cardDeckWithoutFooter.card2.image.is().alt(card2ImageAlt);
        cardDeckWithoutFooter.card1.mainText.is().text(card1MainText);
        cardDeckWithoutFooter.card2.mainText.is().text(card2MainText);
        cardDeckWithoutFooter.card1.mutedText.is().text(card1HeroName);
        cardDeckWithoutFooter.card2.mutedText.is().text(card2HeroName);

        cardDeckWithFooter.highlight();
        cardDeckWithFooter.card1.title.is().text(card1Title);
        cardDeckWithFooter.card2.title.is().text(card2Title);
        cardDeckWithFooter.card1.image.is().src(card1ImageSrc);
        cardDeckWithFooter.card2.image.is().src(card2ImageSrc);
        cardDeckWithFooter.card1.image.is().alt(card1ImageAlt);
        cardDeckWithFooter.card2.image.is().alt(card2ImageAlt);
        cardDeckWithFooter.card1.mainText.is().text(card1MainText);
        cardDeckWithFooter.card2.mainText.is().text(card2MainText);
        cardDeckWithFooter.card1.footerText.is().text(card1HeroName);
        cardDeckWithFooter.card2.footerText.is().text(card2HeroName);
    }

}
