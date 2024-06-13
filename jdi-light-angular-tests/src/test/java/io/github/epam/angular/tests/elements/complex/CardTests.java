package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.CardImageSize.EXTRALARGE;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.LARGE;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.MEDIUM;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.SMALL;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.cardPage;
import static io.github.com.pages.CardPage.card;
import static io.github.com.pages.CardPage.cardAlignEndActions;
import static io.github.com.pages.CardPage.cardAlignStartActions;
import static io.github.com.pages.CardPage.cardWithExtraLargeImage;
import static io.github.com.pages.CardPage.cardWithFooter;
import static io.github.com.pages.CardPage.cardWithLargeImage;
import static io.github.com.pages.CardPage.cardWithMediumImage;
import static io.github.com.pages.CardPage.cardWithSmallImage;
import static io.github.com.pages.CardPage.simpleCard;


public class CardTests extends TestsInit {

    private static final String IMAGE_SRC = "https://material.angular.io/assets/img/examples/shiba2.jpg";

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

//    @Test(description = "Test verifies card text and image")
//    public void attributeCardTest() {
//        card.has().altImageAttribute("Photo of a Shiba Inu");
//        card.has().srcImageAttribute(IMAGE_SRC);
//
//        cardWithSmallImage.has().headerImageWithSrcAttribute(IMAGE_SRC);
//        cardWithMediumImage.has().headerImageWithSrcAttribute(IMAGE_SRC);
//        cardWithLargeImage.has().headerImageWithSrcAttribute(IMAGE_SRC);
//        cardWithExtraLargeImage.has().headerImageWithSrcAttribute(IMAGE_SRC);
//    }

//    @Test(description = "Test verifies that elements of the card are displayed")
//    public void displayedCardTest() {
//        card.show();
//        card.header().is().displayed();
//        card.avatar().is().displayed();
//        card.title().is().displayed();
//        card.title().is().text("Shiba Inu");
//        card.subtitle().is().displayed();
//        card.subtitle().has().text("Dog Breed");
//        card.bodyImage().is().displayed();
//        card.content().is().displayed();
//        card.actions().is().displayed();
//        cardWithFooter.show();
//        cardWithFooter.footer().is().displayed();
//        cardWithFooter.actions().is().displayed();
//    }

//    @Test(description = "Test verifies number and text of card buttons")
//    public void cardButtonsTest() {
//        card.show();
//        card.has().numberOfButtonsOnCard(2);
//        card.buttonByNumber(1).has().text("LIKE");
//        card.buttonByNumber(2).has().text("SHARE");
//    }

//    @Test(description = "Test verifies that after click button becomes focused")
//    public void cardButtonsClickTest() {
//        card.buttonByText("LIKE").click();
//        card.buttonByText("LIKE").has().cssClass("cdk-focused");
//    }

//    @Test(description = "Test verifies that align end and start actions position")
//    public void alignPositionTest() {
//        cardAlignEndActions.show();
//        cardAlignEndActions.actions().is().displayed();
//        cardAlignEndActions.has().alignEndActions();
//        cardAlignStartActions.show();
//        cardAlignStartActions.actions().is().displayed();
//        cardAlignStartActions.has().alignStartActions();
//    }

//    @Test(description = "Test verifies image size of the card")
//    public void sizeOfCardImageTest() {
//        card.has().imageSize(320, 400);
//
//        cardWithSmallImage.has().headerImageSize(SMALL);
//        cardWithSmallImage.has().headerImageSize(80, 80);
//
//        cardWithMediumImage.has().headerImageSize(MEDIUM);
//        cardWithMediumImage.has().headerImageSize(112, 112);
//
//        cardWithLargeImage.has().headerImageSize(LARGE);
//        cardWithLargeImage.has().headerImageSize(152, 152);
//
//        cardWithExtraLargeImage.has().headerImageSize(EXTRALARGE);
//        cardWithExtraLargeImage.has().headerImageSize(240, 240);
//    }
}