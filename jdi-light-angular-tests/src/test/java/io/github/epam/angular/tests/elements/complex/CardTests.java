package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.cardSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class CardTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedBasicCardTest() {
        cardSection.simpleCard.is().displayed();
        cardSection.card.is().displayed();
    }

    @Test
    public void attributeCardTest() {
        cardSection.simpleCard.is().assertCardText("Simple card");
        cardSection.card.is().assertAltImageAttribute("Photo of a Shiba Inu");
        cardSection.card.is().assertSrcImageAttribute("https://material.angular.io/assets/img/examples/shiba2.jpg");
    }

    @Test
    public void displayedCardTest() {
        cardSection.card.getHeader().is().displayed();
        cardSection.card.getHeaderText().is().displayed();
        cardSection.card.getAvatar().is().displayed();
        cardSection.card.getTitle().is().displayed();
        cardSection.card.getTitle().is().text("Shiba Inu");
        cardSection.card.getSubtitle().is().displayed();
        cardSection.card.getSubtitle().is().text("Dog Breed");
        cardSection.card.getImage().is().displayed();
        cardSection.card.getContent().is().displayed();
        cardSection.card.getContent().is().displayed();
    }

    @Test
    public void cardButtonsTest() {
        cardSection.card.is().assertNumberOfButtonsOnCard(2);
        cardSection.card.getButtonByNumber(1).is().text("LIKE");
        cardSection.card.getButtonByNumber(2).is().text("SHARE");
    }

    @Test
    public void cardButtonsClickTest() {
        cardSection.card.getButtonByText("LIKE").click();
        cardSection.card.getButtonByText("LIKE").has().cssClass("cdk-focused");
    }
}
