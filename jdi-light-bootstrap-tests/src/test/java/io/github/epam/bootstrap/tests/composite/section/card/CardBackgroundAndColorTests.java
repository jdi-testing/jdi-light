package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.com.sections.card.CardWithHeaderAndFooter;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardBlue;
import static io.github.com.pages.BootstrapPage.cardBrightBlue;
import static io.github.com.pages.BootstrapPage.cardDark;
import static io.github.com.pages.BootstrapPage.cardGreen;
import static io.github.com.pages.BootstrapPage.cardGrey;
import static io.github.com.pages.BootstrapPage.cardLight;
import static io.github.com.pages.BootstrapPage.cardRed;
import static io.github.com.pages.BootstrapPage.cardYellow;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Litvin Yulia on 27.09.2019
 * Email: yulia_litvin@epam.com
 */

public class CardBackgroundAndColorTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider(name = "cardColors")
    public static Object[][] cardColors() {
        return new Object[][]{
                {cardBrightBlue, "bg-primary", "rgba(0, 123, 255, 1)"},
                {cardGrey, "bg-secondary", "rgba(108, 117, 125, 1)"},
                {cardGreen, "bg-success", "rgba(40, 167, 69, 1)"},
                {cardRed, "bg-danger", "rgba(220, 53, 69, 1)"},
                {cardYellow, "bg-warning", "rgba(255, 193, 7, 1)"},
                {cardBlue, "bg-info", "rgba(23, 162, 184, 1)"},
                {cardLight, "bg-light", "rgba(248, 249, 250, 1)"},
                {cardDark, "bg-dark", "rgba(52, 58, 64, 1)"},
        };
    }

    @Test(dataProvider = "cardColors")
    public void checkColorCardsTest(CardWithHeaderAndFooter card, String cssClass, String color) {
        card.is()
                .core()
                .hasClass(cssClass)
                .css("background-color", is(color));

        card.header.is()
                .displayed().and()
                .core().css("background-color", is("rgba(0, 0, 0, 0.03)"));

        card.paragraph.is()
                .displayed().and()
                .core().css("background-color", is("rgba(0, 0, 0, 0)"));

    }


}
