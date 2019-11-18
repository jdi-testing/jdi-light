package io.github.epam.bootstrap.tests.common.progress;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.progressBackgroundBlue;
import static io.github.com.pages.BootstrapPage.progressBackgroundGreen;
import static io.github.com.pages.BootstrapPage.progressBackgroundRed;
import static io.github.com.pages.BootstrapPage.progressBackgroundYellow;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Mariia Tikhonova on 04.10.2019
 * Email: mariia_tikhonova@epam.com, Skype: mariatikhonova5_2
 */

public class ProgressBackgroundTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
    }

    @DataProvider(name = "progressBackgrounds")
    public static Object[][] progressBackgrounds() {
        return new Object[][]{
                {progressBackgroundGreen},
                {progressBackgroundBlue},
                {progressBackgroundYellow},
                {progressBackgroundRed}
        };
    }

    @DataProvider(name = "progressBackgroundsWithAttributes")
    public static Object[][] progressBackgroundsWithAttributes() {
        return new Object[][]{
                {progressBackgroundGreen, 25, "rgba(40, 167, 69, 1)"},
                {progressBackgroundBlue, 50, "rgba(23, 162, 184, 1)"},
                {progressBackgroundYellow, 75, "rgba(255, 193, 7, 1)"},
                {progressBackgroundRed, 100, "rgba(220, 53, 69, 1)"}
        };
    }

    @Test(dataProvider = "progressBackgrounds")
    public void baseValidationTest(ICoreElement progressBackground) {
        baseValidation(progressBackground);
    }

    @Test(dataProvider = "progressBackgroundsWithAttributes")
    public void isValidationTest(ICoreElement progressBackground, int widthNumber, String color) {
        progressBackground.core().is()
                .tag(is("div"))
                .attr("role", "progressbar")
                .attr("style", String.format("width: %s%%;", widthNumber))
                .attr("aria-valuenow", widthNumber + "")
                .attr("aria-valuemin", "0")
                .attr("aria-valuemax", "100")
                .css("background-color", color);
    }
}
