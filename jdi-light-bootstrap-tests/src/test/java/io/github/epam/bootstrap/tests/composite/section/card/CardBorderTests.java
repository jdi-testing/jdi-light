package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.com.sections.CardBorder;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.assertEquals;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 30.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardBorderTests extends TestsInit {

    private static String[] headerText = new String[] {"Card with primary border", "Card with secondary border",
            "Card with success border", "Card with danger border", "Card with warning border", "Card with info border", "Card with light border",
            "Card with dark border"};

    private static String[] titleText = new String[] {"PRIMARY CARD TITLE", "SECONDARY CARD TITLE",
            "SUCCESS CARD TITLE", "DANGER CARD TITLE", "WARNING CARD TITLE", "INFO CARD TITLE", "LIGHT CARD TITLE",
            "DARK CARD TITLE"};

    private static String bodyText = "Some quick example text to build on the card title and make up the bulk of the card's content.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public static Object[][] cardBorderHeaderText() {
        return new Object[][]{
                {cardBorderPrimary, headerText[0]},
                {cardBorderSecondary, headerText[1]},
                {cardBorderSuccess, headerText[2]},
                {cardBorderDanger, headerText[3]},
                {cardBorderWarning, headerText[4]},
                {cardBorderInfo, headerText[5]},
                {cardBorderLight, headerText[6]},
                {cardBorderDark, headerText[7]},
        };
    }

    @Test(dataProvider = "cardBorderHeaderText")
    public void getHeaderTextTest(CardBorder cardBorder, String headerText) {
        assertEquals(cardBorder.border.getText(), headerText);
    }

    @DataProvider
    public static Object[][] cardBorderTitleText() {
        return new Object[][]{
                {cardBorderPrimary, titleText[0]},
                {cardBorderSecondary, titleText[1]},
                {cardBorderSuccess, titleText[2]},
                {cardBorderDanger, titleText[3]},
                {cardBorderWarning, titleText[4]},
                {cardBorderInfo, titleText[5]},
                {cardBorderLight, titleText[6]},
                {cardBorderDark, titleText[7]},
        };
    }

    @Test(dataProvider = "cardBorderTitleText")
    public void getTitleTextTest(CardBorder cardBorder, String titleText) {
        assertEquals(cardBorder.title.getText(), titleText);
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
        assertEquals(cardBorder.body.getText(), bodyText);
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
                {cardBorderPrimary}, {cardBorderSecondary}, {cardBorderSuccess}, {cardBorderDanger}, {cardBorderWarning},
                {cardBorderInfo}, {cardBorderLight}, {cardBorderDark},
        };
    }

    @Test(dataProvider = "cardBorder")
    public void baseValidationTest(CardBorder cardBorder) {
        baseValidation(cardBorder.border);
        baseValidation(cardBorder.title);
        baseValidation(cardBorder.body);
    }
}
