package io.github.epam.bootstrap.tests.composite.section.spinner;

import io.github.com.sections.spinner.Spinner;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.spinnerSize;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class SpinnerSizeTests extends TestsInit {

    private static final String smallSpinnerClass = "spinner-border-sm";
    private static final String smallGrowingSpinnerClass = "spinner-grow-sm";
    private static final String spinnerStyleValue = "width: 3rem; height: 3rem; border: 3px dashed red;";

    @DataProvider
    public Object[][] spinnerData() {
        return new Object[][] {
                {spinnerSize.smallSpinner},
                {spinnerSize.smallGrowingSpinner},
                {spinnerSize.spinner},
                {spinnerSize.growingSpinner}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "spinnerData")
    public void isValidationTest(Spinner spinner) {
        spinner.highlight();
        spinner
                .is()
                .enabled()
                .and()
                .displayed();
    }

    @Test
    public void spinnerClassTest() {
        spinnerSize.smallSpinner.is().core().hasClass(smallSpinnerClass);
        spinnerSize.smallGrowingSpinner.is().core().hasClass(smallGrowingSpinnerClass);
    }

    @Test
    public void spinnerStylingTest() {
        spinnerSize.spinner.is().core().attr("style", spinnerStyleValue);
        spinnerSize.growingSpinner.is().core().attr("style", spinnerStyleValue);
    }

}
