package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardWithCustomCss9Rem;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class CardWithCustomCss9RemTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String title = "HULK\n(9REM)";
    private String text = "The Hulk is a fictional superhero appearing in publications by the American publisher Marvel Comics.";
    private String buttonText = "Read more";
    private String link = "https://en.wikipedia.org/wiki/Hulk_(film)";

    @Test
    public void getTitleTextTest() {
        assertEquals(cardWithCustomCss9Rem.title.getText(), title);
    }

    @Test
    public void getTextTest() {
        assertEquals(cardWithCustomCss9Rem.text.getText(), text);
    }

    @Test
    public void clickTest() {
        cardWithCustomCss9Rem.button.click();
        ArrayList<String> tabs = new ArrayList<>(WebDriverFactory.getDriver().getWindowHandles());
        WebDriver driver = WebDriverFactory.getDriver();
        driver.switchTo().window(tabs.get(1));
        assertEquals(getUrl(), link);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void isValidationTest() {
        cardWithCustomCss9Rem.title.is().text(is(title));
        cardWithCustomCss9Rem.text.is().text(is(text));
        cardWithCustomCss9Rem.button.is().displayed()
                .and().text(is(buttonText))
                .core()
                .css("font-size", is("16px"))
                .cssClass("btn btn-primary")
                .tag(is("a"))
                .attr("href", link);
        cardWithCustomCss9Rem.button.is().enabled();
        cardWithCustomCss9Rem.is().displayed()
                .core()
                .css("width", is("144px"))
                .css("margin-bottom", is("10px"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardWithCustomCss9Rem.title);
        baseValidation(cardWithCustomCss9Rem.text);
        baseValidation(cardWithCustomCss9Rem.button);
    }
}
