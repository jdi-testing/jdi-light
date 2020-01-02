package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithCustomCss13Rem;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Aleksandr Khmelinin on 22.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardWithCustomCss13RemTests extends TestsInit {

    private String title = "SPIDER MAN (13REM)";
    private String text = "Spider-Man is a fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko.";
    private String buttonText = "Read more";
    private String link = "https://en.wikipedia.org/wiki/Spider-Man";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTextTest() {
        assertEquals(cardWithCustomCss13Rem.title.getText(), title);
    }

    @Test
    public void getTextTest() {
        assertEquals(cardWithCustomCss13Rem.text.getText(), text);
    }

    @Test
    public void clickTest() {
        cardWithCustomCss13Rem.button.click();
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl(), link);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValidationTest() {
        cardWithCustomCss13Rem.title.is().text(is(title));
        cardWithCustomCss13Rem.text.is().text(is(text));
        cardWithCustomCss13Rem.button.is().displayed()
                .and().text(is(buttonText))
                .core()
                .css("font-size", is("16px"))
                .cssClass("btn btn-primary")
                .tag(is("a"))
                .attr("href", link);
        cardWithCustomCss13Rem.button.is().enabled();
        cardWithCustomCss13Rem.is().displayed()
                .core()
                .css("width", is("208px"))
                .css("margin-bottom", is("10px"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardWithCustomCss13Rem.title);
        baseValidation(cardWithCustomCss13Rem.text);
        baseValidation(cardWithCustomCss13Rem.button);
    }
}
