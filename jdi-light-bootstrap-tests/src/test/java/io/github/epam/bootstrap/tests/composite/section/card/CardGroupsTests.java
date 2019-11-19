package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardGroupSectionWithFooter;
import static io.github.com.pages.BootstrapPage.cardGroupSectionWithoutFooter;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class CardGroupsTests extends TestsInit {

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
    public void getSrcTest() {
        assertEquals(cardGroupSectionWithoutFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardGroupSectionWithoutFooter.card2.image.src(), card2ImageSrc);
        assertEquals(cardGroupSectionWithFooter.card1.image.src(), card1ImageSrc);
        assertEquals(cardGroupSectionWithFooter.card2.image.src(), card2ImageSrc);
    }

    @Test
    public void getAltTest() {
        assertEquals(cardGroupSectionWithoutFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardGroupSectionWithoutFooter.card2.image.alt(), card2ImageAlt);
        assertEquals(cardGroupSectionWithFooter.card1.image.alt(), card1ImageAlt);
        assertEquals(cardGroupSectionWithFooter.card2.image.alt(), card2ImageAlt);
    }

    @Test
    public void getTitleTextTest() {
        assertEquals(cardGroupSectionWithoutFooter.card1.title.getText(), card1Title);
        assertEquals(cardGroupSectionWithoutFooter.card2.title.getText(), card2Title);
        assertEquals(cardGroupSectionWithFooter.card1.title.getText(), card1Title);
        assertEquals(cardGroupSectionWithFooter.card2.title.getText(), card2Title);
    }

    @Test
    public void getMainTextTest() {
        assertEquals(cardGroupSectionWithoutFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardGroupSectionWithoutFooter.card2.mainText.getText(), card2MainText);
        assertEquals(cardGroupSectionWithFooter.card1.mainText.getText(), card1MainText);
        assertEquals(cardGroupSectionWithFooter.card2.mainText.getText(), card2MainText);
    }

    @Test
    public void getMutedTextTest() {
        assertEquals(cardGroupSectionWithoutFooter.card1.mutedText.getText(), card1HeroName);
        assertEquals(cardGroupSectionWithoutFooter.card2.mutedText.getText(), card2HeroName);
    }

    @Test
    public void getFooterTextTest() {
        assertEquals(cardGroupSectionWithFooter.card1.footerText.getText(), card1HeroName);
        assertEquals(cardGroupSectionWithFooter.card2.footerText.getText(), card2HeroName);
    }

    @Test
    public void getTitleIsValidationTest() {
        cardGroupSectionWithoutFooter.card1.title.is().text(card1Title);
        cardGroupSectionWithoutFooter.card2.title.is().text(card2Title);
        cardGroupSectionWithoutFooter.card1.image.is().src(card1ImageSrc);
        cardGroupSectionWithoutFooter.card2.image.is().src(card2ImageSrc);
        cardGroupSectionWithoutFooter.card1.image.is().alt(card1ImageAlt);
        cardGroupSectionWithoutFooter.card2.image.is().alt(card2ImageAlt);
        cardGroupSectionWithoutFooter.card1.mainText.is().text(card1MainText);
        cardGroupSectionWithoutFooter.card2.mainText.is().text(card2MainText);
        cardGroupSectionWithoutFooter.card1.mutedText.is().text(card1HeroName);
        cardGroupSectionWithoutFooter.card2.mutedText.is().text(card2HeroName);

        cardGroupSectionWithFooter.card1.title.is().text(card1Title);
        cardGroupSectionWithFooter.card2.title.is().text(card2Title);
        cardGroupSectionWithFooter.card1.image.is().src(card1ImageSrc);
        cardGroupSectionWithFooter.card2.image.is().src(card2ImageSrc);
        cardGroupSectionWithFooter.card1.image.is().alt(card1ImageAlt);
        cardGroupSectionWithFooter.card2.image.is().alt(card2ImageAlt);
        cardGroupSectionWithFooter.card1.mainText.is().text(card1MainText);
        cardGroupSectionWithFooter.card2.mainText.is().text(card2MainText);
        cardGroupSectionWithFooter.card1.footerText.is().text(card1HeroName);
        cardGroupSectionWithFooter.card2.footerText.is().text(card2HeroName);
    }
}
