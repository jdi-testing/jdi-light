package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardDeckSectionWithFooter;
import static io.github.com.pages.BootstrapPage.cardDeckSectionWithoutFooter;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Zaur Bibilov on 27.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class CardDeckTests extends TestsInit {

    private static final String card1Title = "SPIDER MAN";
    private static final String card2Title = "HULK";
    private static final String card1ImageSrc = "https://jdi-testing.github.io/jdi-light/images/spider-man.jpg";
    private static final String card2ImageSrc = "https://jdi-testing.github.io/jdi-light/images/hulk.jpg";
    private static final String card1ImageAlt = "spider-man";
    private static final String card2ImageAlt = "hulk";
    private static final String card1MainText = "Spider-Man is a fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko.";
    private static final String card2MainText = "The Hulk is a fictional superhero appearing in publications by the American publisher Marvel Comics.";
    private static final String card1HeroName = "Peter Parker";
    private static final String card2HeroName = "Bruce Banner";

    private static final String cardDeckClass = "card-deck";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isCardDeckTest() {
        cardDeckSectionWithoutFooter.highlight();
        cardDeckSectionWithoutFooter.is().core().hasClass(cardDeckClass);

        cardDeckSectionWithFooter.highlight();
        cardDeckSectionWithFooter.is().core().hasClass(cardDeckClass);
    }

    @Test
    public void getSrcTest() {
        cardDeckSectionWithoutFooter.highlight();
        assertEquals(cardDeckSectionWithoutFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardDeckSectionWithoutFooter.card2.image.src(), card2ImageSrc);

        cardDeckSectionWithFooter.highlight();
        assertEquals(cardDeckSectionWithFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardDeckSectionWithFooter.card2.image.src(), card2ImageSrc);
    }

    @Test
    public void getAltTest() {
        cardDeckSectionWithoutFooter.highlight();
        assertEquals(cardDeckSectionWithoutFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardDeckSectionWithoutFooter.card2.image.alt(), card2ImageAlt);

        cardDeckSectionWithFooter.highlight();
        assertEquals(cardDeckSectionWithFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardDeckSectionWithFooter.card2.image.alt(), card2ImageAlt);
    }

    @Test
    public void getTitleTextTest() {
        cardDeckSectionWithoutFooter.highlight();
        assertEquals(cardDeckSectionWithoutFooter.card1.title.getText(), card1Title);
        assertEquals(cardDeckSectionWithoutFooter.card2.title.getText(), card2Title);

        cardDeckSectionWithFooter.highlight();
        assertEquals(cardDeckSectionWithFooter.card1.title.getText(), card1Title);
        assertEquals(cardDeckSectionWithFooter.card2.title.getText(), card2Title);
    }

    @Test
    public void getMainTextTest() {
        cardDeckSectionWithoutFooter.highlight();
        assertEquals(cardDeckSectionWithoutFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardDeckSectionWithoutFooter.card2.mainText.getText(), card2MainText);

        cardDeckSectionWithFooter.highlight();
        assertEquals(cardDeckSectionWithFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardDeckSectionWithFooter.card2.mainText.getText(), card2MainText);
    }

    @Test
    public void getMutedTextTest() {
        cardDeckSectionWithoutFooter.highlight();
        assertEquals(cardDeckSectionWithoutFooter.card1.mutedText.getText(), card1HeroName);
        assertEquals(cardDeckSectionWithoutFooter.card2.mutedText.getText(), card2HeroName);
    }

    @Test
    public void getFooterTextTest() {
        cardDeckSectionWithFooter.highlight();
        assertEquals(cardDeckSectionWithFooter.card1.footerText.getText(), card1HeroName);
        assertEquals(cardDeckSectionWithFooter.card2.footerText.getText(), card2HeroName);
    }

    @Test
    public void isValidationTest() {
        cardDeckSectionWithoutFooter.highlight();
        cardDeckSectionWithoutFooter.card1.title.is().text(card1Title);
        cardDeckSectionWithoutFooter.card2.title.is().text(card2Title);
        cardDeckSectionWithoutFooter.card1.image.is().src(card1ImageSrc);
        cardDeckSectionWithoutFooter.card2.image.is().src(card2ImageSrc);
        cardDeckSectionWithoutFooter.card1.image.is().alt(card1ImageAlt);
        cardDeckSectionWithoutFooter.card2.image.is().alt(card2ImageAlt);
        cardDeckSectionWithoutFooter.card1.mainText.is().text(card1MainText);
        cardDeckSectionWithoutFooter.card2.mainText.is().text(card2MainText);
        cardDeckSectionWithoutFooter.card1.mutedText.is().text(card1HeroName);
        cardDeckSectionWithoutFooter.card2.mutedText.is().text(card2HeroName);

        cardDeckSectionWithFooter.highlight();
        cardDeckSectionWithFooter.card1.title.is().text(card1Title);
        cardDeckSectionWithFooter.card2.title.is().text(card2Title);
        cardDeckSectionWithFooter.card1.image.is().src(card1ImageSrc);
        cardDeckSectionWithFooter.card2.image.is().src(card2ImageSrc);
        cardDeckSectionWithFooter.card1.image.is().alt(card1ImageAlt);
        cardDeckSectionWithFooter.card2.image.is().alt(card2ImageAlt);
        cardDeckSectionWithFooter.card1.mainText.is().text(card1MainText);
        cardDeckSectionWithFooter.card2.mainText.is().text(card2MainText);
        cardDeckSectionWithFooter.card1.footerText.is().text(card1HeroName);
        cardDeckSectionWithFooter.card2.footerText.is().text(card2HeroName);
    }

}
