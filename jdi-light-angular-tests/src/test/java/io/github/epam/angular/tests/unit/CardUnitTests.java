package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.cardSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class CardUnitTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void cardButtonsClickByBtnTextTest() {
        cardSection.card.getButtonByText("LIKE").click();
        cardSection.card.getButtonByText("LIKE").has().cssClass("cdk-focused");
        cardSection.card.getButtonByText("LIKE").has().cssClass("cdk-mouse-focused");
        cardSection.card.getButtonByText("SHARE").click();
        cardSection.card.getButtonByText("SHARE").has().cssClass("cdk-focused");
        cardSection.card.getButtonByText("SHARE").has().cssClass("cdk-mouse-focused");
    }

    @Test
    public void cardButtonsClickByBtnNumberTest() {
        cardSection.card.getButtonByNumber(1).click();
        cardSection.card.getButtonByNumber(1).has().cssClass("cdk-focused");
        cardSection.card.getButtonByNumber(1).has().cssClass("cdk-mouse-focused");
        cardSection.card.getButtonByNumber(2).click();
        cardSection.card.getButtonByNumber(2).has().cssClass("cdk-focused");
        cardSection.card.getButtonByNumber(2).has().cssClass("cdk-mouse-focused");
    }
}
