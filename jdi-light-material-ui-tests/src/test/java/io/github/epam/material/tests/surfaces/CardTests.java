package io.github.epam.material.tests.surfaces;

import static io.github.com.StaticSite.cardPage;
import static io.github.com.StaticSite.surfaceCardPage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class CardTests extends TestsInit {

    private final String EXPECTED_CARD_TITLE = "Card Header";
    private final String EXPECTED_CARD_SUB_HEADER = "Sub-header";
    private final String EXPECTED_CARD_CONTENT = "Sample card";

    @Test
    public void defaultPaperTest() {
        surfaceCardPage.open();
        cardPage.card.getCardButtons().get(1).is().enabled();
        cardPage.card.getCardHeaders().get(1).is().text(EXPECTED_CARD_TITLE);
        cardPage.card.getCardHeaders().get(2).is().text(EXPECTED_CARD_SUB_HEADER);
        cardPage.card.is().backgroundImageDisplayed();
        cardPage.card.is().backgroundClickable();
        cardPage.card.clickOnBackground();
        cardPage.card.getInnerCardContent().get(1).is().text(EXPECTED_CARD_CONTENT);
    }
}
