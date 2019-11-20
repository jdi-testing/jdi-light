package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.com.sections.card.CardStyled;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardStyledDanger;
import static io.github.com.pages.BootstrapPage.cardStyledDark;
import static io.github.com.pages.BootstrapPage.cardStyledInfo;
import static io.github.com.pages.BootstrapPage.cardStyledLight;
import static io.github.com.pages.BootstrapPage.cardStyledPrimary;
import static io.github.com.pages.BootstrapPage.cardStyledSecondary;
import static io.github.com.pages.BootstrapPage.cardStyledSuccess;
import static io.github.com.pages.BootstrapPage.cardStyledWarning;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 30.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardBorderTests extends TestsInit {

    private static String bodyText = "Some quick example text to build on the card title and make up the bulk of the card's content.";

    @DataProvider
    public static Object[][] cardBorderHeaderText() {
        return new Object[][]{
                {cardStyledPrimary, "Card with primary border"},
                {cardStyledSecondary, "Card with secondary border"},
                {cardStyledSuccess, "Card with success border"},
                {cardStyledDanger, "Card with danger border"},
                {cardStyledWarning, "Card with warning border"},
                {cardStyledInfo, "Card with info border"},
                {cardStyledLight, "Card with light border"},
                {cardStyledDark, "Card with dark border"},
        };
    }

    @DataProvider
    public static Object[][] cardBorderTitleText() {
        return new Object[][]{
                {cardStyledPrimary, "PRIMARY CARD TITLE"},
                {cardStyledSecondary, "SECONDARY CARD TITLE"},
                {cardStyledSuccess, "SUCCESS CARD TITLE"},
                {cardStyledDanger, "DANGER CARD TITLE"},
                {cardStyledWarning, "WARNING CARD TITLE"},
                {cardStyledInfo, "INFO CARD TITLE"},
                {cardStyledLight, "LIGHT CARD TITLE"},
                {cardStyledDark, "DARK CARD TITLE"},
        };
    }

    @DataProvider
    public static Object[][] cardBorderBodyText() {
        return new Object[][]{
                {cardStyledPrimary, bodyText},
                {cardStyledSecondary, bodyText},
                {cardStyledSuccess, bodyText},
                {cardStyledDanger, bodyText},
                {cardStyledWarning, bodyText},
                {cardStyledInfo, bodyText},
                {cardStyledLight, bodyText},
                {cardStyledDark, bodyText},
        };
    }

    @DataProvider
    public static Object[][] cardBorderColor() {
        return new Object[][]{
                {cardStyledPrimary, "rgba(0, 123, 255, 1)"},
                {cardStyledSecondary, "rgba(108, 117, 125, 1)"},
                {cardStyledSuccess, "rgba(40, 167, 69, 1)"},
                {cardStyledDanger, "rgba(220, 53, 69, 1)"},
                {cardStyledWarning, "rgba(255, 193, 7, 1)"},
                {cardStyledInfo, "rgba(23, 162, 184, 1)"},
                {cardStyledLight, "rgba(248, 249, 250, 1)"},
                {cardStyledDark, "rgba(52, 58, 64, 1)"},
        };
    }

    @DataProvider
    public static Object[][] cardBorder() {
        return new Object[][]{
                {cardStyledPrimary},
                {cardStyledSecondary},
                {cardStyledSuccess},
                {cardStyledDanger},
                {cardStyledWarning},
                {cardStyledInfo},
                {cardStyledLight},
                {cardStyledDark},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "cardBorderHeaderText")
    public void getHeaderTextTest(CardStyled cardStyled, String headerText) {
        cardStyled.header.is().text(headerText);
    }

    @Test(dataProvider = "cardBorderTitleText")
    public void getTitleTextTest(CardStyled cardStyled, String titleText) {
        cardStyled.title.is().text(titleText);
    }

    @Test(dataProvider = "cardBorderBodyText")
    public void getBodyTextTest(CardStyled cardStyled, String bodyText) {
        cardStyled.body.is().text(bodyText);
    }

    @Test(dataProvider = "cardBorderColor")
    public void getBorderColorTest(CardStyled cardStyled, String color) {
        cardStyled.is().core().css("border-bottom-color", is(color));
        cardStyled.is().core().css("border-left-color", is(color));
        cardStyled.is().core().css("border-right-color", is(color));
        cardStyled.is().core().css("border-top-color", is(color));
    }

    @Test(dataProvider = "cardBorder")
    public void baseValidationTest(CardStyled cardStyled) {
        baseValidation(cardStyled.header);
        baseValidation(cardStyled.title);
        baseValidation(cardStyled.body);
    }
}
