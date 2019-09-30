package io.github.epam.bootstrap.tests.composite.section.spinner;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.growingSpinner;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertNotEquals;

public class GrowingSpinnerTests extends TestsInit {

    private static final String spinnerGrowClass = "spinner-grow";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void spinnerGrowTest() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);

        growingSpinner.primarySpinner.highlight();

        double firstSnapshot = WebDriverFactory.jsExecute(
                "var x = document.getElementsByClassName('spinner-grow')[0].children;" +
                      "var y = x[0];" +
                      "return y.getBoundingClientRect().width;"
        );

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("body")));

        double secondSnapshot = WebDriverFactory.jsExecute(
                "var x = document.getElementsByClassName('spinner-grow')[0].children;" +
                        "var y = x[0];" +
                        "return y.getBoundingClientRect().width;"
        );

        assertNotEquals(firstSnapshot, secondSnapshot);
    }

    @Test
    public void spinnerGrowClassTest() {
        growingSpinner.primarySpinner.is().core().hasClass(spinnerGrowClass);
    }

}
