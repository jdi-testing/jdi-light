package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.com.sections.card.CardBorder;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardBorderDark;
import static io.github.com.pages.BootstrapPage.cardBorderLight;
import static io.github.com.pages.BootstrapPage.cardBorderPrimary;
import static io.github.com.pages.BootstrapPage.cardBorderSecondary;
import static io.github.com.pages.BootstrapPage.cardBorderSuccess;
import static io.github.com.pages.BootstrapPage.cardBorderWarning;
import static io.github.com.pages.BootstrapPage.cardBorderInfo;
import static io.github.com.pages.BootstrapPage.cardBorderDanger;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 30.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardBorderTests extends TestsInit {

    private static String bodyText = "Some quick example text to build on the card title and make up the bulk of the card's content.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] cardBorderHeaderText() {
        return new Object[][]{
                {cardBorderPrimary, "Card with primary border"},
                {cardBorderSecondary, "Card with secondary border"},
                {cardBorderSuccess, "Card with success border"},
                {cardBorderDanger, "Card with danger border"},
                {cardBorderWarning, "Card with warning border"},
                {cardBorderInfo, "Card with info border"},
                {cardBorderLight, "Card with light border"},
                {cardBorderDark, "Card with dark border"},
        };
    }

    @Test(dataProvider = "cardBorderHeaderText")
    public void getHeaderTextTest(CardBorder cardBorder, String headerText) {
        cardBorder.border.is().text(headerText);
    }

    @DataProvider
    public static Object[][] cardBorderTitleText() {
        return new Object[][]{
                {cardBorderPrimary, "PRIMARY CARD TITLE"},
                {cardBorderSecondary, "SECONDARY CARD TITLE"},
                {cardBorderSuccess, "SUCCESS CARD TITLE"},
                {cardBorderDanger, "DANGER CARD TITLE"},
                {cardBorderWarning, "WARNING CARD TITLE"},
                {cardBorderInfo, "INFO CARD TITLE"},
                {cardBorderLight, "LIGHT CARD TITLE"},
                {cardBorderDark, "DARK CARD TITLE"},
        };
    }

    @Test(dataProvider = "cardBorderTitleText")
    public void getTitleTextTest(CardBorder cardBorder, String titleText) {
        cardBorder.title.is().text(titleText);
    }

    @DataProvider
    public static Object[][] cardBorderBodyText() {
        return new Object[][]{
                {cardBorderPrimary, bodyText},
                {cardBorderSecondary, bodyText},
                {cardBorderSuccess, bodyText},
                {cardBorderDanger, bodyText},
                {cardBorderWarning, bodyText},
                {cardBorderInfo, bodyText},
                {cardBorderLight, bodyText},
                {cardBorderDark, bodyText},
        };
    }

    @Test(dataProvider = "cardBorderBodyText")
    public void getBodyTextTest(CardBorder cardBorder, String bodyText) {
        cardBorder.body.is().text(bodyText);
    }

    @DataProvider
    public static Object[][] cardBorderColor() {
        return new Object[][]{
                {cardBorderPrimary, "rgba(0, 123, 255, 1)"},
                {cardBorderSecondary, "rgba(108, 117, 125, 1)"},
                {cardBorderSuccess, "rgba(40, 167, 69, 1)"},
                {cardBorderDanger, "rgba(220, 53, 69, 1)"},
                {cardBorderWarning, "rgba(255, 193, 7, 1)"},
                {cardBorderInfo, "rgba(23, 162, 184, 1)"},
                {cardBorderLight, "rgba(248, 249, 250, 1)"},
                {cardBorderDark, "rgba(52, 58, 64, 1)"},
        };
    }

    @Test(dataProvider = "cardBorderColor")
    public void getBorderColorTest(CardBorder cardBorder, String color) {
        cardBorder.is().core().css("border-bottom-color", is(color));
        cardBorder.is().core().css("border-left-color", is(color));
        cardBorder.is().core().css("border-right-color", is(color));
        cardBorder.is().core().css("border-top-color", is(color));
    }

    @DataProvider
    public static Object[][] cardBorder() {
        return new Object[][]{
                {cardBorderPrimary},
                {cardBorderSecondary},
                {cardBorderSuccess},
                {cardBorderDanger},
                {cardBorderWarning},
                {cardBorderInfo},
                {cardBorderLight},
                {cardBorderDark},
        };
    }

    @Test(dataProvider = "cardBorder")
    public void baseValidationTest(CardBorder cardBorder) {
        baseValidation(cardBorder.border);
        baseValidation(cardBorder.title);
        baseValidation(cardBorder.body);
    }
}
