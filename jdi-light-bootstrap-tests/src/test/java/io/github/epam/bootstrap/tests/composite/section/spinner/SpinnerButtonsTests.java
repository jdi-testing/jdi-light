package io.github.epam.bootstrap.tests.composite.section.spinner;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ButtonWithSpinner;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonWithGrowingSpinner;
import static io.github.com.pages.BootstrapPage.buttonWithGrowingSpinnerAndText;
import static io.github.com.pages.BootstrapPage.buttonWithSpinner;
import static io.github.com.pages.BootstrapPage.buttonWithSpinnerAndText;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertNotEquals;

public class SpinnerButtonsTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private final String buttonText = "Loading...";
    private final String spinnerClass = "spinner-border";

    @DataProvider
    public Object[][] buttonsWithGrowingSpinners() {
        return new Object[][]{
                {buttonWithGrowingSpinner},
                {buttonWithGrowingSpinnerAndText},
        };
    }

    @Test()
    public void checkButtonText() {
        buttonWithSpinnerAndText.isDisplayed();
        buttonWithSpinnerAndText.assertThat().text(is(buttonText));
    }

    @Test()
    public void checkSpinnerInButtonWithText() {
        buttonWithSpinnerAndText.spinner.is().core().hasClass(spinnerClass);
        buttonWithSpinnerAndText.spinner
                .is()
                .displayed()
                .and()
                .enabled();
    }

    @Test()
    public void checkButtonWithoutText() {
        buttonWithSpinner.span.isHidden();
        buttonWithSpinnerAndText.assertThat().text(is(buttonText));
    }

    @Test()
    public void checkButtonTextWithGrowingSpinner() {
        buttonWithGrowingSpinnerAndText.assertThat().text(is(buttonText));
    }


    @Test(dataProvider = "buttonsWithGrowingSpinners")
    public void spinnerGrowTest(ButtonWithSpinner buttonWithSpinner) {
        for (int i = 0; i < 7; i++) {
            buttonWithSpinner.spinner.highlight();

            double firstSnapshot = WebDriverFactory.jsExecute(
                    "var x = document.getElementsByClassName('spinner-grow')[" + i + "].children;" +
                            "var y = x[0];" +
                            "return y.getBoundingClientRect().width;"
            );

            $("body").waitFor().displayed();

            double secondSnapshot = WebDriverFactory.jsExecute(
                    "var x = document.getElementsByClassName('spinner-grow')[" + i + "].children;" +
                            "var y = x[0];" +
                            "return y.getBoundingClientRect().width;"
            );

            assertNotEquals(firstSnapshot, secondSnapshot);
        }
    }


}




