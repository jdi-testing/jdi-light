package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardColumnsSection;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardColumnsTests extends TestsInit {

    private String mainText = "I don’t want to go.";
    private String titleText = "WHO IS HULK?";
    private String footerText = "Nick Fury in Captain Marvel";
    private String mutedText = "Last updated 3 mins ago";
    private String imageSrc = "https://jdi-testing.github.io/jdi-light/images/hulk.jpg";
    private String imageAlt = "hulk";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void checkElementsPositionTest() {
        assertTrue(cardColumnsSection.topLeftCard.core().getLocation().x < cardColumnsSection.topRightCard.core().getLocation().x);
        assertTrue(cardColumnsSection.topLeftCard.core().getLocation().y < cardColumnsSection.bottomLeftCard.core().getLocation().y);
        assertTrue(cardColumnsSection.topRightCard.core().getLocation().y < cardColumnsSection.middleRightCard.core().getLocation().y);
        assertTrue(cardColumnsSection.middleRightCard.core().getLocation().y < cardColumnsSection.bottomRightCard.core().getLocation().y);
        assertTrue(cardColumnsSection.bottomLeftCard.core().getLocation().x < cardColumnsSection.bottomRightCard.core().getLocation().x);
        assertTrue(cardColumnsSection.bottomLeftCard.core().getLocation().x < cardColumnsSection.middleRightCard.core().getLocation().x);
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardColumnsSection.topLeftCard.mainText.getText(), mainText);
    }

    @Test
    public void getMutedTextTest() {
        assertEquals(cardColumnsSection.bottomLeftCard.mutedText.getText(), mutedText);
    }

    @Test
    public void getFooterTextTest() {
        assertEquals(cardColumnsSection.topRightCard.footerText.getText(), footerText);
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardColumnsSection.bottomLeftCard.image.src(), imageSrc);
    }

    @Test
    public void isValidationTest() {
        cardColumnsSection.bottomLeftCard.title.is().text(is(titleText));
        cardColumnsSection.topLeftCard.mainText.is().text(is(mainText));
        cardColumnsSection.bottomLeftCard.mutedText.is().displayed()
                .and().text(is(mutedText))
                .core()
                .css("font-size", is("11.2px"))
                .tag(is("small"));
        cardColumnsSection.bottomLeftCard.image.is().displayed()
                .and().src(is(imageSrc))
                .core()
                .attr("alt", imageAlt);
        cardColumnsSection.bottomLeftCard.image.assertThat().width(is(130));
        cardColumnsSection.bottomLeftCard.image.assertThat().height(is(160));
    }
}
