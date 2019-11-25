package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.com.sections.card.CardUtilities;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWidth50;
import static io.github.com.pages.BootstrapPage.cardWidth75;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Mariia Tikhonova on 11.10.2019
 * Email: mariia_tikhonova@epam.com, Skype: mariatikhonova5_2
 */

public class CardUtilitiesTests extends TestsInit {

    private String whiteColor = "rgba(255, 255, 255, 1)";
    private String buttonBorderColor = "rgb(0, 123, 255)";
    private String buttonBackgroundColor = "rgba(0, 123, 255, 1)";

    @DataProvider(name = "cardUtilitiesElements")
    public static Object[][] cardUtilitiesElements() {
        return new Object[][]{
                {cardWidth75},
                {cardWidth50}
        };
    }

    @DataProvider(name = "cardUtilitiesElementsWithWidth")
    public static Object[][] cardUtilitiesElementsWithWidth() {
        return new Object[][]{
                {cardWidth75, 75, "212.4px"},
                {cardWidth50, 50, "141.6px"}
        };
    }

    @DataProvider(name = "cardUtilitiesElementsWithTitle")
    public static Object[][] cardUtilitiesElementsWithTitle() {
        return new Object[][]{
                {cardWidth75, "SPIDER MAN (W-75)"},
                {cardWidth50, "HULK (W-50)"}
        };
    }

    @DataProvider(name = "cardUtilitiesElementsWithText")
    public static Object[][] cardUtilitiesElementsWithText() {
        return new Object[][]{
                {cardWidth75, "Spider-Man is a fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko."},
                {cardWidth50, "The Hulk is a fictional superhero appearing in publications by the American publisher Marvel Comics."}
        };
    }

    @DataProvider(name = "cardUtilitiesElementsWithLinks")
    public static Object[][] cardUtilitiesElementsWithLinks() {
        return new Object[][]{
                {cardWidth75, "https://en.wikipedia.org/wiki/Spider-Man"},
                {cardWidth50, "https://en.wikipedia.org/wiki/Hulk_(film)"}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "cardUtilitiesElements")
    public void baseValidationTest(CardUtilities cardUtilitiesElem) {
        baseValidation(cardUtilitiesElem);
        cardUtilitiesElem.unhighlight();
    }

    @Test(dataProvider = "cardUtilitiesElementsWithWidth")
    public void cardValidationTest(CardUtilities cardUtilitiesElem, int widthInPercent, String widthInPixels) {
        cardUtilitiesElem.core().is()
                .hasClass(String.format("card w-%d", widthInPercent))
                .css("width", widthInPixels)
                .css("background-color", whiteColor);
    }

    @Test(dataProvider = "cardUtilitiesElementsWithTitle")
    public void titleValidationTest(CardUtilities cardUtilitiesElem, String title) {
        cardUtilitiesElem.cardTitle.core().is()
                .tag("h5")
                .text(title)
                .css("margin-bottom", "12px");
    }

    @Test(dataProvider = "cardUtilitiesElementsWithText")
    public void textValidationTest(CardUtilities cardUtilitiesElem, String text) {
        cardUtilitiesElem.cardText.core().is()
                .tag("p")
                .text(text);
    }

    @Test(dataProvider = "cardUtilitiesElementsWithLinks")
    public void buttonValidationTest(CardUtilities cardUtilitiesElem, String link) {
        cardUtilitiesElem.cardButton.core().is()
                .text("Read more")
                .css("color", whiteColor)
                .css("background-color", buttonBackgroundColor)
                .css("border-color", buttonBorderColor);
        cardUtilitiesElem.cardButton.click();
        WindowsManager.switchToWindow(2);
        assertEquals(getUrl(), link);
        WindowsManager.closeWindow();
    }
}
