package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.ui.bootstrap.elements.common.ColorSpinner;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.spinnerWithTextDanger;
import static io.github.com.pages.BootstrapPage.spinnerWithTextDark;
import static io.github.com.pages.BootstrapPage.spinnerWithTextInfo;
import static io.github.com.pages.BootstrapPage.spinnerWithTextLight;
import static io.github.com.pages.BootstrapPage.spinnerWithTextPrimary;
import static io.github.com.pages.BootstrapPage.spinnerWithTextSecondary;
import static io.github.com.pages.BootstrapPage.spinnerWithTextSuccess;
import static io.github.com.pages.BootstrapPage.spinnerWithTextWarning;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;

public class ColorSpinnersTests extends TestsInit {

    @DataProvider(name = "Color Spinners")
    public static Object[][] colorSpinners() {
        return new Object[][]{
                {spinnerWithTextPrimary, "text-primary"},
                {spinnerWithTextSecondary, "text-secondary"},
                {spinnerWithTextDanger, "text-danger"},
                {spinnerWithTextWarning, "text-warning"},
                {spinnerWithTextSuccess, "text-success"},
                {spinnerWithTextInfo, "text-info"},
                {spinnerWithTextLight, "text-light"},
                {spinnerWithTextDark, "text-dark"}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "Color Spinners")
    public void assertColorTests(ColorSpinner colorSpinner, String color) {
        colorSpinner.is().color(color);
    }

    @Test(dataProvider = "Color Spinners")
    public void assertSpinnerColorTests(ColorSpinner colorSpinner, String color) {
        colorSpinner.is()
                .core()
                .cssClass(containsString(color));
    }

    @Test(dataProvider = "Color Spinners")
    public void assertColorByHasClassTests(ColorSpinner colorSpinner, String color) {
        colorSpinner.core().hasClass("spinner-border" + color);
    }

    @Test(dataProvider = "Color Spinners")
    public void isValidationTest(ColorSpinner colorSpinner, String __) {
        colorSpinner.is()
                .displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass(containsString("spinner-border"))
                .attr("role", "status");
    }
}
