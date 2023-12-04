package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.angular.elements.enums.CardImageSize;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.cardPage;
import static io.github.com.pages.CardPage.card;
import static io.github.com.pages.CardPage.cardAlignEndActions;
import static io.github.com.pages.CardPage.cardAlignStartActions;
import static io.github.com.pages.CardPage.cardWithExtraLargeImageSize;
import static io.github.com.pages.CardPage.cardWithFooter;
import static io.github.com.pages.CardPage.cardWithLargeImageSize;
import static io.github.com.pages.CardPage.cardWithMediumImageSize;
import static io.github.com.pages.CardPage.cardWithSmallImageSize;
import static io.github.com.pages.CardPage.simpleCard;


public class CardTests extends TestsInit {
    @BeforeClass
    public void before() {
        cardPage.open();
        waitCondition(() -> cardPage.isOpened());
        cardPage.checkOpened();
    }

    @Test(description = "Test verifies that card is displayed")
    public void displayedBasicCardTest() {
        simpleCard.is().displayed();
        card.is().displayed();
    }

    @Test(description = "Test verifies card text and image")
    public void attributeCardTest() {
        simpleCard.has().cardText("Simple card");
        card.has().altImageAttribute("Photo of a Shiba Inu");
        card.has().srcImageAttribute("https://material.angular.io/assets/img/examples/shiba2.jpg");
    }

    @Test(description = "Test verifies that elements of the card are displayed")
    public void displayedCardTest() {
        card.show();
        card.getHeader().is().displayed();
        card.getAvatar().is().displayed();
        card.getTitle().is().displayed();
        card.getTitle().is().text("Shiba Inu");
        card.getSubtitle().is().displayed();
        card.getSubtitle().is().text("Dog Breed");
        card.image().is().displayed();
        card.getContent().is().displayed();
        cardWithFooter.show();
        cardWithFooter.getFooter().is().displayed();
    }

    @Test(description = "Test verifies number and text of card buttons")
    public void cardButtonsTest() {
        card.show();
        card.has().numberOfButtonsOnCard(2);
        card.getButtonByNumber(1).is().text("LIKE");
        card.getButtonByNumber(2).is().text("SHARE");
    }

    @Test(description = "Test verifies that after click button becomes focused")
    public void cardButtonsClickTest() {
        card.getButtonByText("LIKE").click();
        card.getButtonByText("LIKE").has().cssClass("cdk-focused");
    }

    @Test(description = "Test verifies that align end and start actions position")
    public void alignPositionTest() {
        cardAlignEndActions.show();
        cardAlignEndActions.has().alignEndActions();
        cardAlignStartActions.show();
        cardAlignStartActions.has().alignStartActions();
    }

    @Test(description = "Test verifies image size of the card")
    public void sizeOfCardImageTest() {
        cardWithSmallImageSize.has().imageSize(CardImageSize.SMALL);
        cardWithMediumImageSize.has().imageSize(CardImageSize.MEDIUM);
        cardWithLargeImageSize.has().imageSize(CardImageSize.LARGE);
        cardWithExtraLargeImageSize.has().imageSize(CardImageSize.EXTRALARGE);
    }

}
