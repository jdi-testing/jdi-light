package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardColumns;
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
        assertTrue(cardColumns.topLeftCard.core().getLocation().x < cardColumns.topRightCard.core().getLocation().x);
        assertTrue(cardColumns.topLeftCard.core().getLocation().y < cardColumns.bottomLeftCard.core().getLocation().y);
        assertTrue(cardColumns.topRightCard.core().getLocation().y < cardColumns.middleRightCard.core().getLocation().y);
        assertTrue(cardColumns.middleRightCard.core().getLocation().y < cardColumns.bottomRightCard.core().getLocation().y);
        assertTrue(cardColumns.bottomLeftCard.core().getLocation().x < cardColumns.bottomRightCard.core().getLocation().x);
        assertTrue(cardColumns.bottomLeftCard.core().getLocation().x < cardColumns.middleRightCard.core().getLocation().x);
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardColumns.topLeftCard.mainText.getText(), mainText);
    }

    @Test
    public void getMutedTextTest() {
        assertEquals(cardColumns.bottomLeftCard.mutedText.getText(), mutedText);
    }

    @Test
    public void getFooterTextTest() {
        assertEquals(cardColumns.topRightCard.footerText.getText(), footerText);
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardColumns.bottomLeftCard.image.src(), imageSrc);
    }

    @Test
    public void isValidationTest() {
        cardColumns.bottomLeftCard.title.is().text(is(titleText));
        cardColumns.topLeftCard.mainText.is().text(is(mainText));
        cardColumns.bottomLeftCard.mutedText.is().displayed()
                .and().text(is(mutedText))
                .core()
                .css("font-size", is("11.2px"))
                .tag(is("small"));
        cardColumns.bottomLeftCard.image.is().displayed()
                .and().src(is(imageSrc))
                .core()
                .attr("alt", imageAlt);
        cardColumns.bottomLeftCard.image.assertThat().width(is(130));
        cardColumns.bottomLeftCard.image.assertThat().height(is(160));
    }
}
