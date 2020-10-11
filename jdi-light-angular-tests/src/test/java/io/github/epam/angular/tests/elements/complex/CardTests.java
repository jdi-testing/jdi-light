package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.CardSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class CardTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedBasicCardTest() {
        simpleCard.is().displayed();
        card.is().displayed();
    }

    @Test
    public void attributeCardTest() {
        simpleCard.is().assertCardText("Simple card");
        card.is().assertAltImageAttribute("Photo of a Shiba Inu");
        card.is().assertSrcImageAttribute("https://material.angular.io/assets/img/examples/shiba2.jpg");
    }

    @Test
    public void displayedCardTest() {
        card.getHeader().is().displayed();
        card.getHeaderText().is().displayed();
        card.getAvatar().is().displayed();
        card.getTitle().is().displayed();
        card.getTitle().is().text("Shiba Inu");
        card.getSubtitle().is().displayed();
        card.getSubtitle().is().text("Dog Breed");
        card.getImage().is().displayed();
        card.getContent().is().displayed();
        card.getContent().is().displayed();
    }

    @Test
    public void cardButtonsTest() {
        card.is().assertNumberOfButtonsOnCard(2);
        card.getButtonByNumber(1).is().text("LIKE");
        card.getButtonByNumber(2).is().text("SHARE");
    }

    @Test
    public void cardButtonsClickTest() {
        card.getButtonByText("LIKE").click();
        card.getButtonByText("LIKE").has().cssClass("cdk-focused");
    }
}
