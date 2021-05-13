package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.CardSection.card;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class CardUnitTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void cardButtonsClickByBtnTextTest() {
        card.getButtonByText("LIKE").click();
        card.getButtonByText("LIKE").has().cssClass("cdk-focused");
        card.getButtonByText("LIKE").has().cssClass("cdk-mouse-focused");
        card.getButtonByText("SHARE").click();
        card.getButtonByText("SHARE").has().cssClass("cdk-focused");
        card.getButtonByText("SHARE").has().cssClass("cdk-mouse-focused");
    }

    @Test
    public void cardButtonsClickByBtnNumberTest() {
        card.getButtonByNumber(1).click();
        card.getButtonByNumber(1).has().cssClass("cdk-focused");
        card.getButtonByNumber(1).has().cssClass("cdk-mouse-focused");
        card.getButtonByNumber(2).click();
        card.getButtonByNumber(2).has().cssClass("cdk-focused");
        card.getButtonByNumber(2).has().cssClass("cdk-mouse-focused");
    }
}
