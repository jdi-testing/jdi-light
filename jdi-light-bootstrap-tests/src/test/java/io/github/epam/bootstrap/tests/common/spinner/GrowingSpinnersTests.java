package io.github.epam.bootstrap.tests.common.spinner;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.growingSpinners;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertNotEquals;

public class GrowingSpinnersTests extends TestsInit {

    private static final String spinnerGrowClass = "spinner-grow";

    @DataProvider
    public Object[][] spinnerData() {
        return new Object[][] {
                {growingSpinners.primarySpinner},
                {growingSpinners.secondarySpinner},
                {growingSpinners.successSpinner},
                {growingSpinners.dangerSpinner},
                {growingSpinners.warningSpinner},
                {growingSpinners.infoSpinner},
                {growingSpinners.lightSpinner},
                {growingSpinners.darkSpinner}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "spinnerData")
    public void spinnerGrowTest(Spinner spinner) {

        for (int i = 0; i < 7; i++) {
            spinner.highlight();

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

    @Test(dataProvider = "spinnerData")
    public void spinnerHasGrowClassTest(Spinner spinner) {
        spinner.highlight();
        spinner.is().core().hasClass(spinnerGrowClass);
    }

    @Test(dataProvider = "spinnerData")
    public void isValidationTest(Spinner spinner) {
        spinner.highlight();
        spinner
                .is()
                .displayed()
                .and()
                .enabled();
    }

}
